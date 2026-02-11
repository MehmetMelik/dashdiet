package com.dashdiet.app.ui.screens.dashinfo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dashdiet.app.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashDietInfoScreen(
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.dash_info_title)) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = stringResource(R.string.back))
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // What is DASH
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                Icons.Default.Favorite,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = stringResource(R.string.dash_info_what),
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = stringResource(R.string.dash_info_what_desc),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }

            // Benefits
            item {
                Text(
                    text = stringResource(R.string.dash_info_benefits),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }

            val benefits = listOf(
                R.string.dash_info_benefit_1,
                R.string.dash_info_benefit_2,
                R.string.dash_info_benefit_3,
                R.string.dash_info_benefit_4,
                R.string.dash_info_benefit_5,
                R.string.dash_info_benefit_6
            )

            items(benefits) { benefitResId ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Icon(
                        Icons.Default.Check,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = stringResource(benefitResId),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            // Guidelines
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(R.string.dash_info_guidelines),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }

            val guidelines = listOf(
                R.string.dash_info_guideline_1,
                R.string.dash_info_guideline_2,
                R.string.dash_info_guideline_3,
                R.string.dash_info_guideline_4,
                R.string.dash_info_guideline_5,
                R.string.dash_info_guideline_6,
                R.string.dash_info_guideline_7
            )

            items(guidelines) { guidelineResId ->
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            modifier = Modifier.size(8.dp),
                            shape = MaterialTheme.shapes.extraSmall,
                            color = MaterialTheme.colorScheme.primary
                        ) {}
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = stringResource(guidelineResId),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }

            // Daily servings
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(R.string.dash_info_daily_servings),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }

            val servings = listOf(
                R.string.dash_info_grains,
                R.string.dash_info_vegetables,
                R.string.dash_info_fruits,
                R.string.dash_info_dairy,
                R.string.dash_info_meat,
                R.string.dash_info_nuts,
                R.string.dash_info_fats,
                R.string.dash_info_sweets
            )

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        servings.forEach { servingResId ->
                            Text(
                                text = stringResource(servingResId),
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(vertical = 4.dp)
                            )
                        }
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(16.dp)) }
        }
    }
}
