package com.dashdiet.app.data.repository

import com.dashdiet.app.data.model.DayOfWeek
import com.dashdiet.app.data.model.MealCategory
import com.dashdiet.app.data.model.MealPlan
import com.dashdiet.app.data.model.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MealPlanRepository @Inject constructor() {

    private val _weeklyPlan = MutableStateFlow(
        DayOfWeek.entries.associateWith { MealPlan(weekDay = it) }
    )
    val weeklyPlan: StateFlow<Map<DayOfWeek, MealPlan>> = _weeklyPlan.asStateFlow()

    fun addRecipeToPlan(day: DayOfWeek, recipe: Recipe, slot: MealCategory) {
        val currentPlan = _weeklyPlan.value.toMutableMap()
        val dayPlan = currentPlan[day] ?: MealPlan(weekDay = day)

        currentPlan[day] = when (slot) {
            MealCategory.BREAKFAST -> dayPlan.copy(breakfast = recipe)
            MealCategory.LUNCH -> dayPlan.copy(lunch = recipe)
            MealCategory.DINNER -> dayPlan.copy(dinner = recipe)
            MealCategory.SNACK -> dayPlan.copy(snack = recipe)
        }

        _weeklyPlan.value = currentPlan
    }

    fun removeRecipeFromPlan(day: DayOfWeek, slot: MealCategory) {
        val currentPlan = _weeklyPlan.value.toMutableMap()
        val dayPlan = currentPlan[day] ?: return

        currentPlan[day] = when (slot) {
            MealCategory.BREAKFAST -> dayPlan.copy(breakfast = null)
            MealCategory.LUNCH -> dayPlan.copy(lunch = null)
            MealCategory.DINNER -> dayPlan.copy(dinner = null)
            MealCategory.SNACK -> dayPlan.copy(snack = null)
        }

        _weeklyPlan.value = currentPlan
    }

    fun clearDay(day: DayOfWeek) {
        val currentPlan = _weeklyPlan.value.toMutableMap()
        currentPlan[day] = MealPlan(weekDay = day)
        _weeklyPlan.value = currentPlan
    }

    fun clearAll() {
        _weeklyPlan.value = DayOfWeek.entries.associateWith { MealPlan(weekDay = it) }
    }
}
