#!/data/data/com.termux/files/usr/bin/bash
# Compila o FitTrack.apk inteiramente no telemóvel, via Termux.
# Corre "bash termux/setup.sh" primeiro (só é preciso uma vez).
set -e

PROJECT="$(cd "$(dirname "$0")/.." && pwd)"
ANDROID_JAR="$HOME/android-sdk/android.jar"
KEYSTORE="$HOME/.fittrack-debug.keystore"
PACKAGE_PATH="com/gfilipe/fittrack"

BUILD="$PROJECT/build"
GEN="$BUILD/gen"
OBJ="$BUILD/obj"
APK_DIR="$BUILD/apk"

if [ ! -f "$ANDROID_JAR" ]; then
    echo "ERRO: android.jar não encontrado em $ANDROID_JAR"
    echo "Corre primeiro: bash termux/setup.sh"
    exit 1
fi

echo "=== A limpar builds antigos ==="
rm -rf "$GEN" "$OBJ" "$APK_DIR" "$BUILD/classes.dex"
mkdir -p "$GEN" "$OBJ" "$APK_DIR"

echo "=== Passo 1/5: Linkar recursos (aapt2) ==="
# Este projeto não usa ficheiros em res/ (tudo é construído por código), por
# isso só precisamos de "aapt2 link" com o manifesto, sem "aapt2 compile".
aapt2 link \
    -I "$ANDROID_JAR" \
    --manifest "$PROJECT/AndroidManifest.xml" \
    --java "$GEN" \
    -o "$APK_DIR/app-unaligned.apk" \
    --min-sdk-version 21 --target-sdk-version 33

echo "=== Passo 2/5: Compilar Java (javac) ==="
JAVA_FILES=$(find "$PROJECT/src" -name "*.java")
R_JAVA="$GEN/$PACKAGE_PATH/R.java"
if [ -f "$R_JAVA" ]; then
    JAVA_FILES="$R_JAVA $JAVA_FILES"
fi
javac -encoding UTF-8 -source 1.8 -target 1.8 -classpath "$ANDROID_JAR" -d "$OBJ" $JAVA_FILES

echo "=== Passo 3/5: Converter para DEX ==="
if command -v dx >/dev/null 2>&1; then
    dx --dex --output="$BUILD/classes.dex" "$OBJ"
elif command -v d8 >/dev/null 2>&1; then
    find "$OBJ" -name "*.class" > "$BUILD/classes.list"
    d8 --output "$BUILD" @"$BUILD/classes.list"
else
    echo "ERRO: não encontrei 'dx' nem 'd8'. Corre: pkg install dx"
    exit 1
fi

echo "=== Passo 4/5: Empacotar APK ==="
cp "$APK_DIR/app-unaligned.apk" "$APK_DIR/FitTrack.apk"
cd "$BUILD" && zip -j "$APK_DIR/FitTrack.apk" classes.dex
cd "$PROJECT"

echo "=== Passo 5/5: Assinar APK ==="
apksigner sign \
    --ks "$KEYSTORE" \
    --ks-key-alias debug \
    --ks-pass pass:android \
    --key-pass pass:android \
    "$APK_DIR/FitTrack.apk"

echo ""
echo "=== BUILD CONCLUÍDO ==="
ls -lh "$APK_DIR/FitTrack.apk"
echo ""
echo "Para instalar no telemóvel:"
echo "  termux-setup-storage   (só da primeira vez, para dar acesso ao armazenamento)"
echo "  cp \"$APK_DIR/FitTrack.apk\" ~/storage/shared/ && termux-open ~/storage/shared/FitTrack.apk"
