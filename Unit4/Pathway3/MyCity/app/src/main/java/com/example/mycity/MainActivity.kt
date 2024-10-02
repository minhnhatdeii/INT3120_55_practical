package com.example.mycity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    MaterialTheme {
        val navController = rememberNavController()
        NavigationGraph(navController)
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "city") {
        composable("city") {
            CityScreen(navController)
        }
        composable("category/{categoryId}") { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId")
            CategoryScreen(navController, categoryId)
        }
        composable("recommendation/{recommendationId}") { backStackEntry ->
            val recommendationId = backStackEntry.arguments?.getString("recommendationId")
            RecommendationScreen(navController, recommendationId)
        }
    }
}
