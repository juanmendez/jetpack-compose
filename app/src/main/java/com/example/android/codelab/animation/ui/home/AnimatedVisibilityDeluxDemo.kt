package com.example.android.codelab.animation.ui.home

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.codelab.animation.ui.AnimationCodelabTheme

@Composable
fun AnimatedVisibilityDeluxDemo(
    modifier: Modifier = Modifier,
) {
    var visible by remember {
        mutableStateOf(true)
    }

    val density = LocalDensity.current

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AnimatedVisibility(
            visible = visible,
            enter = slideInHorizontally {
                with(density) {
                    -40.dp.roundToPx()
                }
            } + expandVertically(
                // Expand from the top.
                expandFrom = Alignment.Bottom
            ) + fadeIn(
                // Fade in with the initial alpha of 0.3f.
                initialAlpha = 0.3f
            ),
            exit = slideOutVertically() + shrinkVertically() + fadeOut()
        ) {
            Box(
                modifier = modifier
                    .background(Color.Blue)
                    .fillMaxWidth()
                    .fillMaxHeight(.75f)
            )
        }

        Button(onClick = {
            visible = !visible
        }) {
            Text(text = "press me")
        }
    }

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview
@Composable
fun AnimatedVisibilityDeluxDemoPreview() {
    AnimationCodelabTheme {
        Scaffold {
            AnimatedVisibilityDeluxDemo()
        }
    }
}