package com.jetpack.compose.ui.elements

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import java.lang.Integer.max

private fun columMeasurePolicy(spaceBetween: Dp = 0.dp): MeasurePolicy = MeasurePolicy { measurables, constraints ->
    // Don't constrain child views further, measure them with given constraints
    // List of measured children
    val placeables = measurables.map { measurable ->
        // Measure each children
        measurable.measure(constraints)
    }

    var maxHeight = 0
    var maxWidth = 0

    val lastIndex = placeables.size - 1

    placeables.forEachIndexed { index, placeable ->
        maxHeight += if (index < lastIndex) {
            placeable.height + spaceBetween.roundToPx()
        } else {
            placeable.height
        }
        maxWidth = max(placeable.width, maxWidth)
    }

    // Set the size of the layout as big as it needs
    layout(maxWidth, maxHeight) {
        // Track the y co-ord we have placed children up to
        var yPosition = 0

        // Place children in the parent layout
        placeables.forEachIndexed { index, placeable ->
            // Position item on the screen
            placeable.placeRelative(x = 0, y = yPosition)

            // Record the y co-ord placed up to
            yPosition += if (index < lastIndex) {
                placeable.height + spaceBetween.roundToPx()
            } else {
                placeable.height
            }
        }

    }
}

@Composable
fun ApplyMeasurePolicy(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Layout(
        modifier = modifier,
        content = content,
        measurePolicy = columMeasurePolicy(10.dp)
    )
}

@Preview
@Composable
fun ApplyMeasurePolicyPreview() {
    ApplyMeasurePolicy(
        modifier = Modifier
            .padding(8.dp)
            .padding(10.dp),
        content = {
            Text("MyBasicColumn")
            Text("places items")
            Text("vertically.")
            Text(":)")
            Text("We've done it by hand!")
        }
    )
}