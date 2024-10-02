package com.example.mycity

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class Recommendation(
    val id: String,
    val imageResId: Int,
    val text: String
)

data class Category(
    val id: String,
    val name: String,
    val recommendations: List<Recommendation>
)

class CityViewModel : ViewModel() {
    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories: StateFlow<List<Category>> get() = _categories

    init {
        // Example data
        _categories.value = listOf(
            Category(
                id = "1",
                name = "Category 1",
                recommendations = listOf(
                    Recommendation("1", R.drawable.ic_launcher_foreground, "Recommendation 1"),
                    Recommendation("2", R.drawable.ic_launcher_foreground, "Recommendation 2")
                )
            ),
            Category(
                id = "2",
                name = "Category 2",
                recommendations = listOf(
                    Recommendation("3",  R.drawable.ic_launcher_foreground, "Recommendation 3"),
                    Recommendation("4", R.drawable.ic_launcher_foreground, "Recommendation 4")
                )
            ),
            Category(
                id = "3",
                name = "Category 3",
                recommendations = listOf(
                    Recommendation("5",  R.drawable.ic_launcher_foreground, "Recommendation 5"),
                    Recommendation("6",  R.drawable.ic_launcher_foreground, "Recommendation 6")
                )
            )
        )
    }
}
