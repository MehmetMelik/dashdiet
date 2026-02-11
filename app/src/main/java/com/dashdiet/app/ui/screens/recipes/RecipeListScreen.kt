package com.dashdiet.app.ui.screens.recipes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dashdiet.app.R
import com.dashdiet.app.data.model.MealCategory
import com.dashdiet.app.ui.components.CategoryChip
import com.dashdiet.app.ui.components.RecipeCard
import com.dashdiet.app.ui.components.RecipeSearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeListScreen(
    onRecipeClick: (Int) -> Unit,
    viewModel: RecipeListViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        // Header
        TopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.recipes_title),
                    fontWeight = FontWeight.Bold
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        )

        // Search
        RecipeSearchBar(
            query = uiState.searchQuery,
            onQueryChange = { viewModel.updateSearch(it, context) }
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Category filters
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            item {
                FilterChip(
                    selected = uiState.selectedCategory == null,
                    onClick = { viewModel.selectCategory(null) },
                    label = { Text(stringResource(R.string.category_all)) },
                    modifier = Modifier.padding(end = 8.dp)
                )
            }
            items(MealCategory.entries) { category ->
                CategoryChip(
                    category = category,
                    isSelected = uiState.selectedCategory == category,
                    onClick = { viewModel.selectCategory(category) }
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Recipe count
        Text(
            text = stringResource(R.string.recipes_count, uiState.filteredRecipes.size),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        if (uiState.filteredRecipes.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.recipes_no_results),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        } else {
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.padding(bottom = 80.dp)
            ) {
                items(
                    items = uiState.filteredRecipes.chunked(2),
                    key = { it.first().id }
                ) { rowRecipes ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        rowRecipes.forEach { recipe ->
                            RecipeCard(
                                recipe = recipe,
                                onClick = { onRecipeClick(recipe.id) },
                                modifier = Modifier.weight(1f)
                            )
                        }
                        if (rowRecipes.size == 1) {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }
            }
        }
    }
}
