package com.digi.mywishlist.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.digi.mywishlist.ui.screens.AddScreen
import com.digi.mywishlist.ui.screens.HomeScreen

enum class Screen {
    Home, List, Detail, Search, Add
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyNavigation() {
    val viewModel: MyViewModel = viewModel(factory = AppViewModelProvider.viewModel)
    val navController = rememberNavController()
    val uiState = viewModel.uiState.collectAsState().value

    // composable for each screen
    NavHost(navController = navController, startDestination = Screen.Home.name) {
        composable(Screen.Home.name) {
            HomeScreen{
               when(it){
                   UiEvent.OnAddCardClicked -> navController.navigate(Screen.Add.name)
                   UiEvent.OnSearchCardClicked -> navController.navigate(Screen.Search.name)
                   UiEvent.OnViewCardClicked -> navController.navigate(Screen.List.name)
                   else -> {}
               }
            }
        }
        composable(Screen.List.name) {}
        composable(Screen.Detail.name) {}
        composable(Screen.Add.name) {
            AddScreen(uiState){

            }
        }
        composable(Screen.Search.name) {}
    }
}
