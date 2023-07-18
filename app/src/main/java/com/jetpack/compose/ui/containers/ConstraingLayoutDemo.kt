package com.jetpack.compose.ui.containers

import CardCheckBox
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.jetpack.compose.R
import com.jetpack.compose.ui.elements.CheckBoxWithLabel
import com.jetpack.compose.ui.theme.ComposeTheme

@Composable
fun ConstraintLayoutDemo() {
    val red = remember { mutableStateOf(true) }
    val green = remember { mutableStateOf(true) }
    val blue = remember { mutableStateOf(true) }
    val cyan = remember { mutableStateOf(true) }
    val magenta = remember { mutableStateOf(true) }

    ConstraintLayout {
        val (yellowBar, redBar, grayBox) = createRefs()
        val (redCheckbox, blueCheckbox, greenCheckbox, cyanCheckbox, magentaCheckbox) = createRefs()

        Box(
            modifier = Modifier
                .background(Color.Yellow)
                .height(30.dp)
                .constrainAs(yellowBar) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)

                    // fill max width available
                    width = Dimension.fillToConstraints
                }
        )

        Box(
            modifier = Modifier
                .background(Color.Red)
                .height(30.dp)
                .constrainAs(redBar) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)

                    // fill max width available
                    width = Dimension.fillToConstraints
                }
        )

        val endGuideline = createGuidelineFromEnd(offset = 20.dp)

        CardCheckBox(
            modifier = Modifier.constrainAs(redCheckbox) {
                top.linkTo(yellowBar.bottom)
                end.linkTo(endGuideline)
            }
        ) {
            CheckBoxWithLabel(state = red, label = stringResource(id = R.string.red), color = Color.Red)
        }

        CheckBoxWithLabel(
            modifier = Modifier.constrainAs(blueCheckbox) {
                end.linkTo(endGuideline)
            },
            state = blue,
            label = stringResource(id = R.string.blue),
            color = Color.Blue
        )

        CheckBoxWithLabel(
            modifier = Modifier.constrainAs(greenCheckbox) {
                end.linkTo(endGuideline)
            },
            state = green,
            label = stringResource(id = R.string.green),
            color = Color.Green
        )

        CheckBoxWithLabel(
            modifier = Modifier.constrainAs(cyanCheckbox) {
                end.linkTo(endGuideline)
            },
            state = cyan,
            label = stringResource(id = R.string.cyan),
            color = Color.Cyan
        )

        CheckBoxWithLabel(
            modifier = Modifier.constrainAs(magentaCheckbox) {
                end.linkTo(endGuideline)
                bottom.linkTo(redBar.bottom)
            },
            state = magenta,
            label = stringResource(id = R.string.magenta),
            color = Color.Magenta
        )

        // think of a needle with a thread going over all composables, and aligning them vertically
        createVerticalChain(
            redCheckbox,
            blueCheckbox,
            greenCheckbox,
            cyanCheckbox,
            magentaCheckbox,
            chainStyle = ChainStyle.Spread
        )

        // sets a barrier before the start of its elements
        val startBarrier = createStartBarrier(
            redCheckbox,
            blueCheckbox,
            greenCheckbox,
            cyanCheckbox,
            magentaCheckbox
        )

        Box(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .background(color = Color.DarkGray)
                .constrainAs(grayBox) {
                    bottom.linkTo(redBar.top)
                    start.linkTo(parent.start)
                    // reach startBarrier when snapping to the end
                    end.linkTo(startBarrier, margin = 20.dp)

                    // fill max width available
                    width = Dimension.fillToConstraints
                }
        )
    }
}

@Preview
@Composable
fun ConstraintLayoutDemoPreview() {

    ComposeTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
            ConstraintLayoutDemo()
        }
    }
}