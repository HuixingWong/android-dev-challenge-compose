package com.example.androiddevchallenge

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.Dog

class MainViewModel : ViewModel() {
    val dogs by mutableStateOf(
        listOf(
            Dog(
                "lili", "corgi",
                "Adult", "Female", R.drawable.keke1
            ),
            Dog(
                "maomao", "corgi",
                "Adult", "male", R.drawable.keke2
            ),
            Dog(
                "popo", "corgi",
                "Adult", "male", R.drawable.keke3
            ),
            Dog(
                "coco", "corgi",
                "Adult", "male", R.drawable.keke4
            ),
            Dog(
                "dodo", "corgi",
                "Adult", "Female", R.drawable.keke6
            ),
            Dog(
                "jojo", "corgi",
                "Adult", "Female", R.drawable.keke7
            ),
            Dog(
                "blutu", "corgi",
                "Adult", "Female", R.drawable.keke8
            )
        )
    )

    var currentDog: Dog by mutableStateOf(dogs[0])

    fun setCurrent(dog: Dog) {
        currentDog = dog
    }
}