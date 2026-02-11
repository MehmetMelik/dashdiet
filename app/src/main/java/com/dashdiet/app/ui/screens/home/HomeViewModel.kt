package com.dashdiet.app.ui.screens.home

import androidx.lifecycle.ViewModel
import com.dashdiet.app.R
import com.dashdiet.app.data.model.Recipe
import com.dashdiet.app.data.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class HomeUiState(
    val featuredRecipes: List<Recipe> = emptyList(),
    val dailyTipResId: Int = R.string.tip_1
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository
) : ViewModel() {

    private val tips = listOf(
        R.string.tip_1, R.string.tip_2, R.string.tip_3, R.string.tip_4, R.string.tip_5,
        R.string.tip_6, R.string.tip_7, R.string.tip_8, R.string.tip_9, R.string.tip_10
    )

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        val dayOfYear = java.time.LocalDate.now().dayOfYear
        _uiState.value = HomeUiState(
            featuredRecipes = recipeRepository.getFeaturedRecipes(),
            dailyTipResId = tips[dayOfYear % tips.size]
        )
    }
}
