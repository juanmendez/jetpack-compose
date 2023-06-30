package com.jetpack.compose.ui.containers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jetpack.compose.R
import com.jetpack.compose.ui.elements.CheckBoxWithLabel

@Composable
fun ColumnDemo(
    modifier: Modifier = Modifier,
) {
    val red = remember { mutableStateOf(true) }
    val green = remember { mutableStateOf(true) }
    val blue = remember { mutableStateOf(true) }
    val cyan = remember { mutableStateOf(true) }
    val magenta = remember { mutableStateOf(true) }

    Column() {
        Box(
            modifier = modifier
                .background(Color.Yellow)
                .fillMaxWidth()
                .height(30.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.0f),
            verticalAlignment = Alignment.Bottom
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .weight(1.0f)
                    .background(color = Color.DarkGray)
            )

            // Column's width is wrap_content by default
            Column(
                modifier = modifier
                    .fillMaxHeight()
                    .padding(20.dp),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.End
            ) {
                CheckBoxWithLabel(state = red, label = stringResource(id = R.string.red), color = Color.Red)
                CheckBoxWithLabel(state = green, label = stringResource(id = R.string.green), color = Color.Green)
                CheckBoxWithLabel(state = blue, label = stringResource(id = R.string.blue), color = Color.Blue)
                CheckBoxWithLabel(state = cyan, label = stringResource(id = R.string.cyan), color = Color.Cyan)
                CheckBoxWithLabel(state = magenta, label = stringResource(id = R.string.magenta), color = Color.Magenta)
            }
        }
        Box(
            modifier = modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(30.dp)
        )
    }
}

@Preview
@Composable
fun ColumnDemoPreview() {
    ColumnDemo()
}