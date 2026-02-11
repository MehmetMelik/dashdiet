package com.dashdiet.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.dashdiet.app.ui.screens.auth.AuthScreen
import com.dashdiet.app.ui.screens.dashinfo.DashDietInfoScreen
import com.dashdiet.app.ui.screens.home.HomeScreen
import com.dashdiet.app.ui.screens.mealplan.MealPlanScreen
import com.dashdiet.app.ui.screens.profile.ProfileScreen
import com.dashdiet.app.ui.screens.recipes.RecipeDetailScreen
import com.dashdiet.app.ui.screens.recipes.RecipeListScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String = Screen.Auth.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.Auth.route) {
            AuthScreen(
                onSignedIn = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Auth.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Home.route) {
            HomeScreen(
                onRecipeClick = { recipeId ->
                    navController.navigate(Screen.RecipeDetail.createRoute(recipeId))
                },
                onViewAllRecipes = {
                    navController.navigate(Screen.Recipes.route)
                },
                onDashInfoClick = {
                    navController.navigate(Screen.DashInfo.route)
                }
            )
        }

        composable(Screen.Recipes.route) {
            RecipeListScreen(
                onRecipeClick = { recipeId ->
                    navController.navigate(Screen.RecipeDetail.createRoute(recipeId))
                }
            )
        }

        composable(
            route = Screen.RecipeDetail.route,
            arguments = listOf(navArgument("recipeId") { type = NavType.IntType })
        ) { backStackEntry ->
            val recipeId = backStackEntry.arguments?.getInt("recipeId") ?: return@composable
            RecipeDetailScreen(
                recipeId = recipeId,
                onBackClick = { navController.popBackStack() }
            )
        }

        composable(Screen.MealPlan.route) {
            MealPlanScreen(
                onRecipeClick = { recipeId ->
                    navController.navigate(Screen.RecipeDetail.createRoute(recipeId))
                }
            )
        }

        composable(Screen.Profile.route) {
            ProfileScreen(
                onSignOut = {
                    navController.navigate(Screen.Auth.route) {
                        popUpTo(0) { inclusive = true }
                    }
                },
                onDashInfoClick = {
                    navController.navigate(Screen.DashInfo.route)
                }
            )
        }

        composable(Screen.DashInfo.route) {
            DashDietInfoScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
