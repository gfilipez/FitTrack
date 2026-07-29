package com.gfilipe.fittrack;

import java.util.Arrays;
import java.util.List;

import com.gfilipe.fittrack.Models.Exercise;
import com.gfilipe.fittrack.Models.InfoItem;
import com.gfilipe.fittrack.Models.MealOption;
import com.gfilipe.fittrack.Models.MealSlot;
import com.gfilipe.fittrack.Models.Recipe;
import com.gfilipe.fittrack.Models.WorkoutDay;

/**
 * Conteúdo transcrito das capturas de ecrã do plano pessoal do utilizador.
 * Só inclui o que estava efetivamente visível nas capturas -- treinos e
 * refeições em falta podem ser adicionados aqui mais tarde, seguindo o
 * mesmo formato.
 */
public class PlanData {

    static final String FRUIT_ALT =
        "Alternativas: Banana pequena OU 90g uvas/cerejas OU 1 maçã/ dióspiro/ pera/ laranja/ pêssego OU " +
        "2 kiwi/ maracujá/ tangerina/ figo/ ameixa OU 1/2 romã/manga/pitaya OU 180g ananás/ papaia/ " +
        "frutos vermelhos OU 200g morangos/ melancia/ melão/ meloa";

    static final String NUTS_ALT =
        "Alternativas: 6 Amendoim OU 3 Caju OU 8 Amêndoa OU 8 Avelã OU 2 Castanha do Brasil OU 2 Noz OU 6 Pistáchio";

    public static final List<WorkoutDay> WORKOUTS = Arrays.asList(
        new WorkoutDay("treino_b", "Treino B (inferiores)", "Quarta-feira", Arrays.asList(
            new Exercise("Agachamento Búlgaro", "3 séries / 10 cada lado reps / 90segs descanso"),
            new Exercise("Agachamento sumo com insistência", "3 séries / 15 reps / 60segs descanso"),
            new Exercise("Stiff com garrafas", "3 séries / 15 reps / 60segs descanso"),
            new Exercise("Lunge estático com garrafas", "3 séries / 15 cada perna reps / 60segs descanso"),
            new Exercise("Agachamento frontal haltere", "3 séries / 12 reps / 60segs descanso"),
            new Exercise("Bicicleta/elíptica/passadeira OU caminhada", "20min")
        ))
    );

