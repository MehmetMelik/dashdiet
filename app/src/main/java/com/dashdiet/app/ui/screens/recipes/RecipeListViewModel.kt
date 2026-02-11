package com.dashdiet.app.ui.screens.recipes

import android.content.Context
import androidx.lifecycle.ViewModel
import com.dashdiet.app.data.model.MealCategory
import com.dashdiet.app.data.model.Recipe
import com.dashdiet.app.data.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class RecipeListUiState(
    val allRecipes: List<Recipe> = emptyList(),
    val filteredRecipes: List<Recipe> = emptyList(),
    val selectedCategory: MealCategory? = null,
    val searchQuery: String = ""
)

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(RecipeListUiState())
    val uiState: StateFlow<RecipeListUiState> = _uiState.asStateFlow()

    init {
        val recipes = recipeRepository.getAllRecipes()
        _uiState.value = RecipeListUiState(
            allRecipes = recipes,
            filteredRecipes = recipes
        )
    }

    fun selectCategory(category: MealCategory?) {
        val current = _uiState.value
        _uiState.value = current.copy(
            selectedCategory = category,
            filteredRecipes = filterRecipes(current.allRecipes, category, current.searchQuery, null)
        )
    }

    fun updateSearch(query: String, context: Context) {
        val current = _uiState.value
        _uiState.value = current.copy(
            searchQuery = query,
            filteredRecipes = filterRecipes(current.allRecipes, current.selectedCategory, query, context)
        )
    }

    private fun filterRecipes(
        recipes: List<Recipe>,
        category: MealCategory?,
        query: String,
        context: Context?
    ): List<Recipe> {
        var filtered = recipes

        if (category != null) {
            filtered = filtered.filter { it.category == category }
        }

        if (query.isNotBlank() && context != null) {
            filtered = filtered.filter { recipe ->
                context.getString(recipe.titleResId).contains(query, ignoreCase = true) ||
                context.getString(recipe.descriptionResId).contains(query, ignoreCase = true)
            }
        }

        return filtered
    }
}
