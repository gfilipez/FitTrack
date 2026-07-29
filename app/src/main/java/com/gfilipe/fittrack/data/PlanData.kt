package com.gfilipe.fittrack.data

/**
 * Conteúdo transcrito das capturas de ecrã do plano pessoal do utilizador.
 * Só inclui o que estava efetivamente visível nas capturas — os treinos e
 * refeições em falta podem ser adicionados aqui mais tarde, seguindo o
 * mesmo formato.
 */
object PlanData {

    val fruitAlternatives =
        "Alternativas: Banana pequena OU 90g uvas/cerejas OU 1 maçã/ dióspiro/ pera/ laranja/ pêssego OU " +
            "2 kiwi/ maracujá/ tangerina/ figo/ ameixa OU 1/2 romã/manga/pitaya OU 180g ananás/ papaia/ " +
            "frutos vermelhos OU 200g morangos/ melancia/ melão/ meloa"

    val nutsAlternatives =
        "Alternativas: 6 Amendoim OU 3 Caju OU 8 Amêndoa OU 8 Avelã OU 2 Castanha do Brasil OU 2 Noz OU 6 Pistáchio"

    // ---------------- TREINOS ----------------
    val workouts = listOf(
        WorkoutDay(
            id = "treino_b",
            title = "Treino B (inferiores)",
            subtitle = "Quarta-feira",
            exercises = listOf(
                Exercise("Agachamento Búlgaro", "3 séries / 10 cada lado reps / 90segs descanso"),
                Exercise("Agachamento sumo com insistência", "3 séries / 15 reps / 60segs descanso"),
                Exercise("Stiff com garrafas", "3 séries / 15 reps / 60segs descanso"),
                Exercise("Lunge estático com garrafas", "3 séries / 15 cada perna reps / 60segs descanso"),
                Exercise("Agachamento frontal haltere", "3 séries / 12 reps / 60segs descanso"),
                Exercise("Bicicleta/elíptica/passadeira OU caminhada", "20min")
            )
        )
    )

