package com.dashdiet.app.ui.screens.mealplan

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DeleteSweep
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dashdiet.app.R
import com.dashdiet.app.data.model.DayOfWeek
import com.dashdiet.app.data.model.MealCategory
import com.dashdiet.app.data.model.MealPlan
import com.dashdiet.app.data.model.Recipe

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealPlanScreen(
    onRecipeClick: (Int) -> Unit,
    viewModel: MealPlanViewModel = hiltViewModel()
) {
    val weeklyPlan by viewModel.weeklyPlan.collectAsState()
    val selectedDay by viewModel.selectedDay.collectAsState()
    var showRecipePicker by remember { mutableStateOf(false) }
    var pickingSlot by remember { mutableStateOf<MealCategory?>(null) }

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.meal_plan_title),
                    fontWeight = FontWeight.Bold
                )
            },
            actions = {
                IconButton(onClick = { viewModel.clearAll() }) {
                    Icon(Icons.Default.DeleteSweep, contentDescription = stringResource(R.string.meal_plan_clear_all))
                }
            }
        )

        // Day selector
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(DayOfWeek.entries) { day ->
                FilterChip(
                    selected = day == selectedDay,
                    onClick = { viewModel.selectDay(day) },
                    label = { Text(stringResource(day.shortResId)) },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Selected day title
        Text(
            text = stringResource(selectedDay.titleResId),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        val dayPlan = weeklyPlan[selectedDay] ?: MealPlan(weekDay = selectedDay)

        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(bottom = 80.dp)
        ) {
            item {
                MealSlotCard(
                    slotName = stringResource(R.string.category_breakfast),
                    emoji = MealCategory.BREAKFAST.emoji,
                    recipe = dayPlan.breakfast,
                    onAddClick = {
                        pickingSlot = MealCategory.BREAKFAST
                        showRecipePicker = true
                    },
                    onRemoveClick = { viewModel.removeRecipe(selectedDay, MealCategory.BREAKFAST) },
                    onRecipeClick = { dayPlan.breakfast?.let { onRecipeClick(it.id) } }
                )
            }
            item {
                MealSlotCard(
                    slotName = stringResource(R.string.category_lunch),
                    emoji = MealCategory.LUNCH.emoji,
                    recipe = dayPlan.lunch,
                    onAddClick = {
                        pickingSlot = MealCategory.LUNCH
                        showRecipePicker = true
                    },
                    onRemoveClick = { viewModel.removeRecipe(selectedDay, MealCategory.LUNCH) },
                    onRecipeClick = { dayPlan.lunch?.let { onRecipeClick(it.id) } }
                )
            }
            item {
                MealSlotCard(
                    slotName = stringResource(R.string.category_dinner),
                    emoji = MealCategory.DINNER.emoji,
                    recipe = dayPlan.dinner,
                    onAddClick = {
                        pickingSlot = MealCategory.DINNER
                        showRecipePicker = true
                    },
                    onRemoveClick = { viewModel.removeRecipe(selectedDay, MealCategory.DINNER) },
                    onRecipeClick = { dayPlan.dinner?.let { onRecipeClick(it.id) } }
                )
            }
            item {
                MealSlotCard(
                    slotName = stringResource(R.string.category_snacks),
                    emoji = MealCategory.SNACK.emoji,
                    recipe = dayPlan.snack,
                    onAddClick = {
                        pickingSlot = MealCategory.SNACK
                        showRecipePicker = true
                    },
                    onRemoveClick = { viewModel.removeRecipe(selectedDay, MealCategory.SNACK) },
                    onRecipeClick = { dayPlan.snack?.let { onRecipeClick(it.id) } }
                )
            }

            // Daily totals
            item {
                DailyTotalsCard(dayPlan)
            }
        }
    }

    // Recipe picker dialog
    if (showRecipePicker && pickingSlot != null) {
        RecipePickerDialog(
            recipes = viewModel.getRecipesForCategory(pickingSlot!!),
            onRecipeSelected = { recipe ->
                viewModel.addRecipe(selectedDay, recipe, pickingSlot!!)
                showRecipePicker = false
                pickingSlot = null
            },
            onDismiss = {
                showRecipePicker = false
                pickingSlot = null
            }
        )
    }
}

@Composable
private fun MealSlotCard(
    slotName: String,
    emoji: String,
    recipe: Recipe?,
    onAddClick: () -> Unit,
    onRemoveClick: () -> Unit,
    onRecipeClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = if (recipe != null)
                MaterialTheme.colorScheme.secondaryContainer
            else
                MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = emoji, style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = slotName,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    if (recipe != null) {
                        Text(
                            text = stringResource(recipe.titleResId),
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = "${recipe.nutritionInfo.calories} kcal",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                    } else {
                        Text(
                            text = stringResource(R.string.meal_plan_empty),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            if (recipe != null) {
                IconButton(onClick = onRemoveClick) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = stringResource(R.string.meal_plan_remove),
                        tint = MaterialTheme.colorScheme.error
                    )
                }
            } else {
                IconButton(onClick = onAddClick) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = stringResource(R.string.meal_plan_add),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@Composable
private fun DailyTotalsCard(dayPlan: MealPlan) {
    val meals = listOfNotNull(dayPlan.breakfast, dayPlan.lunch, dayPlan.dinner, dayPlan.snack)
    if (meals.isEmpty()) return

    val totalCalories = meals.sumOf { it.nutritionInfo.calories }
    val totalSodium = meals.sumOf { it.nutritionInfo.sodiumMg }
    val totalProtein = meals.sumOf { it.nutritionInfo.proteinG }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = stringResource(R.string.meal_plan_daily_total),
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("$totalCalories", fontWeight = FontWeight.Bold)
                    Text(stringResource(R.string.nutrition_calories), style = MaterialTheme.typography.labelSmall)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("$totalSodium mg", fontWeight = FontWeight.Bold)
                    Text(stringResource(R.string.nutrition_sodium), style = MaterialTheme.typography.labelSmall)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("$totalProtein g", fontWeight = FontWeight.Bold)
                    Text(stringResource(R.string.nutrition_protein), style = MaterialTheme.typography.labelSmall)
                }
            }
        }
    }
}

@Composable
private fun RecipePickerDialog(
    recipes: List<Recipe>,
    onRecipeSelected: (Recipe) -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(stringResource(R.string.meal_plan_select_recipe)) },
        text = {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(recipes) { recipe ->
                    Card(
                        onClick = { onRecipeSelected(recipe) },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(recipe.iconEmoji, style = MaterialTheme.typography.titleLarge)
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text(
                                    text = stringResource(recipe.titleResId),
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.SemiBold
                                )
                                Text(
                                    text = "${recipe.nutritionInfo.calories} kcal",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    }
                }
            }
        },
        confirmButton = {},
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(stringResource(R.string.cancel))
            }
        }
    )
}
