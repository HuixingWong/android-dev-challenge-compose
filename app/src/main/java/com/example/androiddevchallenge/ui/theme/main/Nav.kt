package com.example.androiddevchallenge.ui.theme.main

import androidx.compose.animation.Crossfade
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.MainViewModel


fun NavGraphBuilder.myNavigation(navController: NavController, viewModel: MainViewModel) {
    composable("home") {
        Crossfade(targetState = "home") {
            Surface(color = MaterialTheme.colors.background) {
                Home(viewModel){
                    navController.navigate("detail")
                }
            }
        }
    }
    composable("detail") {
        Crossfade(targetState = "detail") {
            Surface(color = MaterialTheme.colors.background) {
                DogDetails(viewModel.currentDog) {
                    
                }
            }
        }
    }
}