    // ---------------- REFEIÇÕES ----------------
    val mealSlots = listOf(
        MealSlot(
            id = "refeicao_1",
            title = "Refeição 1 (pequeno-almoço)",
            options = listOf(
                MealOption(
                    id = "crepe_manteiga_amendoim",
                    name = "Crepe manteiga de amendoim + fruta",
                    ingredients = listOf(
                        Ingredient("100g Claras de ovo — OU 14g claras em pó em 100mL de água OU 3 claras de ovo"),
                        Ingredient("30g Farinha de aveia - sabor bolacha maria"),
                        Ingredient("40ml Leite proteico"),
                        Ingredient("15g Manteiga 100% amendoim"),
                        Ingredient("1 Peça de fruta — $fruitAlternatives")
                    ),
                    prep = "Juntar todos os ingredientes e levar à frigideira anti-aderente, sem adição de gordura. " +
                        "Colocar pouca massa de forma aos crepes ficarem finos. Topping: 15g manteiga de amendoim."
                ),
                MealOption(
                    id = "bowl_iogurte_grego",
                    name = "Bowl iogurte grego + cereais + fruta",
                    ingredients = listOf(
                        Ingredient("180g Iogurte grego magro"),
                        Ingredient("40g Cereais pequeno-almoço — Alternativas: 40g Cereais Chocapic OU 40g Cereais Nesquik OU 40g Cereais de aveia"),
                        Ingredient("1 Peça de fruta — $fruitAlternatives")
                    )
                ),
                MealOption(
                    id = "tosta_mista_iogurte",
                    name = "Tosta/sandes mista + iogurte + fruta",
                    ingredients = listOf(
                        Ingredient("2 Fatia de pão 25gr"),
                        Ingredient("2 Fatia de queijo magro"),
                        Ingredient("1 Fatia de fiambre de aves"),
                        Ingredient("1 Iogurte magro 0% açúcar (líquido OU sólido)"),
                        Ingredient("1 Peça de fruta — $fruitAlternatives")
                    )
                ),
                MealOption(id = "torradas_manteiga", name = "Torradas com manteiga + leite proteico + fruta"),
                MealOption(id = "torradas_queijo_fresco", name = "Torradas com queijo fresco + leite proteico + fruta"),
                MealOption(id = "torradas_queijo_barrar", name = "Torradas com queijo de barrar + leite proteico + fruta"),
                MealOption(id = "torrada_ovos_fiambre", name = "Torrada com ovos e fiambre + fruta"),
                MealOption(id = "panqueca_aveia_banana", name = "Panqueca de aveia de banana + leite proteico")
            )
        ),
        MealSlot(
            id = "refeicao_2",
            title = "Refeição 2 (almoço)",
            note = "Em todos os pratos estão contabilizados:\n" +
                "Legumes: 2 a 3 conchas de sopa sem batata/azeite + 200g salada/legumes (sem adição de azeite)\n" +
                "Gordura: 5 mL de azeite para a confeção do prato\n" +
                "Sobremesa: 1 peça de fruta até 150g (exceto banana)",
            options = listOf(
                MealOption(
                    id = "massa_frango_natas",
                    name = "Massa de frango com natas",
                    ingredients = listOf(
                        Ingredient("150g Massa cozida"),
                        Ingredient("150g Peito de frango/peru"),
                        Ingredient("80g Natas de soja light — Alternativas: 48g Natas levíssima -70% gordura"),
                        Ingredient("150g Salada/legumes")
                    ),
                    prep = "Cozer a massa em água com sal até ficar al dente, escorrer e reservar. Cortar o frango em " +
                        "cubos e temperar com sal, pimenta e alho…"
                ),
                MealOption(
                    id = "salada_grao_atum",
                    name = "Salada de grão e atum",
                    ingredients = listOf(
                        Ingredient("200g Salada/legumes"),
                        Ingredient("160g Grão de bico"),
                        Ingredient("1 Atum natural em lata"),
                        Ingredient("2 Ovo")
                    )
                ),
                MealOption(id = "massa_camarao", name = "Massa com camarão"),
                MealOption(id = "wraps_atum", name = "2 Wraps de atum"),
                MealOption(id = "massa_camarao_natas", name = "Massa de camarão com natas"),
                MealOption(
                    id = "salada_bacalhau",
                    name = "Salada de bacalhau",
                    ingredients = listOf(
                        Ingredient("200g Salada/legumes"),
                        Ingredient("180g Bacalhau"),
                        Ingredient("160g Grão de bico"),
                        Ingredient("1 Ovo")
                    ),
                    note = "(imagens meramente ilustrativas)"
                )
            )
        ),
        MealSlot(
            id = "refeicao_3",
            title = "Refeição 3 (lanche)",
            options = listOf(
                MealOption(
                    id = "iogurte_proteico_barrita",
                    name = "Iogurte proteico + barrita de cereais + fruta + frutos secos",
                    ingredients = listOf(
                        Ingredient("1 Iogurte proteico líquido 20-25gr"),
                        Ingredient("1 Barrita de cereais"),
                        Ingredient("1 1/2 peça de fruta — $fruitAlternatives"),
                        Ingredient("10g Frutos secos — $nutsAlternatives")
                    )
                ),
                MealOption(
                    id = "bolo_cenoura_iogurte",
                    name = "Bolo de cenoura + iogurte magro + fruta",
                    ingredients = listOf(
                        Ingredient("1 Ovo"),
                        Ingredient("60g Cenoura"),
                        Ingredient("25g Farinha de aveia - sabor bolacha maria"),
                        Ingredient("Fermento"),
                        Ingredient("10g Chocolate negro"),
                        Ingredient("1 Iogurte magro 0% açúcar (líquido OU sólido)"),
                        Ingredient("1 Peça de fruta — $fruitAlternatives")
                    ),
                    prep = "Liquidificar o ovo com a cenoura ralada e juntar depois a aveia e o fermento. Levar ao " +
                        "forno/airfryer OU frigideira. Cobrir com o chocolate negro a derreter por cima."
                ),
                MealOption(
                    id = "bolo_iogurte_fruta",
                    name = "Bolo de iogurte + fruta",
                    ingredients = listOf(
                        Ingredient("1 Ovo"),
                        Ingredient("1 Iogurte magro sólido"),
                        Ingredient("35g Farinha de aveia - sabor bolacha maria"),
                        Ingredient("Fermento"),
                        Ingredient("20g Doce de frutos 0% açúcar Casa Mateus (opcional)"),
                        Ingredient("1 Peça de fruta — $fruitAlternatives")
                    ),
                    prep = "Juntar todos os ingredientes e levar ao microondas/airfryer/forno. Topping de doce de " +
                        "frutos 0% açúcar.",
                    note = "(imagens meramente ilustrativas)"
                ),
                MealOption(
                    id = "tosta_mista_skyr",
                    name = "Tosta/sandes mista + iogurte skyr + fruta",
                    ingredients = listOf(
                        Ingredient("2 Fatia de pão 25gr"),
                        Ingredient("1 Fatia de queijo magro"),
                        Ingredient("1 Fatia de fiambre de aves"),
                        Ingredient("1 Iogurte skyr 150g (sólido OU líquido)"),
                        Ingredient("1 Peça de fruta — $fruitAlternatives")
                    )
                )
            )
        ),
        MealSlot(
            id = "refeicao_4",
            title = "Refeição 4 (jantar)",
            note = "Em todos os pratos estão contabilizados:\n" +
                "Legumes: 2 a 3 conchas de sopa sem batata/azeite + 200g salada/legumes (sem adição de azeite)\n" +
                "Gordura: 5 mL de azeite para a confeção do prato",
            options = listOf(
                MealOption(id = "arroz_massa_batata_carnes", name = "Arroz/massa/batata + carnes/peixes"),
                MealOption(id = "bacalhau_natas", name = "Bacalhau com natas"),
                MealOption(
                    id = "bife_batata_frita",
                    name = "Bife com batata \"frita\"",
                    ingredients = listOf(
                        Ingredient("170g Batata pré frita congelada palitos (fazer na airfryer OU forno)"),
                        Ingredient("150g Bife de vaca"),
                        Ingredient("100g Salada/legumes")
                    )
                ),
                MealOption(
                    id = "pizza_wrap_margherita",
                    name = "Pizza wrap margherita com fiambre",
                    ingredients = listOf(
                        Ingredient("2 Wrap 40gr"),
                        Ingredient("80g Polpa de tomate — adicionar especiarias, sal, pimenta, alho em pó a gosto"),
                        Ingredient("60g Queijo mozzarella light ralado"),
                        Ingredient("2 Fatia de fiambre de aves")
                    )
                ),
                MealOption(
                    id = "prego_no_pao",
                    name = "Prego no pão",
                    ingredients = listOf(
                        Ingredient("1 Pão bijou (50g)"),
                        Ingredient("150g Bife de vaca"),
                        Ingredient("1 Fatia de fiambre de aves"),
                        Ingredient("150g Salada/legumes")
                    )
                )
            )
        ),
        MealSlot(
            id = "refeicao_5",
            title = "Refeição 5 (sobremesa ou ceia) - se precisar",
            options = listOf(
                MealOption(
                    id = "fruta_preferencial",
                    name = "Fruta - preferencial",
                    ingredients = listOf(Ingredient("1 Peça de fruta — $fruitAlternatives"))
                ),
                MealOption(id = "acai_granola", name = "Açaí com granola"),
                MealOption(
                    id = "pudim_proteico_5",
                    name = "Pudim proteico",
                    ingredients = listOf(Ingredient("1 Pudim proteico com natas"))
                ),
                MealOption(id = "iogurte_proteico_fruta_5", name = "Iogurte proteico + fruta"),
                MealOption(
                    id = "torrada_doce_iogurte",
                    name = "Torrada com doce + iogurte",
                    ingredients = listOf(
                        Ingredient("1 Fatia de pão 25gr"),
                        Ingredient("15g Doce de frutos 0% açúcar Casa Mateus"),
                        Ingredient("1 Iogurte skyr 150g (sólido OU líquido)")
                    )
                ),
                MealOption(id = "gelado_150kcal", name = "Gelado até 150 kcal"),
                MealOption(
                    id = "batata_frita_20g",
                    name = "20gr de batata frita",
                    ingredients = listOf(Ingredient("20g Batata frita de pacote"))
                ),
                MealOption(
                    id = "filipinos_oreos",
                    name = "2 filipinos OU 2 oreos",
                    ingredients = listOf(Ingredient("2 Filipinos OU 2 oreos"))
                ),
                MealOption(
                    id = "kinder_bueno",
                    name = "1 barrita kinder bueno",
                    ingredients = listOf(Ingredient("1 Barrita kinder bueno"))
                ),
                MealOption(
                    id = "kitkat",
                    name = "Kitkat",
                    ingredients = listOf(Ingredient("0.5 Kitkat"))
                ),
                MealOption(id = "chocolate_20g", name = "20g chocolate"),
                MealOption(
                    id = "kinder_pequena",
                    name = "1 barrita kinder pequena",
                    ingredients = listOf(Ingredient("1 Barrita kinder pequena"))
                )
            )
        ),
        MealSlot(
            id = "refeicao_extra",
            title = "Refeição extra",
            note = "Esta é uma refeição extra que pode fazer numa hora do dia à sua escolha, se assim sentir necessidade.",
            options = listOf(
                MealOption(id = "iogurte_proteico_fruta_extra", name = "Iogurte proteico + fruta"),
                MealOption(
                    id = "iogurte_proteico_bolacha",
                    name = "Iogurte proteico + bolacha maria",
                    ingredients = listOf(
                        Ingredient("1 Iogurte skyr 150g (sólido OU líquido)"),
                        Ingredient("3 Bolachas maria 0% açúcar")
                    )
                ),
                MealOption(
                    id = "pudim_proteico_extra",
                    name = "Pudim proteico",
                    ingredients = listOf(Ingredient("1 Pudim proteico com natas"))
                ),
                MealOption(
                    id = "barrita_cereais_iogurte",
                    name = "Barrita cereais + iogurte proteico",
                    ingredients = listOf(
                        Ingredient("1 Barrita de cereais"),
                        Ingredient("1 Iogurte skyr 150g (sólido OU líquido)")
                    )
                ),
                MealOption(
                    id = "frutos_secos_iogurte",
                    name = "Frutos secos + iogurte proteico",
                    ingredients = listOf(
                        Ingredient("10g Frutos secos — $nutsAlternatives"),
                        Ingredient("1 Iogurte skyr 150g (sólido OU líquido)")
                    )
                ),
                MealOption(
                    id = "sandes_queijo",
                    name = "Sandes de queijo",
                    ingredients = listOf(
                        Ingredient("2 Fatia de pão 25gr"),
                        Ingredient("1 Fatia de queijo magro")
                    )
                ),
                MealOption(id = "palitos_vaca_ri", name = "Palitos Vaca que ri light + fruta")
            )
        )
    )