    public static final List<MealSlot> MEAL_SLOTS = Arrays.asList(
        new MealSlot("refeicao_1", "Refeição 1 (pequeno-almoço)", Arrays.asList(
            new MealOption("crepe_manteiga_amendoim", "Crepe manteiga de amendoim + fruta",
                Arrays.asList(
                    "100g Claras de ovo — OU 14g claras em pó em 100mL de água OU 3 claras de ovo",
                    "30g Farinha de aveia - sabor bolacha maria",
                    "40ml Leite proteico",
                    "15g Manteiga 100% amendoim",
                    "1 Peça de fruta — " + FRUIT_ALT
                ),
                "Juntar todos os ingredientes e levar à frigideira anti-aderente, sem adição de gordura. " +
                    "Colocar pouca massa de forma aos crepes ficarem finos. Topping: 15g manteiga de amendoim.",
                null),
            new MealOption("bowl_iogurte_grego", "Bowl iogurte grego + cereais + fruta", Arrays.asList(
                "180g Iogurte grego magro",
                "40g Cereais pequeno-almoço — Alternativas: 40g Cereais Chocapic OU 40g Cereais Nesquik OU 40g Cereais de aveia",
                "1 Peça de fruta — " + FRUIT_ALT
            )),
            new MealOption("tosta_mista_iogurte", "Tosta/sandes mista + iogurte + fruta", Arrays.asList(
                "2 Fatia de pão 25gr",
                "2 Fatia de queijo magro",
                "1 Fatia de fiambre de aves",
                "1 Iogurte magro 0% açúcar (líquido OU sólido)",
                "1 Peça de fruta — " + FRUIT_ALT
            )),
            new MealOption("torradas_manteiga", "Torradas com manteiga + leite proteico + fruta"),
            new MealOption("torradas_queijo_fresco", "Torradas com queijo fresco + leite proteico + fruta"),
            new MealOption("torradas_queijo_barrar", "Torradas com queijo de barrar + leite proteico + fruta"),
            new MealOption("torrada_ovos_fiambre", "Torrada com ovos e fiambre + fruta"),
            new MealOption("panqueca_aveia_banana", "Panqueca de aveia de banana + leite proteico")
        )),
        new MealSlot("refeicao_2", "Refeição 2 (almoço)",
            "Em todos os pratos estão contabilizados:\n" +
            "Legumes: 2 a 3 conchas de sopa sem batata/azeite + 200g salada/legumes (sem adição de azeite)\n" +
            "Gordura: 5 mL de azeite para a confeção do prato\n" +
            "Sobremesa: 1 peça de fruta até 150g (exceto banana)",
            Arrays.asList(
                new MealOption("massa_frango_natas", "Massa de frango com natas",
                    Arrays.asList(
                        "150g Massa cozida",
                        "150g Peito de frango/peru",
                        "80g Natas de soja light — Alternativas: 48g Natas levíssima -70% gordura",
                        "150g Salada/legumes"
                    ),
                    "Cozer a massa em água com sal até ficar al dente, escorrer e reservar. Cortar o frango em " +
                        "cubos e temperar com sal, pimenta e alho…",
                    null),
                new MealOption("salada_grao_atum", "Salada de grão e atum", Arrays.asList(
                    "200g Salada/legumes",
                    "160g Grão de bico",
                    "1 Atum natural em lata",
                    "2 Ovo"
                )),
                new MealOption("massa_camarao", "Massa com camarão"),
                new MealOption("wraps_atum", "2 Wraps de atum"),
                new MealOption("massa_camarao_natas", "Massa de camarão com natas"),
                new MealOption("salada_bacalhau", "Salada de bacalhau",
                    Arrays.asList(
                        "200g Salada/legumes",
                        "180g Bacalhau",
                        "160g Grão de bico",
                        "1 Ovo"
                    ),
                    null,
                    "(imagens meramente ilustrativas)")
            )),
        new MealSlot("refeicao_3", "Refeição 3 (lanche)", Arrays.asList(
            new MealOption("iogurte_proteico_barrita", "Iogurte proteico + barrita de cereais + fruta + frutos secos",
                Arrays.asList(
                    "1 Iogurte proteico líquido 20-25gr",
                    "1 Barrita de cereais",
                    "1 1/2 peça de fruta — " + FRUIT_ALT,
                    "10g Frutos secos — " + NUTS_ALT
                )),
            new MealOption("bolo_cenoura_iogurte", "Bolo de cenoura + iogurte magro + fruta",
                Arrays.asList(
                    "1 Ovo",
                    "60g Cenoura",
                    "25g Farinha de aveia - sabor bolacha maria",
                    "Fermento",
                    "10g Chocolate negro",
                    "1 Iogurte magro 0% açúcar (líquido OU sólido)",
                    "1 Peça de fruta — " + FRUIT_ALT
                ),
                "Liquidificar o ovo com a cenoura ralada e juntar depois a aveia e o fermento. Levar ao " +
                    "forno/airfryer OU frigideira. Cobrir com o chocolate negro a derreter por cima.",
                null),
            new MealOption("bolo_iogurte_fruta", "Bolo de iogurte + fruta",
                Arrays.asList(
                    "1 Ovo",
                    "1 Iogurte magro sólido",
                    "35g Farinha de aveia - sabor bolacha maria",
                    "Fermento",
                    "20g Doce de frutos 0% açúcar Casa Mateus (opcional)",
                    "1 Peça de fruta — " + FRUIT_ALT
                ),
                "Juntar todos os ingredientes e levar ao microondas/airfryer/forno. Topping de doce de " +
                    "frutos 0% açúcar.",
                "(imagens meramente ilustrativas)"),
            new MealOption("tosta_mista_skyr", "Tosta/sandes mista + iogurte skyr + fruta", Arrays.asList(
                "2 Fatia de pão 25gr",
                "1 Fatia de queijo magro",
                "1 Fatia de fiambre de aves",
                "1 Iogurte skyr 150g (sólido OU líquido)",
                "1 Peça de fruta — " + FRUIT_ALT
            ))
        )),
        new MealSlot("refeicao_4", "Refeição 4 (jantar)",
            "Em todos os pratos estão contabilizados:\n" +
            "Legumes: 2 a 3 conchas de sopa sem batata/azeite + 200g salada/legumes (sem adição de azeite)\n" +
            "Gordura: 5 mL de azeite para a confeção do prato",
            Arrays.asList(
                new MealOption("arroz_massa_batata_carnes", "Arroz/massa/batata + carnes/peixes"),
                new MealOption("bacalhau_natas", "Bacalhau com natas"),
                new MealOption("bife_batata_frita", "Bife com batata \"frita\"", Arrays.asList(
                    "170g Batata pré frita congelada palitos (fazer na airfryer OU forno)",
                    "150g Bife de vaca",
                    "100g Salada/legumes"
                )),
                new MealOption("pizza_wrap_margherita", "Pizza wrap margherita com fiambre", Arrays.asList(
                    "2 Wrap 40gr",
                    "80g Polpa de tomate — adicionar especiarias, sal, pimenta, alho em pó a gosto",
                    "60g Queijo mozzarella light ralado",
                    "2 Fatia de fiambre de aves"
                )),
                new MealOption("prego_no_pao", "Prego no pão", Arrays.asList(
                    "1 Pão bijou (50g)",
                    "150g Bife de vaca",
                    "1 Fatia de fiambre de aves",
                    "150g Salada/legumes"
                ))
            )),
        new MealSlot("refeicao_5", "Refeição 5 (sobremesa ou ceia) - se precisar", Arrays.asList(
            new MealOption("fruta_preferencial", "Fruta - preferencial",
                Arrays.asList("1 Peça de fruta — " + FRUIT_ALT)),
            new MealOption("acai_granola", "Açaí com granola"),
            new MealOption("pudim_proteico_5", "Pudim proteico", Arrays.asList("1 Pudim proteico com natas")),
            new MealOption("iogurte_proteico_fruta_5", "Iogurte proteico + fruta"),
            new MealOption("torrada_doce_iogurte", "Torrada com doce + iogurte", Arrays.asList(
                "1 Fatia de pão 25gr",
                "15g Doce de frutos 0% açúcar Casa Mateus",
                "1 Iogurte skyr 150g (sólido OU líquido)"
            )),
            new MealOption("gelado_150kcal", "Gelado até 150 kcal"),
            new MealOption("batata_frita_20g", "20gr de batata frita", Arrays.asList("20g Batata frita de pacote")),
            new MealOption("filipinos_oreos", "2 filipinos OU 2 oreos", Arrays.asList("2 Filipinos OU 2 oreos")),
            new MealOption("kinder_bueno", "1 barrita kinder bueno", Arrays.asList("1 Barrita kinder bueno")),
            new MealOption("kitkat", "Kitkat", Arrays.asList("0.5 Kitkat")),
            new MealOption("chocolate_20g", "20g chocolate"),
            new MealOption("kinder_pequena", "1 barrita kinder pequena", Arrays.asList("1 Barrita kinder pequena"))
        )),
        new MealSlot("refeicao_extra", "Refeição extra",
            "Esta é uma refeição extra que pode fazer numa hora do dia à sua escolha, se assim sentir necessidade.",
            Arrays.asList(
                new MealOption("iogurte_proteico_fruta_extra", "Iogurte proteico + fruta"),
                new MealOption("iogurte_proteico_bolacha", "Iogurte proteico + bolacha maria", Arrays.asList(
                    "1 Iogurte skyr 150g (sólido OU líquido)",
                    "3 Bolachas maria 0% açúcar"
                )),
                new MealOption("pudim_proteico_extra", "Pudim proteico", Arrays.asList("1 Pudim proteico com natas")),
                new MealOption("barrita_cereais_iogurte", "Barrita cereais + iogurte proteico", Arrays.asList(
                    "1 Barrita de cereais",
                    "1 Iogurte skyr 150g (sólido OU líquido)"
                )),
                new MealOption("frutos_secos_iogurte", "Frutos secos + iogurte proteico", Arrays.asList(
                    "10g Frutos secos — " + NUTS_ALT,
                    "1 Iogurte skyr 150g (sólido OU líquido)"
                )),
                new MealOption("sandes_queijo", "Sandes de queijo", Arrays.asList(
                    "2 Fatia de pão 25gr",
                    "1 Fatia de queijo magro"
                )),
                new MealOption("palitos_vaca_ri", "Palitos Vaca que ri light + fruta")
            ))
    );

