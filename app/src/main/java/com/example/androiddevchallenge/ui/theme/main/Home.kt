package com.example.androiddevchallenge.ui.theme.main

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import com.example.androiddevchallenge.MainViewModel

@Composable
fun Home(viewModel: MainViewModel, detail: () -> Unit) {
    val snackbarHostState = SnackbarHostState()
    Scaffold(topBar = {
        TopAppBar(title = {
            Text("dog lists")
        })
    },
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }) {
        DogList(viewModel.dogs) { dog ->
            viewModel.setCurrent(dog)
            detail.invoke()
        }
    }
}