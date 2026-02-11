package com.dashdiet.app.data.repository

import com.dashdiet.app.R
import com.dashdiet.app.data.model.MealCategory
import com.dashdiet.app.data.model.NutritionInfo
import com.dashdiet.app.data.model.Recipe
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecipeRepository @Inject constructor() {

    fun getAllRecipes(): List<Recipe> = recipes

    fun getRecipeById(id: Int): Recipe? = recipes.find { it.id == id }

    fun getRecipesByCategory(category: MealCategory): List<Recipe> =
        recipes.filter { it.category == category }

    fun searchRecipes(query: String): List<Recipe> =
        recipes.filter { it.titleResId.toString().contains(query, ignoreCase = true) }

    fun getFeaturedRecipes(): List<Recipe> = listOf(
        recipes[0],  // Oatmeal
        recipes[8],  // Quinoa Salad
        recipes[16], // Grilled Salmon
        recipes[24]  // Hummus
    )

    companion object {
        private val recipes = listOf(
            // === BREAKFAST ===
            Recipe(
                id = 1,
                titleResId = R.string.recipe_1_title,
                descriptionResId = R.string.recipe_1_desc,
                category = MealCategory.BREAKFAST,
                ingredients = listOf(
                    R.string.recipe_1_ing_1, R.string.recipe_1_ing_2, R.string.recipe_1_ing_3,
                    R.string.recipe_1_ing_4, R.string.recipe_1_ing_5, R.string.recipe_1_ing_6
                ),
                steps = listOf(
                    R.string.recipe_1_step_1, R.string.recipe_1_step_2,
                    R.string.recipe_1_step_3, R.string.recipe_1_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 310, sodiumMg = 45, potassiumMg = 320, fiberG = 8, proteinG = 10, fatG = 9, carbsG = 52),
                prepTimeMinutes = 5, cookTimeMinutes = 10, servings = 1, iconEmoji = "\uD83E\uDD63"
            ),
            Recipe(
                id = 2,
                titleResId = R.string.recipe_2_title,
                descriptionResId = R.string.recipe_2_desc,
                category = MealCategory.BREAKFAST,
                ingredients = listOf(
                    R.string.recipe_2_ing_1, R.string.recipe_2_ing_2, R.string.recipe_2_ing_3,
                    R.string.recipe_2_ing_4, R.string.recipe_2_ing_5, R.string.recipe_2_ing_6
                ),
                steps = listOf(
                    R.string.recipe_2_step_1, R.string.recipe_2_step_2,
                    R.string.recipe_2_step_3, R.string.recipe_2_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 280, sodiumMg = 60, potassiumMg = 380, fiberG = 5, proteinG = 18, fatG = 7, carbsG = 40),
                prepTimeMinutes = 10, cookTimeMinutes = 0, servings = 1, iconEmoji = "\uD83C\uDF53"
            ),
            Recipe(
                id = 3,
                titleResId = R.string.recipe_3_title,
                descriptionResId = R.string.recipe_3_desc,
                category = MealCategory.BREAKFAST,
                ingredients = listOf(
                    R.string.recipe_3_ing_1, R.string.recipe_3_ing_2, R.string.recipe_3_ing_3,
                    R.string.recipe_3_ing_4, R.string.recipe_3_ing_5, R.string.recipe_3_ing_6
                ),
                steps = listOf(
                    R.string.recipe_3_step_1, R.string.recipe_3_step_2,
                    R.string.recipe_3_step_3, R.string.recipe_3_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 340, sodiumMg = 200, potassiumMg = 580, fiberG = 10, proteinG = 8, fatG = 18, carbsG = 38),
                prepTimeMinutes = 5, cookTimeMinutes = 3, servings = 1, iconEmoji = "\uD83E\uDD51"
            ),
            Recipe(
                id = 4,
                titleResId = R.string.recipe_4_title,
                descriptionResId = R.string.recipe_4_desc,
                category = MealCategory.BREAKFAST,
                ingredients = listOf(
                    R.string.recipe_4_ing_1, R.string.recipe_4_ing_2, R.string.recipe_4_ing_3,
                    R.string.recipe_4_ing_4, R.string.recipe_4_ing_5, R.string.recipe_4_ing_6
                ),
                steps = listOf(
                    R.string.recipe_4_step_1, R.string.recipe_4_step_2,
                    R.string.recipe_4_step_3, R.string.recipe_4_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 290, sodiumMg = 35, potassiumMg = 450, fiberG = 7, proteinG = 6, fatG = 5, carbsG = 58),
                prepTimeMinutes = 10, cookTimeMinutes = 0, servings = 1, iconEmoji = "\uD83C\uDF53"
            ),
            Recipe(
                id = 5,
                titleResId = R.string.recipe_5_title,
                descriptionResId = R.string.recipe_5_desc,
                category = MealCategory.BREAKFAST,
                ingredients = listOf(
                    R.string.recipe_5_ing_1, R.string.recipe_5_ing_2, R.string.recipe_5_ing_3,
                    R.string.recipe_5_ing_4, R.string.recipe_5_ing_5, R.string.recipe_5_ing_6
                ),
                steps = listOf(
                    R.string.recipe_5_step_1, R.string.recipe_5_step_2,
                    R.string.recipe_5_step_3, R.string.recipe_5_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 180, sodiumMg = 220, potassiumMg = 310, fiberG = 2, proteinG = 22, fatG = 6, carbsG = 8),
                prepTimeMinutes = 5, cookTimeMinutes = 8, servings = 1, iconEmoji = "\uD83C\uDF73"
            ),
            Recipe(
                id = 6,
                titleResId = R.string.recipe_6_title,
                descriptionResId = R.string.recipe_6_desc,
                category = MealCategory.BREAKFAST,
                ingredients = listOf(
                    R.string.recipe_6_ing_1, R.string.recipe_6_ing_2, R.string.recipe_6_ing_3,
                    R.string.recipe_6_ing_4, R.string.recipe_6_ing_5, R.string.recipe_6_ing_6
                ),
                steps = listOf(
                    R.string.recipe_6_step_1, R.string.recipe_6_step_2,
                    R.string.recipe_6_step_3, R.string.recipe_6_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 350, sodiumMg = 180, potassiumMg = 420, fiberG = 6, proteinG = 12, fatG = 8, carbsG = 60),
                prepTimeMinutes = 10, cookTimeMinutes = 15, servings = 2, iconEmoji = "\uD83E\uDD5E"
            ),
            Recipe(
                id = 7,
                titleResId = R.string.recipe_7_title,
                descriptionResId = R.string.recipe_7_desc,
                category = MealCategory.BREAKFAST,
                ingredients = listOf(
                    R.string.recipe_7_ing_1, R.string.recipe_7_ing_2, R.string.recipe_7_ing_3,
                    R.string.recipe_7_ing_4, R.string.recipe_7_ing_5, R.string.recipe_7_ing_6
                ),
                steps = listOf(
                    R.string.recipe_7_step_1, R.string.recipe_7_step_2,
                    R.string.recipe_7_step_3, R.string.recipe_7_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 180, sodiumMg = 10, potassiumMg = 520, fiberG = 6, proteinG = 3, fatG = 1, carbsG = 44),
                prepTimeMinutes = 15, cookTimeMinutes = 0, servings = 2, iconEmoji = "\uD83C\uDF52"
            ),
            Recipe(
                id = 8,
                titleResId = R.string.recipe_8_title,
                descriptionResId = R.string.recipe_8_desc,
                category = MealCategory.BREAKFAST,
                ingredients = listOf(
                    R.string.recipe_8_ing_1, R.string.recipe_8_ing_2, R.string.recipe_8_ing_3,
                    R.string.recipe_8_ing_4, R.string.recipe_8_ing_5, R.string.recipe_8_ing_6
                ),
                steps = listOf(
                    R.string.recipe_8_step_1, R.string.recipe_8_step_2,
                    R.string.recipe_8_step_3, R.string.recipe_8_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 320, sodiumMg = 55, potassiumMg = 350, fiberG = 5, proteinG = 11, fatG = 10, carbsG = 48),
                prepTimeMinutes = 5, cookTimeMinutes = 0, servings = 1, iconEmoji = "\uD83E\uDD63"
            ),

            // === LUNCH ===
            Recipe(
                id = 9,
                titleResId = R.string.recipe_9_title,
                descriptionResId = R.string.recipe_9_desc,
                category = MealCategory.LUNCH,
                ingredients = listOf(
                    R.string.recipe_9_ing_1, R.string.recipe_9_ing_2, R.string.recipe_9_ing_3,
                    R.string.recipe_9_ing_4, R.string.recipe_9_ing_5, R.string.recipe_9_ing_6
                ),
                steps = listOf(
                    R.string.recipe_9_step_1, R.string.recipe_9_step_2,
                    R.string.recipe_9_step_3, R.string.recipe_9_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 320, sodiumMg = 30, potassiumMg = 450, fiberG = 6, proteinG = 10, fatG = 14, carbsG = 40),
                prepTimeMinutes = 10, cookTimeMinutes = 15, servings = 2, iconEmoji = "\uD83E\uDD57"
            ),
            Recipe(
                id = 10,
                titleResId = R.string.recipe_10_title,
                descriptionResId = R.string.recipe_10_desc,
                category = MealCategory.LUNCH,
                ingredients = listOf(
                    R.string.recipe_10_ing_1, R.string.recipe_10_ing_2, R.string.recipe_10_ing_3,
                    R.string.recipe_10_ing_4, R.string.recipe_10_ing_5, R.string.recipe_10_ing_6
                ),
                steps = listOf(
                    R.string.recipe_10_step_1, R.string.recipe_10_step_2,
                    R.string.recipe_10_step_3, R.string.recipe_10_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 280, sodiumMg = 350, potassiumMg = 380, fiberG = 3, proteinG = 28, fatG = 10, carbsG = 15),
                prepTimeMinutes = 10, cookTimeMinutes = 10, servings = 2, iconEmoji = "\uD83E\uDD57"
            ),
            Recipe(
                id = 11,
                titleResId = R.string.recipe_11_title,
                descriptionResId = R.string.recipe_11_desc,
                category = MealCategory.LUNCH,
                ingredients = listOf(
                    R.string.recipe_11_ing_1, R.string.recipe_11_ing_2, R.string.recipe_11_ing_3,
                    R.string.recipe_11_ing_4, R.string.recipe_11_ing_5, R.string.recipe_11_ing_6
                ),
                steps = listOf(
                    R.string.recipe_11_step_1, R.string.recipe_11_step_2,
                    R.string.recipe_11_step_3, R.string.recipe_11_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 280, sodiumMg = 120, potassiumMg = 580, fiberG = 12, proteinG = 18, fatG = 4, carbsG = 45),
                prepTimeMinutes = 10, cookTimeMinutes = 30, servings = 4, iconEmoji = "\uD83C\uDF72"
            ),
            Recipe(
                id = 12,
                titleResId = R.string.recipe_12_title,
                descriptionResId = R.string.recipe_12_desc,
                category = MealCategory.LUNCH,
                ingredients = listOf(
                    R.string.recipe_12_ing_1, R.string.recipe_12_ing_2, R.string.recipe_12_ing_3,
                    R.string.recipe_12_ing_4, R.string.recipe_12_ing_5, R.string.recipe_12_ing_6
                ),
                steps = listOf(
                    R.string.recipe_12_step_1, R.string.recipe_12_step_2,
                    R.string.recipe_12_step_3, R.string.recipe_12_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 380, sodiumMg = 180, potassiumMg = 620, fiberG = 7, proteinG = 35, fatG = 18, carbsG = 20),
                prepTimeMinutes = 10, cookTimeMinutes = 15, servings = 1, iconEmoji = "\uD83E\uDD57"
            ),
            Recipe(
                id = 13,
                titleResId = R.string.recipe_13_title,
                descriptionResId = R.string.recipe_13_desc,
                category = MealCategory.LUNCH,
                ingredients = listOf(
                    R.string.recipe_13_ing_1, R.string.recipe_13_ing_2, R.string.recipe_13_ing_3,
                    R.string.recipe_13_ing_4, R.string.recipe_13_ing_5, R.string.recipe_13_ing_6
                ),
                steps = listOf(
                    R.string.recipe_13_step_1, R.string.recipe_13_step_2,
                    R.string.recipe_13_step_3, R.string.recipe_13_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 420, sodiumMg = 150, potassiumMg = 680, fiberG = 12, proteinG = 15, fatG = 16, carbsG = 58),
                prepTimeMinutes = 10, cookTimeMinutes = 25, servings = 1, iconEmoji = "\uD83E\uDD57"
            ),
            Recipe(
                id = 14,
                titleResId = R.string.recipe_14_title,
                descriptionResId = R.string.recipe_14_desc,
                category = MealCategory.LUNCH,
                ingredients = listOf(
                    R.string.recipe_14_ing_1, R.string.recipe_14_ing_2, R.string.recipe_14_ing_3,
                    R.string.recipe_14_ing_4, R.string.recipe_14_ing_5, R.string.recipe_14_ing_6
                ),
                steps = listOf(
                    R.string.recipe_14_step_1, R.string.recipe_14_step_2,
                    R.string.recipe_14_step_3, R.string.recipe_14_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 310, sodiumMg = 250, potassiumMg = 350, fiberG = 5, proteinG = 30, fatG = 8, carbsG = 32),
                prepTimeMinutes = 10, cookTimeMinutes = 0, servings = 1, iconEmoji = "\uD83E\uDD6A"
            ),
            Recipe(
                id = 15,
                titleResId = R.string.recipe_15_title,
                descriptionResId = R.string.recipe_15_desc,
                category = MealCategory.LUNCH,
                ingredients = listOf(
                    R.string.recipe_15_ing_1, R.string.recipe_15_ing_2, R.string.recipe_15_ing_3,
                    R.string.recipe_15_ing_4, R.string.recipe_15_ing_5, R.string.recipe_15_ing_6
                ),
                steps = listOf(
                    R.string.recipe_15_step_1, R.string.recipe_15_step_2,
                    R.string.recipe_15_step_3, R.string.recipe_15_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 250, sodiumMg = 180, potassiumMg = 480, fiberG = 8, proteinG = 12, fatG = 5, carbsG = 42),
                prepTimeMinutes = 10, cookTimeMinutes = 20, servings = 4, iconEmoji = "\uD83C\uDF72"
            ),
            Recipe(
                id = 16,
                titleResId = R.string.recipe_16_title,
                descriptionResId = R.string.recipe_16_desc,
                category = MealCategory.LUNCH,
                ingredients = listOf(
                    R.string.recipe_16_ing_1, R.string.recipe_16_ing_2, R.string.recipe_16_ing_3,
                    R.string.recipe_16_ing_4, R.string.recipe_16_ing_5, R.string.recipe_16_ing_6
                ),
                steps = listOf(
                    R.string.recipe_16_step_1, R.string.recipe_16_step_2,
                    R.string.recipe_16_step_3, R.string.recipe_16_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 350, sodiumMg = 380, potassiumMg = 320, fiberG = 8, proteinG = 12, fatG = 15, carbsG = 42),
                prepTimeMinutes = 10, cookTimeMinutes = 0, servings = 1, iconEmoji = "\uD83E\uDD59"
            ),

            // === DINNER ===
            Recipe(
                id = 17,
                titleResId = R.string.recipe_17_title,
                descriptionResId = R.string.recipe_17_desc,
                category = MealCategory.DINNER,
                ingredients = listOf(
                    R.string.recipe_17_ing_1, R.string.recipe_17_ing_2, R.string.recipe_17_ing_3,
                    R.string.recipe_17_ing_4, R.string.recipe_17_ing_5, R.string.recipe_17_ing_6
                ),
                steps = listOf(
                    R.string.recipe_17_step_1, R.string.recipe_17_step_2,
                    R.string.recipe_17_step_3, R.string.recipe_17_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 380, sodiumMg = 85, potassiumMg = 680, fiberG = 2, proteinG = 34, fatG = 22, carbsG = 8),
                prepTimeMinutes = 20, cookTimeMinutes = 10, servings = 2, iconEmoji = "\uD83C\uDF63"
            ),
            Recipe(
                id = 18,
                titleResId = R.string.recipe_18_title,
                descriptionResId = R.string.recipe_18_desc,
                category = MealCategory.DINNER,
                ingredients = listOf(
                    R.string.recipe_18_ing_1, R.string.recipe_18_ing_2, R.string.recipe_18_ing_3,
                    R.string.recipe_18_ing_4, R.string.recipe_18_ing_5, R.string.recipe_18_ing_6
                ),
                steps = listOf(
                    R.string.recipe_18_step_1, R.string.recipe_18_step_2,
                    R.string.recipe_18_step_3, R.string.recipe_18_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 350, sodiumMg = 380, potassiumMg = 520, fiberG = 5, proteinG = 32, fatG = 10, carbsG = 30),
                prepTimeMinutes = 15, cookTimeMinutes = 12, servings = 2, iconEmoji = "\uD83C\uDF5C"
            ),
            Recipe(
                id = 19,
                titleResId = R.string.recipe_19_title,
                descriptionResId = R.string.recipe_19_desc,
                category = MealCategory.DINNER,
                ingredients = listOf(
                    R.string.recipe_19_ing_1, R.string.recipe_19_ing_2, R.string.recipe_19_ing_3,
                    R.string.recipe_19_ing_4, R.string.recipe_19_ing_5, R.string.recipe_19_ing_6
                ),
                steps = listOf(
                    R.string.recipe_19_step_1, R.string.recipe_19_step_2,
                    R.string.recipe_19_step_3, R.string.recipe_19_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 280, sodiumMg = 120, potassiumMg = 580, fiberG = 3, proteinG = 30, fatG = 12, carbsG = 12),
                prepTimeMinutes = 10, cookTimeMinutes = 20, servings = 2, iconEmoji = "\uD83D\uDC1F"
            ),
            Recipe(
                id = 20,
                titleResId = R.string.recipe_20_title,
                descriptionResId = R.string.recipe_20_desc,
                category = MealCategory.DINNER,
                ingredients = listOf(
                    R.string.recipe_20_ing_1, R.string.recipe_20_ing_2, R.string.recipe_20_ing_3,
                    R.string.recipe_20_ing_4, R.string.recipe_20_ing_5, R.string.recipe_20_ing_6
                ),
                steps = listOf(
                    R.string.recipe_20_step_1, R.string.recipe_20_step_2,
                    R.string.recipe_20_step_3, R.string.recipe_20_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 420, sodiumMg = 250, potassiumMg = 550, fiberG = 6, proteinG = 32, fatG = 12, carbsG = 48),
                prepTimeMinutes = 15, cookTimeMinutes = 25, servings = 4, iconEmoji = "\uD83C\uDF5D"
            ),
            Recipe(
                id = 21,
                titleResId = R.string.recipe_21_title,
                descriptionResId = R.string.recipe_21_desc,
                category = MealCategory.DINNER,
                ingredients = listOf(
                    R.string.recipe_21_ing_1, R.string.recipe_21_ing_2, R.string.recipe_21_ing_3,
                    R.string.recipe_21_ing_4, R.string.recipe_21_ing_5, R.string.recipe_21_ing_6
                ),
                steps = listOf(
                    R.string.recipe_21_step_1, R.string.recipe_21_step_2,
                    R.string.recipe_21_step_3, R.string.recipe_21_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 340, sodiumMg = 180, potassiumMg = 620, fiberG = 10, proteinG = 14, fatG = 10, carbsG = 50),
                prepTimeMinutes = 10, cookTimeMinutes = 15, servings = 3, iconEmoji = "\uD83C\uDF5B"
            ),
            Recipe(
                id = 22,
                titleResId = R.string.recipe_22_title,
                descriptionResId = R.string.recipe_22_desc,
                category = MealCategory.DINNER,
                ingredients = listOf(
                    R.string.recipe_22_ing_1, R.string.recipe_22_ing_2, R.string.recipe_22_ing_3,
                    R.string.recipe_22_ing_4, R.string.recipe_22_ing_5, R.string.recipe_22_ing_6
                ),
                steps = listOf(
                    R.string.recipe_22_step_1, R.string.recipe_22_step_2,
                    R.string.recipe_22_step_3, R.string.recipe_22_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 380, sodiumMg = 280, potassiumMg = 720, fiberG = 5, proteinG = 30, fatG = 10, carbsG = 40),
                prepTimeMinutes = 15, cookTimeMinutes = 60, servings = 4, iconEmoji = "\uD83C\uDF72"
            ),
            Recipe(
                id = 23,
                titleResId = R.string.recipe_23_title,
                descriptionResId = R.string.recipe_23_desc,
                category = MealCategory.DINNER,
                ingredients = listOf(
                    R.string.recipe_23_ing_1, R.string.recipe_23_ing_2, R.string.recipe_23_ing_3,
                    R.string.recipe_23_ing_4, R.string.recipe_23_ing_5, R.string.recipe_23_ing_6
                ),
                steps = listOf(
                    R.string.recipe_23_step_1, R.string.recipe_23_step_2,
                    R.string.recipe_23_step_3, R.string.recipe_23_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 320, sodiumMg = 200, potassiumMg = 480, fiberG = 6, proteinG = 22, fatG = 10, carbsG = 35),
                prepTimeMinutes = 15, cookTimeMinutes = 30, servings = 4, iconEmoji = "\uD83C\uDF36\uFE0F"
            ),
            Recipe(
                id = 24,
                titleResId = R.string.recipe_24_title,
                descriptionResId = R.string.recipe_24_desc,
                category = MealCategory.DINNER,
                ingredients = listOf(
                    R.string.recipe_24_ing_1, R.string.recipe_24_ing_2, R.string.recipe_24_ing_3,
                    R.string.recipe_24_ing_4, R.string.recipe_24_ing_5, R.string.recipe_24_ing_6
                ),
                steps = listOf(
                    R.string.recipe_24_step_1, R.string.recipe_24_step_2,
                    R.string.recipe_24_step_3, R.string.recipe_24_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 360, sodiumMg = 150, potassiumMg = 520, fiberG = 4, proteinG = 38, fatG = 14, carbsG = 18),
                prepTimeMinutes = 10, cookTimeMinutes = 30, servings = 2, iconEmoji = "\uD83C\uDF57"
            ),

            // === SNACKS ===
            Recipe(
                id = 25,
                titleResId = R.string.recipe_25_title,
                descriptionResId = R.string.recipe_25_desc,
                category = MealCategory.SNACK,
                ingredients = listOf(
                    R.string.recipe_25_ing_1, R.string.recipe_25_ing_2, R.string.recipe_25_ing_3,
                    R.string.recipe_25_ing_4, R.string.recipe_25_ing_5, R.string.recipe_25_ing_6
                ),
                steps = listOf(
                    R.string.recipe_25_step_1, R.string.recipe_25_step_2,
                    R.string.recipe_25_step_3, R.string.recipe_25_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 220, sodiumMg = 180, potassiumMg = 350, fiberG = 8, proteinG = 8, fatG = 10, carbsG = 26),
                prepTimeMinutes = 10, cookTimeMinutes = 0, servings = 2, iconEmoji = "\uD83E\uDD66"
            ),
            Recipe(
                id = 26,
                titleResId = R.string.recipe_26_title,
                descriptionResId = R.string.recipe_26_desc,
                category = MealCategory.SNACK,
                ingredients = listOf(
                    R.string.recipe_26_ing_1, R.string.recipe_26_ing_2, R.string.recipe_26_ing_3,
                    R.string.recipe_26_ing_4, R.string.recipe_26_ing_5, R.string.recipe_26_ing_6
                ),
                steps = listOf(
                    R.string.recipe_26_step_1, R.string.recipe_26_step_2,
                    R.string.recipe_26_step_3, R.string.recipe_26_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 250, sodiumMg = 5, potassiumMg = 320, fiberG = 4, proteinG = 7, fatG = 16, carbsG = 22),
                prepTimeMinutes = 5, cookTimeMinutes = 0, servings = 4, iconEmoji = "\uD83E\uDD5C"
            ),
            Recipe(
                id = 27,
                titleResId = R.string.recipe_27_title,
                descriptionResId = R.string.recipe_27_desc,
                category = MealCategory.SNACK,
                ingredients = listOf(
                    R.string.recipe_27_ing_1, R.string.recipe_27_ing_2, R.string.recipe_27_ing_3,
                    R.string.recipe_27_ing_4
                ),
                steps = listOf(
                    R.string.recipe_27_step_1, R.string.recipe_27_step_2,
                    R.string.recipe_27_step_3, R.string.recipe_27_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 280, sodiumMg = 3, potassiumMg = 380, fiberG = 6, proteinG = 7, fatG = 16, carbsG = 30),
                prepTimeMinutes = 5, cookTimeMinutes = 0, servings = 1, iconEmoji = "\uD83C\uDF4E"
            ),
            Recipe(
                id = 28,
                titleResId = R.string.recipe_28_title,
                descriptionResId = R.string.recipe_28_desc,
                category = MealCategory.SNACK,
                ingredients = listOf(
                    R.string.recipe_28_ing_1, R.string.recipe_28_ing_2, R.string.recipe_28_ing_3,
                    R.string.recipe_28_ing_4, R.string.recipe_28_ing_5, R.string.recipe_28_ing_6
                ),
                steps = listOf(
                    R.string.recipe_28_step_1, R.string.recipe_28_step_2,
                    R.string.recipe_28_step_3, R.string.recipe_28_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 120, sodiumMg = 60, potassiumMg = 250, fiberG = 0, proteinG = 12, fatG = 2, carbsG = 14),
                prepTimeMinutes = 10, cookTimeMinutes = 0, servings = 2, iconEmoji = "\uD83E\uDED5"
            ),
            Recipe(
                id = 29,
                titleResId = R.string.recipe_29_title,
                descriptionResId = R.string.recipe_29_desc,
                category = MealCategory.SNACK,
                ingredients = listOf(
                    R.string.recipe_29_ing_1, R.string.recipe_29_ing_2, R.string.recipe_29_ing_3,
                    R.string.recipe_29_ing_4, R.string.recipe_29_ing_5, R.string.recipe_29_ing_6
                ),
                steps = listOf(
                    R.string.recipe_29_step_1, R.string.recipe_29_step_2,
                    R.string.recipe_29_step_3, R.string.recipe_29_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 130, sodiumMg = 15, potassiumMg = 280, fiberG = 6, proteinG = 3, fatG = 1, carbsG = 30),
                prepTimeMinutes = 5, cookTimeMinutes = 0, servings = 1, iconEmoji = "\uD83C\uDF53"
            ),
            Recipe(
                id = 30,
                titleResId = R.string.recipe_30_title,
                descriptionResId = R.string.recipe_30_desc,
                category = MealCategory.SNACK,
                ingredients = listOf(
                    R.string.recipe_30_ing_1, R.string.recipe_30_ing_2, R.string.recipe_30_ing_3,
                    R.string.recipe_30_ing_4, R.string.recipe_30_ing_5, R.string.recipe_30_ing_6
                ),
                steps = listOf(
                    R.string.recipe_30_step_1, R.string.recipe_30_step_2,
                    R.string.recipe_30_step_3, R.string.recipe_30_step_4
                ),
                nutritionInfo = NutritionInfo(calories = 240, sodiumMg = 40, potassiumMg = 350, fiberG = 4, proteinG = 8, fatG = 12, carbsG = 28),
                prepTimeMinutes = 5, cookTimeMinutes = 0, servings = 2, iconEmoji = "\uD83C\uDF58"
            )
        )
    }
}
