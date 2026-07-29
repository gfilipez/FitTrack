package com.gfilipe.fittrack

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.material.icons.filled.Science
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gfilipe.fittrack.data.InfoItem
import com.gfilipe.fittrack.data.MealOption
import com.gfilipe.fittrack.data.MealSlot
import com.gfilipe.fittrack.data.PlanData
import com.gfilipe.fittrack.data.Recipe
import com.gfilipe.fittrack.data.WorkoutDay
import com.gfilipe.fittrack.ui.theme.FitTrackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FitTrackTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    FitTrackApp()
                }
            }
        }
    }
}

private fun prefs(context: Context) = context.getSharedPreferences("fittrack_prefs", Context.MODE_PRIVATE)

@Composable
fun FitTrackApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }

        composable("workouts") { WorkoutListScreen(navController) }
        composable("workout/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")
            val workout = PlanData.workouts.find { it.id == id }
            if (workout != null) WorkoutDetailScreen(navController, workout)
        }

        composable("meals") { MealSlotListScreen(navController) }
        composable("meals/{slotId}") { backStackEntry ->
            val slotId = backStackEntry.arguments?.getString("slotId")
            val slot = PlanData.mealSlots.find { it.id == slotId }
            if (slot != null) MealOptionListScreen(navController, slot)
        }
        composable("meals/{slotId}/{optionId}") { backStackEntry ->
            val slotId = backStackEntry.arguments?.getString("slotId")
            val optionId = backStackEntry.arguments?.getString("optionId")
            val slot = PlanData.mealSlots.find { it.id == slotId }
            val option = slot?.options?.find { it.id == optionId }
            if (slot != null && option != null) MealOptionDetailScreen(navController, slot, option)
        }

        composable("recipes") { RecipeListScreen(navController) }
        composable("recipe/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")
            val recipe = PlanData.recipes.find { it.id == id }
            if (recipe != null) RecipeDetailScreen(navController, recipe)
        }

        composable("supplements") { InfoListScreen(navController, "Suplementos", PlanData.supplements, "supplement") }
        composable("supplement/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")
            val item = PlanData.supplements.find { it.id == id }
            if (item != null) InfoDetailScreen(navController, item)
        }

        composable("notes") { InfoListScreen(navController, "Notas gerais", PlanData.generalNotes, "note") }
        composable("note/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")
            val item = PlanData.generalNotes.find { it.id == id }
            if (item != null) InfoDetailScreen(navController, item)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun FitTrackScaffold(
    title: String,
    navController: NavController,
    showBack: Boolean = true,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(title, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    if (showBack) {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                        }
                    }
                }
            )
        }
    ) { padding -> content(padding) }
}

