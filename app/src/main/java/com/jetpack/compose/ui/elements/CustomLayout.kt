package com.jetpack.compose.ui.elements

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.jetpack.compose.ui.theme.ComposeTheme
import java.lang.Integer.max

fun Modifier.firstBaselineToTop(
    totalHeight: Dp
) = layout { measurable, constraints ->
    // Measure the composable
    val placeable = measurable.measure(constraints)

    // check the composable has a first baseline
    val firstBaseline = placeable[FirstBaseline]
    check(firstBaseline != AlignmentLine.Unspecified)

    val placeableY = max(totalHeight.roundToPx() - firstBaseline, 0)
    val width = placeable.width
    val height = placeable.height + placeableY

    layout(width, height) {
        placeable.placeRelative(0, placeableY)
    }
}

fun Modifier.paddingAll(
    padding: Dp
) = layout { measurable, constraints ->
    // Measure the composable
    val placeable = measurable.measure(constraints)

    // check the composable has a first baseline
    check(placeable[FirstBaseline] != AlignmentLine.Unspecified)

    val paddingInPixels = padding.roundToPx()
    val width = placeable.width + (paddingInPixels * 2)
    val height = placeable.height + (paddingInPixels * 2)

    layout(width, height) {
        placeable.placeRelative(paddingInPixels, paddingInPixels)
    }
}

fun Modifier.paddingMe(
    horizontal: Dp = 0.dp,
    vertical: Dp = 0.dp,
) = layout { measurable, constraints ->
    // Measure the composable
    val placeable = measurable.measure(constraints)

    // check the composable has a first baseline
    check(placeable[FirstBaseline] != AlignmentLine.Unspecified)

    val horizontalPixels = horizontal.roundToPx()
    val verticalPixels = vertical.roundToPx()
    val width = placeable.width + (horizontalPixels * 2)
    val height = placeable.height + (verticalPixels * 2)

    layout(width, height) {
        placeable.placeRelative(horizontalPixels, verticalPixels)
    }
}


@Composable
fun CustomLayout(
    modifier: Modifier = Modifier,
) {
    ComposeTheme {
        Text("Hi there", Modifier.paddingMe(32.dp, 10.dp))
    }
}

@Preview
@Composable
fun CustomLayoutPreview() {
    CustomLayout()
}