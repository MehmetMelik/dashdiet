package com.dashdiet.app.ui.screens.mealplan

import androidx.lifecycle.ViewModel
import com.dashdiet.app.data.model.DayOfWeek
import com.dashdiet.app.data.model.MealCategory
import com.dashdiet.app.data.model.MealPlan
import com.dashdiet.app.data.model.Recipe
import com.dashdiet.app.data.repository.MealPlanRepository
import com.dashdiet.app.data.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MealPlanViewModel @Inject constructor(
    private val mealPlanRepository: MealPlanRepository,
    private val recipeRepository: RecipeRepository
) : ViewModel() {

    val weeklyPlan: StateFlow<Map<DayOfWeek, MealPlan>> = mealPlanRepository.weeklyPlan

    private val _selectedDay = MutableStateFlow(DayOfWeek.MONDAY)
    val selectedDay: StateFlow<DayOfWeek> = _selectedDay.asStateFlow()

    fun selectDay(day: DayOfWeek) {
        _selectedDay.value = day
    }

    fun addRecipe(day: DayOfWeek, recipe: Recipe, slot: MealCategory) {
        mealPlanRepository.addRecipeToPlan(day, recipe, slot)
    }

    fun removeRecipe(day: DayOfWeek, slot: MealCategory) {
        mealPlanRepository.removeRecipeFromPlan(day, slot)
    }

    fun clearAll() {
        mealPlanRepository.clearAll()
    }

    fun getRecipesForCategory(category: MealCategory): List<Recipe> {
        return recipeRepository.getRecipesByCategory(category)
    }
}
