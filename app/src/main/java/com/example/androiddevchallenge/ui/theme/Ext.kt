package com.example.androiddevchallenge.ui.theme

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.ui.unit.IntOffset

@ExperimentalAnimationApi
val commonEnter = slideIn(
    // Specifies the starting offset of the slide-in to be 1/4 of the width to the right,
    // 100 (pixels) below the content position, which results in a simultaneous slide up
    // and slide left.
    { fullSize -> IntOffset(fullSize.width / 4, 100) },
    tween(300, easing = LinearOutSlowInEasing)
)