    public static final List<Recipe> RECIPES = Arrays.asList(
        new Recipe("bacalhau_dourado", "Bacalhau dourado", "Receita elaborada e cedida pela Sandra",
            Arrays.asList(
                "Lombos de bacalhau (já demolhado, pronto a cozinhar)", "Batata", "Sal a gosto",
                "Pitada de pimentão doce", "1/2 colher de sopa de azeite", "Salsa a gosto", "Azeitonas a gosto",
                "— Cebolada —", "Cebolas", "Dentes de alho", "1/2 colher de sopa de azeite", "2 folhas de louro",
                "30 ml de vinagre", "Sal a gosto", "Pitada de pimentão doce"
            ),
            "Dica: servir com salada verde.\n\n" +
                "1. Descascar e cortar a batata em cubos pequenos.\n" +
                "2. Colocar a batata numa tigela e cobrir com água. Deixar demolhar 10 min.\n" +
                "3. Secar o bacalhau descongelado com papel absorvente.\n" +
                "4. Escorrer e secar a batata. Temperar com sal, pimentão doce e metade do azeite.\n" +
                "5. Untar uma assadeira ou cesto da airfryer com 1/4 do azeite.\n" +
                "6. Colocar metade da assadeira com a batata temperada. Na outra metade, colocar o bacalhau e " +
                "pincelar com o restante azeite.\n" +
                "7. Cozinhar na airfryer a 200ºC por 15 min. Depois baixar para 180ºC e cozinhar mais 10 min. " +
                "No forno pré-aquecido a 200º, 20 min.\n\n" +
                "Cebolada:\n" +
                "1. Cortar as cebolas em meias-luas e laminar o alho.\n" +
                "2. Numa frigideira, juntar cebola, alho, azeite e folhas de louro. Tapar e cozinhar em lume baixo " +
                "para a cebola largar líquido.\n" +
                "3. Após 5 min, destapar e adicionar o sal. Tapar novamente para ajudar a cebola a \"transpirar\".\n" +
                "4. Adicionar o vinagre, que vai ajudar a soltar os açúcares naturais e caramelizar levemente.\n" +
                "5. Cozinhar em lume médio-baixo por mais 5 min, mexendo de vez ocasionalmente.\n\n" +
                "Finalização:\n" +
                "Lascar o bacalhau, retirando peles e espinhas.\n" +
                "Misturar com as batatas, a cebolada, salsa picada e azeitonas a gosto."),
        new Recipe("ovos_escalfados_grao_courgette", "Ovos escalfados com grão de bico e courgette",
            "Receita elaborada e cedida pela Sandra",
            Arrays.asList(
                "1 1/2 colher de sopa de azeite", "1 cebola", "1 colher de chá de salsa seca e especiarias a gosto",
                "1/2 lata de tomate em pedaços", "3 colheres de sopa de polpa de tomate",
                "1/2 courgette partida em pequenos cubos", "Grão de bico cozido", "Ovos", "15g de queijo ralado"
            ),
            "1. Levar ao lume uma frigideira larga com o azeite e a cebola. Temperar com salsa e especiarias.\n" +
                "2. Quando a cebola amolecer, acrescentar a courgette, depois o tomate e a polpa. Cozinhar 2 a 3 min.\n" +
                "3. Juntar o grão de bico, sal, retificar os temperos e cor (pode adicionar mais uma colher de sopa " +
                "de polpa e salsa seca), regar com 50 a 100ml de água e deixar ferver até a courgette estar tenra.\n" +
                "4. Colocar os ovos.\n" +
                "5. Polvilhar com queijo ralado em volta dos ovos.\n" +
                "6. Polvilhar com + salsa ou orégãos.\n" +
                "7. Tapar e cozinhar até a clara branca."),
        new Recipe("gratinado_bacalhau", "Gratinado de Bacalhau",
            "Gratinado de bacalhau com courgette — receita elaborada e cedida por Sandra",
            Arrays.asList(
                "Posta de bacalhau demolhado", "Cebolas", "3 dentes de alho",
                "1/2 colher de azeite + spray para untar a assadeira", "1 colher de sopa de salsa picada", "Sal",
                "1 courgette grande ou 2 pequenas", "Pão ralado q.b.", "1 mão cheia de espinafres",
                "Natas de soja light OU natas light (usar com -70% de gordura)", "30g de queijo ralado"
            ),
            "1. Cozer o bacalhau. Reservar 1/2 copo da água de cozedura. Partir em lascas, livrando-se de " +
                "pele e espinhas.\n" +
                "2. Levar ao lume uma frigideira larga com as cebolas partidas em meias-luas e o azeite. Quando " +
                "quente, adicionar o alho picado. Cozinhar em lume brando até a cebola amolecer, juntar um pouco " +
                "de água de cozer o bacalhau se estiver a ficar muito seco. Acrescentar também a salsa picada.\n" +
                "3. Envolver o bacalhau, misturar e cozinhar mais 2 min.\n" +
                "4. Untar uma assadeira com azeite.\n" +
                "5. Partir a courgette em rodelas finas.\n" +
                "6. Passá-las por pão ralado. Cobrir o fundo da assadeira com elas.\n" +
                "7. Por cima espalhar o bacalhau, depois os espinafres partidos.\n" +
                "8. Espalhar 80g das natas.\n" +
                "9. Fazer uma segunda camada de courgette passada por pão ralado.\n" +
                "10. Espalhar as restantes natas, polvilhar com queijo ralado.\n" +
                "11. Levar ao forno pré-aquecido a 180ºC, 30 a 40min."),
        new Recipe("frango_legumes_natas", "Frango com legumes e natas",
            Arrays.asList(
                "Peito de frango", "Cenoura", "Ervilhas", "Pimentos", "1/2 colher de chá de curcuma (ou açafrão)",
                "1/2 colher de chá de pimentão doce (paprika)", "1 colher de chá de alho em pó",
                "Natas de soja light ou natas light ou leite de coco light",
                "100ml de leite magro + 1/2 colher de sopa de amido de milho (maisena)"
            ),
            "1. Misturar o frango com sal, alho em pó, pimentão doce, salsa seca e o amido de milho.\n" +
                "2. Aquecer uma frigideira larga. Untar com o azeite.\n" +
                "3. Quando bem quente, juntar o frango e saltear em lume alto até dourar. Retirar.\n" +
                "4. Na mesma frigideira, adicionar a cenoura cortada em rodelas, as ervilhas, os pimentos " +
                "cortados em cubos.\n" +
                "5. Juntar 100ml de água e deixar cozinhar 5 min.\n" +
                "6. Temperar com sal, curcuma, pimentão doce e alho em pó. Misturar e acrescentar o frango " +
                "reservado. Ferver mais 5 min.\n" +
                "7. Adicionar o creme de soja.\n" +
                "8. Dissolver o amido de milho no leite e também juntar.\n" +
                "9. Deixar levantar fervura novamente (acrescentar um pouco de água se achar necessário)."),
        new Recipe("filetes_peixe_courgette", "Filetes de peixe em courgette",
            "Receita elaborada e cedida por Sandra",
            Arrays.asList(
                "Batatas", "1 courgette", "Tomate em pedaços", "Dentes de alho picados",
                "Tempero: 1 colher de chá de pimentão doce, salsa seca, coentros secos, sal + 1/4 colher de chá " +
                    "de gengibre e curcuma em pó (opcional)",
                "Filetes de peixe a gosto (usar peixe-gato, por exemplo)", "Cebola", "1/2 colher de sopa de azeite",
                "Salsa fresca q.b."
            ),
            "1. Partir as batatas e a courgette em rodelas.\n" +
                "2. Adicionar o tomate, o alho picado e os temperos. Misturar.\n" +
                "3. Com o molho que se forma, barrar os filetes.\n" +
                "4. Levar ao lume uma frigideira larga com a cebola cortada. Regar com o azeite.\n" +
                "5. Por cima espalhar as rodelas de batata, depois as de courgette e dispor os filetes no final.\n" +
                "6. Acrescentar a marinada e um pouco de água (50 a 100ml).\n" +
                "7. Juntar salsa, tapar e deixar cozinhar 30 min em lume médio (não é necessário mexer)."),
        new Recipe("arroz_camarao_ovo", "Arroz de camarão com ovo", "Arroz de ovo com camarão e macedónia de legumes",
            Arrays.asList(
                "Miolo de camarão", "Spray de azeite", "1/2 colher de chá de alho em pó e pimentão doce para o camarão",
                "Ovo", "Macedónia de legumes congelado", "Alho em pó, cebola em pó, sal e salsa seca para temperar",
                "Arroz"
            ),
            "1. Cozer o arroz.\n" +
                "2. Aquecer uma frigideira antiaderente untada com o spray de azeite. Quando bem quente, colocar " +
                "o camarão. Polvilhar com o alho e pimentão doce, misturar e grelhar em lume alto até estarem " +
                "dourados. Retirar e reservar.\n" +
                "3. Na mesma frigideira, voltar a untar com o spray de azeite. Adicionar o ovo e mexer. Retirar " +
                "quando estiverem duros. Reservar.\n" +
                "4. Ainda na mesma frigideira, colocar a macedónia de legumes e o tempero. Misturar e mexer até " +
                "que perca o tom de congelado. Juntar um pouco de água e deixar cozinhar em lume médio/alto até " +
                "a água evaporar.\n" +
                "5. Envolver o arroz cozido, depois o ovo e no fim o camarão."),
        new Recipe("frango_a_bras", "Frango à Brás", "Receita cedida por Sandra Nereu",
            Arrays.asList(
                "1 peito de frango cozido ou assado, desfiado", "4 batatas", "2 cebolas", "2 dentes de alho",
                "4 ovos", "Salsa picada q.b.", "Sal q.b.", "Azeitonas para servir"
            ),
            "1. Cortar as batatas em rodelas finas e depois em palitos.\n" +
                "2. Secar bem com papel de cozinha, regar com azeite em spray.\n" +
                "3. Espalhar na airfryer e programar Fritar durante 10 minutos. Mexer e programar mais 5 minutos.\n" +
                "4. Enquanto isso, levar ao lume uma frigideira larga com as cebolas cortadas em meia-lua e uns " +
                "sprays de azeite.\n" +
                "5. Quando a cebola amolecer, juntar o alho picado e deixar dourar ligeiramente.\n" +
                "6. Juntar o frango desfiado, envolver e deixar ao lume até ganhar alguma cor.\n" +
                "7. Envolver a batata palha caseira e retirar do lume.\n" +
                "8. Bater os ovos, juntar ao preparado e envolver bem.\n" +
                "9. Juntar salsa picada a gosto.\n" +
                "10. Servir de imediato com azeitonas."),
        new Recipe("estufado_grao_bico_polvo", "Estufado de grão de bico e polvo",
            Arrays.asList(
                "1 cebola", "3 dentes de alho", "1/2 pimento vermelho", "1/2 pimento verde", "2 tomates",
                "Sal q.b.", "1 colher de chá de pimentão doce", "300g de polvo cozido",
                "400g de grão de bico cozido", "Salsa fresca para servir"
            ),
            "1. Partir a cebola, os pimentos e os tomates em pedaços. Descascar os dentes de alho. Num " +
                "processador de alimentos triturar estes alimentos juntos.\n" +
                "2. Passar para um tacho, acrescentar o azeite, sal e pimentão doce. Deixar ferver 10min, tapado " +
                "e em lume médio.\n" +
                "3. Adicionar o grão de bico, ferver mais 2 min.\n" +
                "4. Juntar o polvo cozido e partido em pedaços. Ferver mais 5 min para apurar os sabores.\n" +
                "Nota: pode trocar o polvo por tentáculos de pota ou lulas ou pedaços de peixe."),
        new Recipe("arroz_tosco_vitela", "Arroz tosco de vitela", "Ingredientes para 4 doses",
            Arrays.asList(
                "300g de carne magra picada (bife de vitela)", "1 cebola", "2 dentes de alho", "1 cenoura",
                "1 colher de chá de pimentão doce", "Pitada de flocos de piripiri (opcional)",
                "1/2 colher de chá de açafrão (opcional)", "100g de tomate em pedaços",
                "3 colheres de sopa de polpa de tomate", "200g de feijão encarnado cozido", "180g de arroz",
                "Sal", "Salsa fresca para servir"
            ),
            "1. Levar ao lume um tacho com o azeite. Quando quente, inserir a carne. Em lume alto, saltear " +
                "a carne até formar pequenas bolas.\n" +
                "2. Juntar a cebola picada, misturar e refogar 2 min.\n" +
                "3. Adicionar o alho, pimentão doce, piripiri, açafrão, tomate e polpa, a cenoura em pequenos cubos.\n" +
                "4. Misturar, adicionar 100ml de água e cozinhar em lume médio tapado 5 a 8 min.\n" +
                "5. Acrescentar o feijão, misturar, o arroz, 500ml de água, envolver, tapar.\n" +
                "6. Cozinhar até o arroz estar pronto e a água reduzida.\n" +
                "7. Servir com salsa fresca."),
        new Recipe("mini_hamburguer_atum", "Mini hambúrguer de atum",
            Arrays.asList(
                "270g de atum ao natural", "2 ovos", "1 colher de chá de orégãos", "Salsa fresca picada a gosto",
                "2 colheres de sopa de pão ralado (ou farinha de aveia ou farinha de amêndoa ou flocos de aveia " +
                    "triturados)"
            ),
            "1. Escorrer o atum. Esmagar com um garfo.\n" +
                "2. Misturar os restantes ingredientes.\n" +
                "3. Formar mini hambúrgueres.\n" +
                "4. Pincelar com azeite.\n\n" +
                "Cozinhar:\n" +
                "— Numa frigideira anti aderente untada até dourar\n" +
                "— Airfryer, função fritar, 185º, 15 min\n" +
                "— Forno pré-aquecido a 190º, 20min")
    );