@Composable
private fun SectionCard(title: String, subtitle: String? = null, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        onClick = onClick
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
            if (subtitle != null) {
                Text(
                    subtitle,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 4.dp),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

// ---------------- HOME ----------------

@Composable
fun HomeScreen(navController: NavController) {
    FitTrackScaffold(title = "FitTrack — O meu plano", navController = navController, showBack = false) { padding ->
        LazyColumn(contentPadding = PaddingValues(vertical = 12.dp), modifier = Modifier.padding(padding)) {
            item {
                Text(
                    "Plano pessoal de treino e alimentação",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            item {
                HomeMenuItem(Icons.Filled.FitnessCenter, "Treinos", "Dias de treino e exercícios") {
                    navController.navigate("workouts")
                }
            }
            item {
                HomeMenuItem(Icons.Filled.Fastfood, "Refeições", "Pequeno-almoço, almoço, lanche, jantar…") {
                    navController.navigate("meals")
                }
            }
            item {
                HomeMenuItem(Icons.Filled.MenuBook, "Receitas", "Receitas detalhadas com preparação") {
                    navController.navigate("recipes")
                }
            }
            item {
                HomeMenuItem(Icons.Filled.Science, "Suplementos", "Informação sobre suplementação") {
                    navController.navigate("supplements")
                }
            }
            item {
                HomeMenuItem(Icons.Filled.Info, "Notas gerais", "Água, refeições e regras do plano") {
                    navController.navigate("notes")
                }
            }
        }
    }
}

@Composable
private fun HomeMenuItem(icon: androidx.compose.ui.graphics.vector.ImageVector, title: String, subtitle: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(icon, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(32.dp))
            Column {
                Text(title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
                Text(subtitle, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
    }
}

// ---------------- TREINOS ----------------

@Composable
fun WorkoutListScreen(navController: NavController) {
    FitTrackScaffold(title = "Treinos", navController = navController) { padding ->
        LazyColumn(contentPadding = PaddingValues(vertical = 12.dp), modifier = Modifier.padding(padding)) {
            items(PlanData.workouts) { workout ->
                SectionCard(title = workout.title, subtitle = workout.subtitle) {
                    navController.navigate("workout/${workout.id}")
                }
            }
        }
    }
}

@Composable
fun WorkoutDetailScreen(navController: NavController, workout: WorkoutDay) {
    val context = LocalContext.current
    var done by remember {
        mutableStateOf(prefs(context).getBoolean("workout_done_${workout.id}", false))
    }
    FitTrackScaffold(title = workout.title, navController = navController) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            Text(
                workout.subtitle,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            LazyColumn(modifier = Modifier.weight(1f), contentPadding = PaddingValues(bottom = 12.dp)) {
                items(workout.exercises) { exercise ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 6.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(exercise.name, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
                            Text(
                                exercise.detail,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(top = 4.dp),
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = {
                    done = !done
                    prefs(context).edit().putBoolean("workout_done_${workout.id}", done).apply()
                }) {
                    Icon(
                        if (done) Icons.Filled.CheckCircle else Icons.Filled.RadioButtonUnchecked,
                        contentDescription = null
                    )
                    Text(if (done) "  Concluído" else "  Concluir", modifier = Modifier.padding(start = 4.dp))
                }
            }
        }
    }
}

// ---------------- REFEIÇÕES ----------------

@Composable
fun MealSlotListScreen(navController: NavController) {
    FitTrackScaffold(title = "Refeições", navController = navController) { padding ->
        LazyColumn(contentPadding = PaddingValues(vertical = 12.dp), modifier = Modifier.padding(padding)) {
            items(PlanData.mealSlots) { slot ->
                SectionCard(title = slot.title, subtitle = "${slot.options.size} opções") {
                    navController.navigate("meals/${slot.id}")
                }
            }
        }
    }
}

@Composable
fun MealOptionListScreen(navController: NavController, slot: MealSlot) {
    FitTrackScaffold(title = slot.title, navController = navController) { padding ->
        LazyColumn(contentPadding = PaddingValues(vertical = 12.dp), modifier = Modifier.padding(padding)) {
            if (slot.note != null) {
                item {
                    NoteBox(slot.note)
                }
            }
            items(slot.options) { option ->
                SectionCard(title = option.name) {
                    navController.navigate("meals/${slot.id}/${option.id}")
                }
            }
        }
    }
}

@Composable
fun MealOptionDetailScreen(navController: NavController, slot: MealSlot, option: MealOption) {
    FitTrackScaffold(title = option.name, navController = navController) { padding ->
        LazyColumn(contentPadding = PaddingValues(vertical = 12.dp), modifier = Modifier.padding(padding)) {
            if (option.ingredients.isEmpty() && option.prep == null) {
                item {
                    NoteBox("Ainda sem detalhe guardado para esta opção. Podes adicionar os ingredientes mais tarde em PlanData.kt.")
                }
            }
            items(option.ingredients) { ingredient ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                ) {
                    Text(ingredient.text, modifier = Modifier.padding(12.dp), style = MaterialTheme.typography.bodyMedium)
                }
            }
            if (option.prep != null) {
                item {
                    Text(
                        "Preparação",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                    Text(
                        option.prep,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
                    )
                }
            }
            if (option.note != null) {
                item { NoteBox(option.note) }
            }
        }
    }
}

// ---------------- RECEITAS ----------------

@Composable
fun RecipeListScreen(navController: NavController) {
    FitTrackScaffold(title = "Receitas", navController = navController) { padding ->
        LazyColumn(contentPadding = PaddingValues(vertical = 12.dp), modifier = Modifier.padding(padding)) {
            items(PlanData.recipes) { recipe ->
                SectionCard(title = recipe.title, subtitle = recipe.source) {
                    navController.navigate("recipe/${recipe.id}")
                }
            }
            if (PlanData.recipeTitlesWithoutDetail.isNotEmpty()) {
                item {
                    Text(
                        "Sem detalhe guardado ainda",
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                items(PlanData.recipeTitlesWithoutDetail) { title ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 4.dp)
                    ) {
                        Text(title, modifier = Modifier.padding(12.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun RecipeDetailScreen(navController: NavController, recipe: Recipe) {
    FitTrackScaffold(title = recipe.title, navController = navController) { padding ->
        LazyColumn(contentPadding = PaddingValues(vertical = 12.dp), modifier = Modifier.padding(padding)) {
            if (recipe.source != null) {
                item {
                    Text(
                        recipe.source,
                        style = MaterialTheme.typography.bodySmall,
                        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                        modifier = Modifier.padding(horizontal = 16.dp, bottom = 8.dp),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            item {
                Text(
                    "Ingredientes",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
                )
            }
            items(recipe.ingredients) { ingredient ->
                Text("•  $ingredient", modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp))
            }
            item {
                Text(
                    "Preparação",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp, top = 16.dp, bottom = 4.dp)
                )
                Text(recipe.prep, modifier = Modifier.padding(horizontal = 16.dp))
            }
        }
    }
}

// ---------------- INFO (Suplementos / Notas) ----------------

@Composable
fun InfoListScreen(navController: NavController, title: String, infoItems: List<InfoItem>, route: String) {
    FitTrackScaffold(title = title, navController = navController) { padding ->
        LazyColumn(contentPadding = PaddingValues(vertical = 12.dp), modifier = Modifier.padding(padding)) {
            items(infoItems) { item ->
                SectionCard(title = item.title) {
                    navController.navigate("$route/${item.id}")
                }
            }
        }
    }
}

@Composable
fun InfoDetailScreen(navController: NavController, item: InfoItem) {
    FitTrackScaffold(title = item.title, navController = navController) { padding ->
        LazyColumn(contentPadding = PaddingValues(16.dp), modifier = Modifier.padding(padding)) {
            item { Text(item.text, style = MaterialTheme.typography.bodyLarge) }
        }
    }
}

@Composable
private fun NoteBox(text: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.12f))
    ) {
        Text(text, modifier = Modifier.padding(12.dp), style = MaterialTheme.typography.bodyMedium)
    }
}
