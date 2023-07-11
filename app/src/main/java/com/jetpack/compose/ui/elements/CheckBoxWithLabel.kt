package com.jetpack.compose.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.jetpack.compose.constants.StringConstants

@Composable
fun CheckBoxWithLabel(
    modifier: Modifier = Modifier,
    label: String = StringConstants.empty,
    state: MutableState<Boolean>,
    color: Color = Color.White
) {
    ConstraintLayout(
        modifier = modifier
            .clickable {
                state.value = !state.value
            }
            .background(
                color = if (state.value) {
                    color
                } else {
                    Color.White
                }
            )
    ) {
        val (checkbox, text) = createRefs()

        Checkbox(
            checked = state.value,
            onCheckedChange = {
                state.value = it
            },
            modifier = Modifier.constrainAs(checkbox) {
            }
        )
        Text(
            text = label,
            modifier = Modifier.constrainAs(text) {
                start.linkTo(checkbox.end)
                end.linkTo(parent.end, margin = 8.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
        )
    }
}

@Preview
@Composable
fun CheckBoxWithLabelPreview() {
    CheckBoxWithLabel(label = "Hello", state = remember { mutableStateOf(true) }, color = Color.Cyan)
}