    public static final List<String> RECIPE_TITLES_WITHOUT_DETAIL = Arrays.asList(
        "Pevide cremoso com ervilhas",
        "Bacalhau Gomes de Sá",
        "Bifes de peru recheados de tomate e queijo",
        "Lombos de Salmão com Citrinos"
    );

    public static final List<InfoItem> SUPPLEMENTS = Arrays.asList(
        new InfoItem("whey", "Whey OU proteína em pó",
            "Conteúdo informativo — o uso de suplementos não é obrigatório, se quiser adicionar enviar " +
                "mensagem no chat da app.\n\n" +
                "Whey protein é um suplemento que serve para aumentar o consumo de proteína no dia.\n" +
                "Uso sugerido como aumento da quantidade de proteína do plano, se pretender utilizar e não " +
                "estiver no seu plano comunique no chat para assim o fazermos, mas não é um suplemento ou " +
                "produto necessário para obter resultados, pois podemos ir buscar proteína a muitos outros " +
                "alimentos ricos em proteína.\n\n" +
                "Não deve ser considerado um suplemento, mas sim mais um alimento do plano rico em proteína, é " +
                "o mesmo tipo de proteína e aminoácidos encontrado no leite apenas filtrado para conter menos " +
                "hidratos e menos gordura tornando esta uma fonte mais pura de apenas proteína que pode fazer " +
                "parte de qualquer dieta.\n\n" +
                "Dá também versatilidade e paladar doce em algumas opções na dieta ao utilizar por exemplo em " +
                "panquecas/crepes/bolos sem aumentar o conteúdo de hidratos, mas sim de proteína das receitas " +
                "que usem whey."),
        new InfoItem("creatina", "Creatina monohidratada",
            "Conteúdo informativo, o uso de suplementos não é obrigatório, se quiser adicionar enviar " +
                "mensagem no chat da app."),
        new InfoItem("omega3", "Omega 3",
            "Conteúdo informativo, o uso de suplementos não é obrigatório, se quiser adicionar enviar " +
                "mensagem na chat da app."),
        new InfoItem("vitamina_d3", "Vitamina D3",
            "Conteúdo informativo, o uso de suplementos não é obrigatório, se quiser adicionar enviar " +
                "mensagem no chat da app."),
        new InfoItem("melatonina", "Melatonina",
            "Conteúdo informativo, o uso de suplementos não é obrigatório, se quiser adicionar enviar " +
                "mensagem no chat da app."),
        new InfoItem("psyllium", "Psyllium Husk",
            "Fibra alimentar para intestino preso e obstipação. Conteúdo informativo, o uso de " +
                "suplementos não é obrigatório, se quiser adicionar enviar mensagem no chat da app.\n\n" +
                "É o suplemento de fibra mais estudado e com melhores estudos científicos que comprovam eficácia " +
                "principalmente para pessoas que tendem a ter prisão de ventre. Pode ajudar a regular o " +
                "intestino e também já mostrou alguns benefícios na diminuição do colesterol, mas sem dúvida " +
                "mais utilizado para regular o intestino e aumentar a ingestão de fibra na dieta.\n\n" +
                "As doses normais e mais estudadas são de 10gr diárias para tratamento de obstipação, pode-se " +
                "usar juntando na água ou em algum alimento da dieta.\n\n" +
                "Usar uma fibra alimentar sem beber água suficiente pode atrapalhar ainda mais a obstipação, por " +
                "isso é fundamental manter uma boa ingestão de água com o uso deste suplemento.\n\n" +
                "*No caso de amamentação e gravidez o uso deve passar por aconselhamento médico.")
    );

