# FitTrack

App Android pessoal (Java puro, sem Gradle nem bibliotecas externas) para
consultares o teu plano de treino e alimentação offline, sem depender de
uma subscrição ativa. O conteúdo (treinos, refeições, receitas,
suplementos, notas gerais) foi transcrito a partir das tuas próprias
capturas de ecrã do plano.

Não usa o nome, logótipo nem a marca da app original — é uma app à parte,
só para uso pessoal.

## Porque não usa Gradle

Para conseguires compilar o `.apk` inteiramente no telemóvel (via Termux),
sem precisares de PC nem do Android Studio, esta app é escrita em Java
puro, sem AndroidX nem Jetpack Compose, com a interface toda construída
por código (sem ficheiros de layout XML). Isto permite compilar com um
conjunto mínimo de ferramentas de linha de comandos (`aapt2`, `javac`,
`dx`, `apksigner`), todas instaláveis diretamente no Termux.

## Como compilar o `.apk` no telemóvel (Termux)

1. Instala a app **Termux** (recomendado via [F-Droid](https://f-droid.org/packages/com.termux/),
   a versão da Play Store está desatualizada).
2. Dentro do Termux, clona ou copia esta pasta `FitTrack` para o telemóvel.
   Por exemplo, se tiveres o repositório no GitHub:
   ```bash
   pkg install -y git
   git clone <URL_DO_TEU_REPOSITORIO> FitTrack
   cd FitTrack
   ```
3. Corre o setup (só precisas de fazer isto uma vez):
   ```bash
   bash termux/setup.sh
   ```
   Isto instala o `openjdk-17`, `aapt`, `aapt2`, `apksigner`, `dx` e `zip`,
   descarrega o `android.jar` (API 33) diretamente dos servidores da
   Google, e gera uma keystore de debug para assinar o `.apk`.
4. Compila:
   ```bash
   bash termux/build.sh
   ```
   O `.apk` final fica em `build/apk/FitTrack.apk`.
5. Instala no telemóvel:
   ```bash
   termux-setup-storage   # só da primeira vez
   cp build/apk/FitTrack.apk ~/storage/shared/ && termux-open ~/storage/shared/FitTrack.apk
   ```
   O Android vai pedir para confirmares a instalação (ativa "instalar apps
   desconhecidas" para o Termux, se for pedido).

Sempre que quiseres atualizar a app (por exemplo depois de editares
`PlanData.java`), basta repetir o passo 4 e reinstalar.

### Nota sobre o `dx`

Alguns telemóveis/versões do Termux podem já não ter o pacote `dx`
disponível (foi substituído por `d8` no ecossistema oficial do Android). O
script `build.sh` tenta `dx` primeiro e usa `d8` como alternativa
automaticamente, se o `dx` não existir.

## Estrutura do conteúdo

Todo o conteúdo está em `src/com/gfilipe/fittrack/PlanData.java`, um único
ficheiro Java fácil de editar (sem precisares de tocar na interface).
Inclui apenas o que estava visível nas capturas de ecrã fornecidas:

- **Treinos**: 1 dia de treino (Treino B — inferiores, quarta-feira).
- **Refeições**: as 5 refeições do plano + refeição extra, com as opções e
  ingredientes que estavam visíveis.
- **Receitas**: 10 receitas completas (ingredientes + preparação) da secção
  "Conteúdos > Receitas".
- **Suplementos**: informação sobre whey, creatina, ómega 3, vitamina D3,
  melatonina e psyllium husk.
- **Notas gerais**: água, não saltar refeições, regras e substituições.

Para adicionares mais treinos, refeições ou receitas que não estavam nas
capturas, basta abrir `PlanData.java` (no telemóvel, com o editor de texto
do Termux, `nano` ou `vim`, ou com qualquer app de edição de código) e
seguir o mesmo formato dos itens já existentes — depois corre outra vez
`bash termux/build.sh`.

## Funcionalidades

- Navegação por Início, Treinos, Refeições, Receitas, Suplementos e Notas,
  com botão "← Voltar" e suporte ao botão de recuar do telemóvel.
- Botão "Concluir" em cada treino, com o estado guardado no telemóvel
  (SharedPreferences) para saberes que dias já fizeste.
- Funciona 100% offline, sem login nem ligação a nenhum servidor.

## Estrutura do projeto

```
FitTrack/
├── AndroidManifest.xml
├── src/com/gfilipe/fittrack/
│   ├── MainActivity.java   (navegação e interface, tudo por código)
│   ├── Models.java         (classes de dados: Exercise, Recipe, etc.)
│   └── PlanData.java       (todo o conteúdo do plano)
└── termux/
    ├── setup.sh            (instala ferramentas, corre uma vez)
    └── build.sh            (compila o FitTrack.apk)
```