    // ---------------- RECEITAS (Conteúdos > Receitas) ----------------
    val recipes = listOf(
        Recipe(
            id = "bacalhau_dourado",
            title = "Bacalhau dourado",
            source = "Receita elaborada e cedida pela Sandra",
            ingredients = listOf(
                "Lombos de bacalhau (já demolhado, pronto a cozinhar)",
                "Batata",
                "Sal a gosto",
                "Pitada de pimentão doce",
                "1/2 colher de sopa de azeite",
                "Salsa a gosto",
                "Azeitonas a gosto",
                "— Cebolada —",
                "Cebolas",
                "Dentes de alho",
                "1/2 colher de sopa de azeite",
                "2 folhas de louro",
                "30 ml de vinagre",
                "Sal a gosto",
                "Pitada de pimentão doce"
            ),
            prep = "Dica: servir com salada verde.\n\n" +
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
                "Misturar com as batatas, a cebolada, salsa picada e azeitonas a gosto."
        ),
        Recipe(
            id = "ovos_escalfados_grao_courgette",
            title = "Ovos escalfados com grão de bico e courgette",
            source = "Receita elaborada e cedida pela Sandra",
            ingredients = listOf(
                "1 1/2 colher de sopa de azeite",
                "1 cebola",
                "1 colher de chá de salsa seca e especiarias a gosto",
                "1/2 lata de tomate em pedaços",
                "3 colheres de sopa de polpa de tomate",
                "1/2 courgette partida em pequenos cubos",
                "Grão de bico cozido",
                "Ovos",
                "15g de queijo ralado"
            ),
            prep = "1. Levar ao lume uma frigideira larga com o azeite e a cebola. Temperar com salsa e especiarias.\n" +
                "2. Quando a cebola amolecer, acrescentar a courgette, depois o tomate e a polpa. Cozinhar 2 a 3 min.\n" +
                "3. Juntar o grão de bico, sal, retificar os temperos e cor (pode adicionar mais uma colher de sopa " +
                "de polpa e salsa seca), regar com 50 a 100ml de água e deixar ferver até a courgette estar tenra.\n" +
                "4. Colocar os ovos.\n" +
                "5. Polvilhar com queijo ralado em volta dos ovos.\n" +
                "6. Polvilhar com + salsa ou orégãos.\n" +
                "7. Tapar e cozinhar até a clara branca."
        ),
        Recipe(
            id = "gratinado_bacalhau",
            title = "Gratinado de Bacalhau",
            source = "Gratinado de bacalhau com courgette — receita elaborada e cedida por Sandra",
            ingredients = listOf(
                "Posta de bacalhau demolhado",
                "Cebolas",
                "3 dentes de alho",
                "1/2 colher de azeite + spray para untar a assadeira",
                "1 colher de sopa de salsa picada",
                "Sal",
                "1 courgette grande ou 2 pequenas",
                "Pão ralado q.b.",
                "1 mão cheia de espinafres",
                "Natas de soja light OU natas light (usar com -70% de gordura)",
                "30g de queijo ralado"
            ),
            prep = "1. Cozer o bacalhau. Reservar 1/2 copo da água de cozedura. Partir em lascas, livrando-se de " +
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
                "11. Levar ao forno pré-aquecido a 180ºC, 30 a 40min."
        ),
        Recipe(
            id = "frango_legumes_natas",
            title = "Frango com legumes e natas",
            ingredients = listOf(
                "Peito de frango",
                "Cenoura",
                "Ervilhas",
                "Pimentos",
                "1/2 colher de chá de curcuma (ou açafrão)",
                "1/2 colher de chá de pimentão doce (paprika)",
                "1 colher de chá de alho em pó",
                "Natas de soja light ou natas light ou leite de coco light",
                "100ml de leite magro + 1/2 colher de sopa de amido de milho (maisena)"
            ),
            prep = "1. Misturar o frango com sal, alho em pó, pimentão doce, salsa seca e o amido de milho.\n" +
                "2. Aquecer uma frigideira larga. Untar com o azeite.\n" +
                "3. Quando bem quente, juntar o frango e saltear em lume alto até dourar. Retirar.\n" +
                "4. Na mesma frigideira, adicionar a cenoura cortada em rodelas, as ervilhas, os pimentos " +
                "cortados em cubos.\n" +
                "5. Juntar 100ml de água e deixar cozinhar 5 min.\n" +
                "6. Temperar com sal, curcuma, pimentão doce e alho em pó. Misturar e acrescentar o frango " +
                "reservado. Ferver mais 5 min.\n" +
                "7. Adicionar o creme de soja.\n" +
                "8. Dissolver o amido de milho no leite e também juntar.\n" +
                "9. Deixar levantar fervura novamente (acrescentar um pouco de água se achar necessário)."
        ),
        Recipe(
            id = "filetes_peixe_courgette",
            title = "Filetes de peixe em courgette",
            source = "Filetes de peixe na frigideira em cama de courgette e batata — receita elaborada e cedida por Sandra",
            ingredients = listOf(
                "Batatas",
                "1 courgette",
                "Tomate em pedaços",
                "Dentes de alho picados",
                "Tempero: 1 colher de chá de pimentão doce, salsa seca, coentros secos, sal + 1/4 colher de chá " +
                    "de gengibre e curcuma em pó (opcional)",
                "Filetes de peixe a gosto (usar peixe-gato, por exemplo)",
                "Cebola",
                "1/2 colher de sopa de azeite",
                "Salsa fresca q.b."
            ),
            prep = "1. Partir as batatas e a courgette em rodelas.\n" +
                "2. Adicionar o tomate, o alho picado e os temperos. Misturar.\n" +
                "3. Com o molho que se forma, barrar os filetes.\n" +
                "4. Levar ao lume uma frigideira larga com a cebola cortada. Regar com o azeite.\n" +
                "5. Por cima espalhar as rodelas de batata, depois as de courgette e dispor os filetes no final.\n" +
                "6. Acrescentar a marinada e um pouco de água (50 a 100ml).\n" +
                "7. Juntar salsa, tapar e deixar cozinhar 30 min em lume médio (não é necessário mexer)."
        ),
        Recipe(
            id = "arroz_camarao_ovo",
            title = "Arroz de camarão com ovo",
            source = "Arroz de ovo com camarão e macedónia de legumes",
            ingredients = listOf(
                "Miolo de camarão",
                "Spray de azeite",
                "1/2 colher de chá de alho em pó e pimentão doce para o camarão",
                "Ovo",
                "Macedónia de legumes congelado",
                "Alho em pó, cebola em pó, sal e salsa seca para temperar",
                "Arroz"
            ),
            prep = "1. Cozer o arroz.\n" +
                "2. Aquecer uma frigideira antiaderente untada com o spray de azeite. Quando bem quente, colocar " +
                "o camarão. Polvilhar com o alho e pimentão doce, misturar e grelhar em lume alto até estarem " +
                "dourados. Retirar e reservar.\n" +
                "3. Na mesma frigideira, voltar a untar com o spray de azeite. Adicionar o ovo e mexer. Retirar " +
                "quando estiverem duros. Reservar.\n" +
                "4. Ainda na mesma frigideira, colocar a macedónia de legumes e o tempero. Misturar e mexer até " +
                "que perca o tom de congelado. Juntar um pouco de água e deixar cozinhar em lume médio/alto até " +
                "a água evaporar.\n" +
                "5. Envolver o arroz cozido, depois o ovo e no fim o camarão."
        ),
        Recipe(
            id = "frango_a_bras",
            title = "Frango à Brás",
            source = "Receita cedida por Sandra Nereu",
            ingredients = listOf(
                "1 peito de frango cozido ou assado, desfiado",
                "4 batatas",
                "2 cebolas",
                "2 dentes de alho",
                "4 ovos",
                "Salsa picada q.b.",
                "Sal q.b.",
                "Azeitonas para servir"
            ),
            prep = "1. Cortar as batatas em rodelas finas e depois em palitos.\n" +
                "2. Secar bem com papel de cozinha, regar com azeite em spray.\n" +
                "3. Espalhar na airfryer e programar Fritar durante 10 minutos. Mexer e programar mais 5 minutos.\n" +
                "4. Enquanto isso, levar ao lume uma frigideira larga com as cebolas cortadas em meia-lua e uns " +
                "sprays de azeite.\n" +
                "5. Quando a cebola amolecer, juntar o alho picado e deixar dourar ligeiramente.\n" +
                "6. Juntar o frango desfiado, envolver e deixar ao lume até ganhar alguma cor.\n" +
                "7. Envolver a batata palha caseira e retirar do lume.\n" +
                "8. Bater os ovos, juntar ao preparado e envolver bem.\n" +
                "9. Juntar salsa picada a gosto.\n" +
                "10. Servir de imediato com azeitonas."
        ),
        Recipe(
            id = "estufado_grao_bico_polvo",
            title = "Estufado de grão de bico e polvo",
            ingredients = listOf(
                "1 cebola",
                "3 dentes de alho",
                "1/2 pimento vermelho",
                "1/2 pimento verde",
                "2 tomates",
                "Sal q.b.",
                "1 colher de chá de pimentão doce",
                "300g de polvo cozido",
                "400g de grão de bico cozido",
                "Salsa fresca para servir"
            ),
            prep = "1. Partir a cebola, os pimentos e os tomates em pedaços. Descascar os dentes de alho. Num " +
                "processador de alimentos triturar estes alimentos juntos.\n" +
                "2. Passar para um tacho, acrescentar o azeite, sal e pimentão doce. Deixar ferver 10min, tapado " +
                "e em lume médio.\n" +
                "3. Adicionar o grão de bico, ferver mais 2 min.\n" +
                "4. Juntar o polvo cozido e partido em pedaços. Ferver mais 5 min para apurar os sabores.\n" +
                "Nota: pode trocar o polvo por tentáculos de pota ou lulas ou pedaços de peixe."
        ),
        Recipe(
            id = "arroz_tosco_vitela",
            title = "Arroz tosco de vitela",
            source = "Ingredientes para 4 doses",
            ingredients = listOf(
                "300g de carne magra picada (bife de vitela)",
                "1 cebola",
                "2 dentes de alho",
                "1 cenoura",
                "1 colher de chá de pimentão doce",
                "Pitada de flocos de piripiri (opcional)",
                "1/2 colher de chá de açafrão (opcional)",
                "100g de tomate em pedaços",
                "3 colheres de sopa de polpa de tomate",
                "200g de feijão encarnado cozido",
                "180g de arroz",
                "Sal",
                "Salsa fresca para servir"
            ),
            prep = "1. Levar ao lume um tacho com o azeite. Quando quente, inserir a carne. Em lume alto, saltear " +
                "a carne até formar pequenas bolas.\n" +
                "2. Juntar a cebola picada, misturar e refogar 2 min.\n" +
                "3. Adicionar o alho, pimentão doce, piripiri, açafrão, tomate e polpa, a cenoura em pequenos cubos.\n" +
                "4. Misturar, adicionar 100ml de água e cozinhar em lume médio tapado 5 a 8 min.\n" +
                "5. Acrescentar o feijão, misturar, o arroz, 500ml de água, envolver, tapar.\n" +
                "6. Cozinhar até o arroz estar pronto e a água reduzida.\n" +
                "7. Servir com salsa fresca."
        ),
        Recipe(
            id = "mini_hamburguer_atum",
            title = "Mini hambúrguer de atum",
            ingredients = listOf(
                "270g de atum ao natural",
                "2 ovos",
                "1 colher de chá de orégãos",
                "Salsa fresca picada a gosto",
                "2 colheres de sopa de pão ralado (ou farinha de aveia ou farinha de amêndoa ou flocos de aveia " +
                    "triturados)"
            ),
            prep = "1. Escorrer o atum. Esmagar com um garfo.\n" +
                "2. Misturar os restantes ingredientes.\n" +
                "3. Formar mini hambúrgueres.\n" +
                "4. Pincelar com azeite.\n\n" +
                "Cozinhar:\n" +
                "— Numa frigideira anti aderente untada até dourar\n" +
                "— Airfryer, função fritar, 185º, 15 min\n" +
                "— Forno pré-aquecido a 190º, 20min"
        )
    )

