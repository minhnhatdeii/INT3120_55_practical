package com.example.mycity

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(navController: NavHostController, categoryId: String?) {
    val viewModel: CityViewModel = viewModel()
    val categories by viewModel.categories.collectAsState()
    val category = categories.find { it.id == categoryId }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(category?.name ?: "Category") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            HorizontalDivider(
                thickness = 1.dp,
                color = Color.Black
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                category?.recommendations?.let { recommendations ->
                    items(recommendations) { recommendation ->
                        RecommendationItem(
                            recommendation = recommendation,
                            onClick = { navController.navigate("recommendation/${recommendation.id}") }
                        )
                        HorizontalDivider(
                            thickness = 1.dp,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun RecommendationItem(
    recommendation: Recommendation,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp)
    ) {
        Image(
            painter = painterResource(id = recommendation.imageResId),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = recommendation.text,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
