package com.example.lunchtray

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.lunchtray.datasource.DataSource
import com.example.lunchtray.ui.AccompanimentMenuScreen
import com.example.lunchtray.ui.CheckoutScreen
import com.example.lunchtray.ui.EntreeMenuScreen
import com.example.lunchtray.ui.OrderViewModel
import com.example.lunchtray.ui.SideDishMenuScreen
import com.example.lunchtray.ui.StartOrderScreen

enum class LunchTrayScreen(@StringRes val title: Int) {
    Start(R.string.start_order),
    EntreeMenu(R.string.choose_entree),
    SideDishMenu(R.string.choose_side_dish),
    AccompanimentMenu(R.string.choose_accompaniment),
    Checkout(R.string.order_checkout)
}

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun LunchTrayAppBar(
    @StringRes currentScreenTitle: Int,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = { Text(stringResource(currentScreenTitle)) },
        navigationIcon = if (canNavigateBack) {
            {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        } else {
            {}
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LunchTrayApp() {
    val navController = rememberNavController()

    val viewModel: OrderViewModel = viewModel()

    Scaffold(
        topBar = {
            LunchTrayAppBar(
                currentScreenTitle = getCurrentScreenTitle(navController),
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = LunchTrayScreen.Start.name,
            Modifier.padding(innerPadding)
                .fillMaxSize()
        ) {
            composable(LunchTrayScreen.Start.name) {
                StartOrderScreen(
                    onStartOrderButtonClicked = { navController.navigate(LunchTrayScreen.EntreeMenu.name) }
                )
            }

            composable(LunchTrayScreen.EntreeMenu.name) {
                EntreeMenuScreen(
                    options = DataSource.entreeMenuItems,
                    onCancelButtonClicked = { navController.popBackStack() },
                    onNextButtonClicked = { navController.navigate(LunchTrayScreen.SideDishMenu.name) },
                    onSelectionChanged = { viewModel.updateEntree(it) }
                )
            }

            composable(LunchTrayScreen.SideDishMenu.name) {
                SideDishMenuScreen(
                    options = DataSource.sideDishMenuItems,
                    onCancelButtonClicked = { navController.popBackStack() },
                    onNextButtonClicked = { navController.navigate(LunchTrayScreen.AccompanimentMenu.name) },
                    onSelectionChanged = { viewModel.updateSideDish(it) }
                )
            }

            composable(LunchTrayScreen.AccompanimentMenu.name) {
                AccompanimentMenuScreen(
                    options = DataSource.accompanimentMenuItems,
                    onCancelButtonClicked = { navController.popBackStack() },
                    onNextButtonClicked = { navController.navigate(LunchTrayScreen.Checkout.name) },
                    onSelectionChanged = { viewModel.updateAccompaniment(it) }
                )
            }

            composable(LunchTrayScreen.Checkout.name) {
                CheckoutScreen(
                    orderUiState = uiState,
                    onNextButtonClicked = { navController.navigate(LunchTrayScreen.Start.name) },
                    onCancelButtonClicked = { viewModel.resetOrder() }
                )
            }
        }
    }
}


@Composable
fun getCurrentScreenTitle(navController: NavHostController): Int {
    val backStackEntry = navController.currentBackStackEntryAsState().value
    return when (backStackEntry?.destination?.route) {
        LunchTrayScreen.SideDishMenu.name -> R.string.choose_side_dish
        LunchTrayScreen.AccompanimentMenu.name -> R.string.choose_accompaniment
        LunchTrayScreen.Checkout.name -> R.string.order_checkout
        else -> R.string.choose_entree
    }
}