    /** Títulos vistos na lista de Receitas mas sem detalhe aberto nas capturas. */
    val recipeTitlesWithoutDetail = listOf(
        "Pevide cremoso com ervilhas",
        "Bacalhau Gomes de Sá",
        "Bifes de peru recheados de tomate e queijo",
        "Lombos de Salmão com Citrinos"
    )

    // ---------------- SUPLEMENTOS ----------------
    val supplements = listOf(
        InfoItem(
            id = "whey",
            title = "Whey OU proteína em pó",
            text = "Conteúdo informativo — o uso de suplementos não é obrigatório, se quiser adicionar enviar " +
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
                "que usem whey."
        ),
        InfoItem(
            id = "creatina",
            title = "Creatina monohidratada",
            text = "Conteúdo informativo, o uso de suplementos não é obrigatório, se quiser adicionar enviar " +
                "mensagem no chat da app."
        ),
        InfoItem(
            id = "omega3",
            title = "Omega 3",
            text = "Conteúdo informativo, o uso de suplementos não é obrigatório, se quiser adicionar enviar " +
                "mensagem na chat da app."
        ),
        InfoItem(
            id = "vitamina_d3",
            title = "Vitamina D3",
            text = "Conteúdo informativo, o uso de suplementos não é obrigatório, se quiser adicionar enviar " +
                "mensagem no chat da app."
        ),
        InfoItem(
            id = "melatonina",
            title = "Melatonina",
            text = "Conteúdo informativo, o uso de suplementos não é obrigatório, se quiser adicionar enviar " +
                "mensagem no chat da app."
        ),
        InfoItem(
            id = "psyllium",
            title = "Psyllium Husk",
            text = "Fibra alimentar para intestino preso e obstipação. Conteúdo informativo, o uso de " +
                "suplementos não é obrigatório, se quiser adicionar enviar mensagem no chat da app.\n\n" +
                "É o suplemento de fibra mais estudado e com melhores estudos científicos que comprovam eficácia " +
                "principalmente para pessoas que tendem a ter prisão de ventre. Pode ajudar a regular o " +
                "intestino e também já mostrou alguns benefícios na diminuição do colesterol, mas sem dúvida " +
                "mais utilizado para regular o intestino e aumentar a ingestão de fibra na dieta.\n\n" +
                "As doses normais e mais estudadas são de 10gr diárias para tratamento de obstipação, pode-se " +
                "usar juntando na água ou em algum alimento da dieta.\n\n" +
                "Usar uma fibra alimentar sem beber água suficiente pode atrapalhar ainda mais a obstipação, por " +
                "isso é fundamental manter uma boa ingestão de água com o uso deste suplemento.\n\n" +
                "*No caso de amamentação e gravidez o uso deve passar por aconselhamento médico."
        )
    )

