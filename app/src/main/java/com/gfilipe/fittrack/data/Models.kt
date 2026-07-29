package com.gfilipe.fittrack.data

data class Exercise(
    val name: String,
    val detail: String
)

data class WorkoutDay(
    val id: String,
    val title: String,
    val subtitle: String,
    val exercises: List<Exercise>
)

data class Ingredient(
    val text: String
)

data class MealOption(
    val id: String,
    val name: String,
    val ingredients: List<Ingredient> = emptyList(),
    val prep: String? = null,
    val note: String? = null
)

data class MealSlot(
    val id: String,
    val title: String,
    val note: String? = null,
    val options: List<MealOption>
)

data class Recipe(
    val id: String,
    val title: String,
    val source: String? = null,
    val ingredients: List<String>,
    val prep: String
)

data class InfoItem(
    val id: String,
    val title: String,
    val text: String
)
