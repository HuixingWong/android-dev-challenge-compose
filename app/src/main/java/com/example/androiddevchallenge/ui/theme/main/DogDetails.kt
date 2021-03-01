package com.example.androiddevchallenge.ui.theme.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Dog
import com.example.androiddevchallenge.ui.theme.commonEnter

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun DogDetails(dog: Dog, onAdopt: (Dog) -> Unit = {}) {
    val visible = remember(calculation = { mutableStateOf(true) })
    AnimatedVisibility(
        visible.value,
        enter = commonEnter,
        initiallyVisible = false
    ) {
        Column(
          Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
        ) {
            Box {
                Image(
                    painterResource(dog.pictureResId),
                    "Dog picture: ${dog.name}",
                    Modifier.aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
                Button(
                    { onAdopt(dog) },
                  Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
                ) {
                    Text(text = "Adopt")
                }
            }
            Column(
              Modifier
                .padding(16.dp, 8.dp)
                .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Name: ${dog.name}", style = MaterialTheme.typography.h3)
                ProvideTextStyle(MaterialTheme.typography.h5) {
                    Text("Breed: ${dog.breed}")
                    Text("Age: ${dog.age}")
                    Text("Gender: ${dog.gender}")
                }
            }
        }
    }

}