    // ---------------- NOTAS / DICAS GERAIS ----------------
    val generalNotes = listOf(
        InfoItem(
            id = "agua",
            title = "Considerações sobre a importância do consumo de água",
            text = "Beber água ao longo do dia é essencial para um bom funcionamento metabólico. A ingestão " +
                "ajuda na digestão, na eliminação de toxinas e na regulação do trânsito intestinal. Um corpo " +
                "pouco hidratado vai comprometer os resultados. Deverá ingerir a quantidade de água suficiente " +
                "de modo a que a sua urina seja amarelo clara e sem cheiro.\n\n" +
                "Para isso, pode seguir as sugestões:\n" +
                "- tenha sempre água disponível à sua beira\n" +
                "- hidrate-se ao acordar e durante todas as refeições (lanches e refeições principais)\n" +
                "- não espere sentir sede para beber água\n" +
                "- aromatize a água com infusões"
        ),
        InfoItem(
            id = "saltar_refeicoes",
            title = "Considerações sobre saltar refeições",
            text = "A reeducação alimentar é fundamental no processo de emagrecimento, dessa forma, é importante " +
                "aprender a fazer uma alimentação equilibrada e variada, que inclua 5 a 6 refeições diárias. " +
                "Tendo em conta este aspeto, deve evitar jejuns prolongados, nunca saltando refeições, mantendo " +
                "assim a saciedade, o correto funcionamento do metabolismo (o que ajuda a equilibrar o peso, os " +
                "níveis de açúcar no sangue e contribui para o bom funcionamento intestinal) e evitando episódios " +
                "de excessos alimentares. Quando só come quando tem fome e salta refeições, pode afetar " +
                "negativamente o metabolismo e a saúde de várias formas, pode levar a picos de açúcar no sangue " +
                "seguidos por quedas que aumentam o descontrolo do apetite. Além disso, o corpo pode começar a " +
                "armazenar mais gordura, pois sente que não há \"certeza\" de quando virá a próxima refeição, " +
                "dificultando a perda de peso. Dificulta ainda o trânsito intestinal e aumenta a sensação de " +
                "fadiga e cansaço."
        ),
        InfoItem(
            id = "regras_gerais",
            title = "Regras gerais e substituições",
            text = "- Pesar todos os alimentos confecionados (menos a batata na airfryer que pesa a cru).\n\n" +
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
                "- Carne de vaca: cortes magros (redondo, vazia, pojadouro, acém, rabadilha, alcatra)."
        )
    )
}
