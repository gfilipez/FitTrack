#!/data/data/com.termux/files/usr/bin/bash
# Instala as ferramentas necessárias e descarrega o android.jar (API 33).
# Corre isto UMA VEZ, dentro do Termux, antes do primeiro build.
set -e

echo "=== A instalar ferramentas de build ==="
pkg update -y
pkg install -y openjdk-17 aapt aapt2 apksigner dx zip unzip

echo ""
echo "=== A descarregar o Android SDK platform (android.jar, API 33) ==="
SDK_DIR="$HOME/android-sdk"
PLATFORM_ZIP="$HOME/platform-33.zip"
mkdir -p "$SDK_DIR"

if [ ! -f "$SDK_DIR/android.jar" ]; then
    curl -L -o "$PLATFORM_ZIP" \
        "https://dl.google.com/android/repository/platform-33_r02.zip"
    unzip -j -o "$PLATFORM_ZIP" "android-13/android.jar" -d "$SDK_DIR/"
    rm -f "$PLATFORM_ZIP"
    echo "   android.jar guardado em $SDK_DIR/android.jar"
else
    echo "   android.jar já existe, a saltar download"
fi

echo ""
echo "=== A gerar keystore de debug ==="
if [ ! -f "$HOME/.fittrack-debug.keystore" ]; then
    keytool -genkeypair \
        -keystore "$HOME/.fittrack-debug.keystore" \
        -alias debug \
        -keyalg RSA -keysize 2048 \
        -validity 10000 \
        -storepass android \
        -keypass android \
        -dname "CN=FitTrack Debug, OU=Debug, O=Debug, L=Debug, ST=Debug, C=PT"
    echo "   Keystore de debug criada."
else
    echo "   Keystore já existe, a saltar."
fi

echo ""
echo "=== Setup concluído ==="
echo "Agora corre: bash termux/build.sh"
