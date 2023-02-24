package com.google.samples.apps.sunflower.plantdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.google.samples.apps.sunflower.R

/*
<TextView
    android:id="@+id/plant_watering_header"
    ...
    android:layout_marginStart="@dimen/margin_small"
    android:layout_marginTop="@dimen/margin_normal"
    android:layout_marginEnd="@dimen/margin_small"
    android:gravity="center_horizontal"
    android:text="@string/watering_needs_prefix"
    android:textColor="?attr/colorAccent"
    android:textStyle="bold"
    ... />

<TextView
    android:id="@+id/plant_watering"
    ...
    android:layout_marginStart="@dimen/margin_small"
    android:layout_marginEnd="@dimen/margin_small"
    android:gravity="center_horizontal"
    app:wateringText="@{viewModel.plant.wateringInterval}"
    .../>
 */

// The tutorial didn't include modifier argument, but this is a rule to always welcome a modifier or else provide one.
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PlantWatering(wateringInterval: Int, modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxWidth()) {
        // Same modifier used by both Texts
        val centerWithPaddingModifier = modifier
            .padding(horizontal = dimensionResource(R.dimen.margin_small))
            .align(Alignment.CenterHorizontally)

        val normalPadding = dimensionResource(R.dimen.margin_normal)

        Text(
            text = stringResource(R.string.watering_needs_prefix),
            color = MaterialTheme.colors.primaryVariant,
            fontWeight = FontWeight.Bold,
            modifier = centerWithPaddingModifier.padding(top = normalPadding)
        )

        Text(
            text = pluralStringResource(
                R.plurals.watering_needs_suffix, wateringInterval, wateringInterval
            ),
            modifier = centerWithPaddingModifier.padding(bottom = normalPadding)
        )
    }
}

@Preview
@Composable
private fun PlantWateringPreview() {
    MaterialTheme {
        PlantWatering(7)
    }
}
