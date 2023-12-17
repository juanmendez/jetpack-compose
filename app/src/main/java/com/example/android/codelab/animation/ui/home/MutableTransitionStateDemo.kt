package com.example.android.codelab.animation.ui.home

import android.util.Log
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterExitState
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateColor
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.codelab.animation.ui.AnimationCodelabTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MutableTransitionStateDemo(
    modifier: Modifier = Modifier,
) {
    var visible by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(),
            exit = fadeOut(),
            label = "animatedVisibility"
        ) { // this: AnimatedVisibilityScope
            // Use AnimatedVisibilityScope#transition to add a custom animation
            // to the AnimatedVisibility.
            val background by transition.animateColor(label = "label makes preview work") { state ->
                if (state == EnterExitState.Visible) Color.Blue else Color.Gray
            }
            Box(
                modifier = Modifier
                    .size(128.dp)
                    .background(background)
            )
        }

        Button(onClick = {
            visible = !visible
        }) {
            Text(text = "press me")
        }

        Row {
            var count by remember { mutableStateOf(0) }
            Button(onClick = { count++ }) {
                Text("Add")
            }

            Button(onClick = { count-- }) {
                Text("Substract")
            }

            Spacer(modifier = Modifier.width(20.dp))

            Text(text = "Count: ")

            AnimatedContent(
                targetState = count,
                label = "animatedContent",
                transitionSpec = {
                    Log.i("Switch", "$targetState vs $initialState")
                    // Compare the incoming number with the previous number.
                    if (targetState > initialState) {
                        // If the target number is larger, it slides up and fades in
                        // while the initial (smaller) number slides up and fades out.
                        (slideInVertically { height -> height } + fadeIn()).togetherWith(slideOutVertically { height -> -height } + fadeOut())
                    } else {
                        // If the target number is smaller, it slides down and fades in
                        // while the initial number slides down and fades out.
                        (slideInVertically { height -> -height } + fadeIn()).togetherWith(slideOutVertically { height -> height } + fadeOut())
                    }.using(
                        // Disable clipping since the faded slide-in/out should
                        // be displayed out of bounds.
                        SizeTransform(clip = false)
                    )
                },
            ) { targetCount ->
                // Make sure to use `targetCount`, not `count`.
                Text(text = targetCount.toString())
            }
        }
    }
}

@Preview
@Composable
fun MutableTransitionStateDemoPreview() {
    AnimationCodelabTheme {
        MutableTransitionStateDemo()
    }
}