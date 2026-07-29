# FitTrack

App Android pessoal (Kotlin + Jetpack Compose) para consultares o teu plano de
treino e alimentação offline, sem depender de uma subscrição ativa. O
conteúdo (treinos, refeições, receitas, suplementos, notas gerais) foi
transcrito a partir das tuas próprias capturas de ecrã do plano.

Não usa o nome, logótipo nem a marca da app original — é uma app à parte,
só para uso pessoal.

## Como gerar o `.apk`

Este projeto ficou pronto a compilar, mas **não foi compilado neste
ambiente**: esta sessão corre numa sandbox cujo acesso de rede aos
servidores do Android (`dl.google.com` / `maven.google.com`, de onde vêm o
Android Gradle Plugin e as bibliotecas androidx) está bloqueado pela
política de rede do ambiente. Não é um erro pontual — é uma restrição fixa
da sandbox, por isso o `.apk` tem de ser gerado no teu computador, com
internet normal. Demora menos de um minuto.

### Opção A — Android Studio (mais simples)

1. Instala o [Android Studio](https://developer.android.com/studio) (gratuito).
2. `File > Open`, escolhe a pasta `FitTrack`.
3. Deixa o Gradle sincronizar (primeira vez demora alguns minutos, a
   descarregar dependências).
4. `Build > Build App Bundle(s) / APK(s) > Build APK(s)`.
5. O `.apk` fica em `app/build/outputs/apk/debug/app-debug.apk`. Podes
   instalá-lo diretamente no teu telemóvel (ativa "Fontes desconhecidas" /
   "Instalar apps desconhecidas" nas definições) ou correr diretamente num
   telemóvel ligado por USB com `Run ▶`.

### Opção B — linha de comandos

Precisas de ter o [Android SDK command-line tools](https://developer.android.com/studio#command-tools)
instalado (ou o Android Studio, que já o inclui).

```bash
cd FitTrack
./gradlew assembleDebug
```

O `.apk` fica em `app/build/outputs/apk/debug/app-debug.apk`.

## Estrutura do conteúdo

Todo o conteúdo está em
`app/src/main/java/com/gfilipe/fittrack/data/PlanData.kt`, um único ficheiro
Kotlin fácil de editar (sem precisares de tocar na interface). Inclui
apenas o que estava visível nas capturas de ecrã fornecidas:

- **Treinos**: 1 dia de treino (Treino B — inferiores, quarta-feira).
- **Refeições**: as 5 refeições do plano + refeição extra, com as opções e
  ingredientes que estavam visíveis.
- **Receitas**: 10 receitas completas (ingredientes + preparação) da secção
  "Conteúdos > Receitas".
- **Suplementos**: informação sobre whey, creatina, ómega 3, vitamina D3,
  melatonina e psyllium husk.
- **Notas gerais**: água, não saltar refeições, regras e substituições.

Para adicionares mais treinos, refeições ou receitas que não estavam nas
capturas, basta abrir `PlanData.kt` e seguir o mesmo formato dos itens já
existentes (é só copiar um bloco `WorkoutDay(...)`, `MealOption(...)` ou
`Recipe(...)` e preencher com o texto novo).

## Funcionalidades

- Navegação por Início, Treinos, Refeições, Receitas, Suplementos e Notas.
- Botão "Concluir" em cada treino, com o estado guardado no telemóvel
  (SharedPreferences) para saberes que dias já fizeste.
- Funciona 100% offline, sem login nem ligação a nenhum servidor.
