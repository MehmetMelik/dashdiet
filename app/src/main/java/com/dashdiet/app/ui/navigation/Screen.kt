package com.dashdiet.app.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.ui.graphics.vector.ImageVector
import com.dashdiet.app.R

sealed class Screen(val route: String) {
    data object Auth : Screen("auth")
    data object Home : Screen("home")
    data object Recipes : Screen("recipes")
    data object RecipeDetail : Screen("recipe/{recipeId}") {
        fun createRoute(recipeId: Int) = "recipe/$recipeId"
    }
    data object MealPlan : Screen("meal_plan")
    data object Profile : Screen("profile")
    data object DashInfo : Screen("dash_info")
}

enum class BottomNavItem(
    val screen: Screen,
    val titleResId: Int,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {
    HOME(Screen.Home, R.string.nav_home, Icons.Filled.Home, Icons.Outlined.Home),
    RECIPES(Screen.Recipes, R.string.nav_recipes, Icons.Filled.Restaurant, Icons.Outlined.Restaurant),
    MEAL_PLAN(Screen.MealPlan, R.string.nav_meal_plan, Icons.Filled.CalendarMonth, Icons.Outlined.CalendarMonth),
    PROFILE(Screen.Profile, R.string.nav_profile, Icons.Filled.Person, Icons.Outlined.Person)
}
