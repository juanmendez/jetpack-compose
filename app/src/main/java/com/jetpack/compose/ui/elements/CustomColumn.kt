package com.jetpack.compose.ui.elements

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.lang.Integer.max

@Composable
fun CustomColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        // Don't constrain child views further, measure them with given constraints
        // List of measured children
        val placeables = measurables.map { measurable ->
            // Measure each children
            measurable.measure(constraints)
        }

        var maxHeight = 0
        var maxWidth = 0

        placeables.forEach { placeable ->
            maxHeight += placeable.height
            maxWidth = max(placeable.width, maxWidth)
        }

        // Set the size of the layout as big as it needs
        layout(maxWidth, maxHeight) {
            // Track the y co-ord we have placed children up to
            var yPosition = 0

            // Place children in the parent layout
            placeables.forEach { placeable ->
                // Position item on the screen
                placeable.placeRelative(x = 0, y = yPosition)

                // Record the y co-ord placed up to
                yPosition += placeable.height
            }
        }
    }
}

@Preview
@Composable
fun CustomColumnPreview() {
    CustomColumn(
        modifier = Modifier.padding(8.dp),
        content = {
            Text("MyBasicColumn")
            Text("places items")
            Text("vertically.")
            Text(":)")
            Text("We've done it by hand!")
        }
    )
}