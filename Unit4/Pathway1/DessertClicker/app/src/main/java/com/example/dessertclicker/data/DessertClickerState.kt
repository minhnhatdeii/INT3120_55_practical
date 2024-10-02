package com.example.dessertclicker.ui

import com.example.dessertclicker.model.Dessert

data class DessertClickerState(
    val desserts: List<Dessert>,
    val revenue: Int = 0,
    val dessertsSold: Int = 0,
    val currentDessertIndex: Int = 0
) {
    val currentDessert: Dessert
        get() = desserts[currentDessertIndex]
}
