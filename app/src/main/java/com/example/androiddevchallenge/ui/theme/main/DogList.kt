package com.example.androiddevchallenge.ui.theme.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Dog
import com.example.androiddevchallenge.ui.theme.commonEnter
import java.util.*

@Composable
fun DogList(dogs: List<Dog>, onDogClick: (Dog) -> Unit = {}) {
    LazyColumn {
        items(dogs) { dog ->
            DogItem(dog,
              Modifier
                .clickable {
                  onDogClick(dog)
                }
                .fillMaxWidth())
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun DogItem(dog: Dog, modifier: Modifier = Modifier) {
    val visible = remember(calculation = { mutableStateOf(true) })
    val color = remember(calculation = {
        val rnd = Random()
        Color(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    })
    AnimatedVisibility(
        visible.value,
        enter = commonEnter,
        initiallyVisible = false
    ) {
        Card(
          modifier
            .background(color)
            .padding(16.dp)
        ) {
            Row {
                Image(
                    painterResource(dog.pictureResId),
                    "Picture of dog: ${dog.name}",
                    Modifier.size(120.dp),
                    contentScale = ContentScale.Crop
                )
                Column(Modifier.padding(8.dp)) {
                    Text(dog.name, style = MaterialTheme.typography.h4)
                    Text(dog.breed)
                    Text(dog.age)
                }
            }
        }
    }

}

