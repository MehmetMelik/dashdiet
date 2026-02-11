package com.dashdiet.app.data.model

data class Recipe(
    val id: Int,
    val titleResId: Int,
    val descriptionResId: Int,
    val category: MealCategory,
    val ingredients: List<Int>, // String resource IDs
    val steps: List<Int>, // String resource IDs
    val nutritionInfo: NutritionInfo,
    val prepTimeMinutes: Int,
    val cookTimeMinutes: Int,
    val servings: Int,
    val iconEmoji: String
) {
    val totalTimeMinutes: Int get() = prepTimeMinutes + cookTimeMinutes
}

enum class MealCategory(val titleResId: Int, val emoji: String) {
    BREAKFAST(com.dashdiet.app.R.string.category_breakfast, "\uD83C\uDF73"),
    LUNCH(com.dashdiet.app.R.string.category_lunch, "\uD83E\uDD57"),
    DINNER(com.dashdiet.app.R.string.category_dinner, "\uD83C\uDF7D\uFE0F"),
    SNACK(com.dashdiet.app.R.string.category_snacks, "\uD83C\uDF4E")
}

data class NutritionInfo(
    val calories: Int,
    val sodiumMg: Int,
    val potassiumMg: Int,
    val fiberG: Int,
    val proteinG: Int,
    val fatG: Int,
    val carbsG: Int
)
