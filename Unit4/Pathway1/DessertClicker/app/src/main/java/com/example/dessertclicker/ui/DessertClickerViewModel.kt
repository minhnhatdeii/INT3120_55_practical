package com.example.dessertclicker.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.model.Dessert
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DessertClickerViewModel : ViewModel() {

    private val _state = MutableStateFlow(DessertClickerState(desserts = Datasource.dessertList))
    val state: StateFlow<DessertClickerState> = _state.asStateFlow()

    fun onDessertClicked() {
        val currentState = _state.value
        val newRevenue = currentState.revenue + currentState.currentDessert.price
        val newDessertsSold = currentState.dessertsSold + 1
        val newDessertIndex = determineDessertIndex(currentState.desserts, newDessertsSold)
        _state.value = currentState.copy(
            revenue = newRevenue,
            dessertsSold = newDessertsSold,
            currentDessertIndex = newDessertIndex
        )
    }

    private fun determineDessertIndex(desserts: List<Dessert>, dessertsSold: Int): Int {
        var dessertIndex = 0
        for (i in desserts.indices) {
            if (dessertsSold >= desserts[i].startProductionAmount) {
                dessertIndex = i
            } else {
                break
            }
        }
        return dessertIndex
    }
}