    public static final List<InfoItem> GENERAL_NOTES = Arrays.asList(
        new InfoItem("agua", "Considerações sobre a importância do consumo de água",
            "Beber água ao longo do dia é essencial para um bom funcionamento metabólico. A ingestão " +
                "ajuda na digestão, na eliminação de toxinas e na regulação do trânsito intestinal. Um corpo " +
                "pouco hidratado vai comprometer os resultados. Deverá ingerir a quantidade de água suficiente " +
                "de modo a que a sua urina seja amarelo clara e sem cheiro.\n\n" +
                "Para isso, pode seguir as sugestões:\n" +
                "- tenha sempre água disponível à sua beira\n" +
                "- hidrate-se ao acordar e durante todas as refeições (lanches e refeições principais)\n" +
                "- não espere sentir sede para beber água\n" +
                "- aromatize a água com infusões"),
        new InfoItem("saltar_refeicoes", "Considerações sobre saltar refeições",
            "A reeducação alimentar é fundamental no processo de emagrecimento, dessa forma, é importante " +
                "aprender a fazer uma alimentação equilibrada e variada, que inclua 5 a 6 refeições diárias. " +
                "Tendo em conta este aspeto, deve evitar jejuns prolongados, nunca saltando refeições, mantendo " +
                "assim a saciedade, o correto funcionamento do metabolismo (o que ajuda a equilibrar o peso, os " +
                "níveis de açúcar no sangue e contribui para o bom funcionamento intestinal) e evitando episódios " +
                "de excessos alimentares. Quando só come quando tem fome e salta refeições, pode afetar " +
                "negativamente o metabolismo e a saúde de várias formas, pode levar a picos de açúcar no sangue " +
                "seguidos por quedas que aumentam o descontrolo do apetite. Além disso, o corpo pode começar a " +
                "armazenar mais gordura, pois sente que não há \"certeza\" de quando virá a próxima refeição, " +
                "dificultando a perda de peso. Dificulta ainda o trânsito intestinal e aumenta a sensação de " +
                "fadiga e cansaço."),
        new InfoItem("regras_gerais", "Regras gerais e substituições",
            "- Pesar todos os alimentos confecionados (menos a batata na airfryer que pesa a cru).\n\n" +
                "- Refeição livre tentar não ultrapassar 1300kcal na refeição livre (isto é um Menu fast food, " +
                "4/5 fatias de pizza, 15-20 peças de sushi (evitar as fritas), por exemplo.\n\n" +
                "- Pode usar sal, pimenta, pimentão doce, ervas aromáticas e outras especiarias em pó a gosto " +
                "(cebola/alho em pó/caril/açafrão) etc.\n\n" +
                "- Pode usar 10gr de ketchup e 10gr de maionese magra Calvé e 10gr de mostarda por dia.\n\n" +
                "- Pode usar arroz de cenoura, com cebola, brócolos, tomate ou outro legume, mantendo as mesmas " +
                "quantidades do plano.\n\n" +
                "- Pode combinar arroz com batata, colocando metade de arroz do plano com metade de batata do " +
                "plano, por exemplo.\n\n" +
                "- A batata cozida e crua têm o mesmo peso.\n\n" +
                "- Salada (alface, tomate, cenoura, pepino, pimentos, espinafres, beterraba, morangos, cebola, " +
                "rúcula por exemplo…), exceto milho e azeitonas que terá mais hidratos OU gordura.\n\n" +
                "- Sopa de legumes s/ batata 3 conchas (pode usar legumes a gosto por exemplo abóbora, couve " +
                "flor, aboborinha, espinafres, cogumelos, chuchu, cenoura, courgette, cebola, alho, alho " +
                "francês, couve…)\n\n" +
                "- Não comer mais do que 1x ao dia carne vermelha.\n\n" +
                "- Carne de vaca: cortes magros (redondo, vazia, pojadouro, acém, rabadilha, alcatra).")
    );
}
