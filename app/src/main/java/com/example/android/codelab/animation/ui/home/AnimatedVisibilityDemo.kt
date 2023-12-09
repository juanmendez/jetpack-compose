package com.example.android.codelab.animation.ui.home

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.android.codelab.animation.ui.AnimationCodelabTheme

@Composable
fun AnimatedVisibilityDemo(
    modifier: Modifier = Modifier,
) {
    var visible by remember {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AnimatedVisibility(visible = visible) {
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
fun AnimatedVisibilityDemoPreview() {
    AnimationCodelabTheme {
        Scaffold {
            AnimatedVisibilityDemo()
        }
    }
}