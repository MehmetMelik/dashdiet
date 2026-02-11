package com.dashdiet.app.ui.screens.recipes

import androidx.lifecycle.ViewModel
import com.dashdiet.app.data.model.Recipe
import com.dashdiet.app.data.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository
) : ViewModel() {

    private val _recipe = MutableStateFlow<Recipe?>(null)
    val recipe: StateFlow<Recipe?> = _recipe.asStateFlow()

    fun loadRecipe(recipeId: Int) {
        _recipe.value = recipeRepository.getRecipeById(recipeId)
    }
}
