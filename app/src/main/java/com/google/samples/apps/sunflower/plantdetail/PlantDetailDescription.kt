package com.google.samples.apps.sunflower.plantdetail

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.samples.apps.sunflower.data.Plant
import com.google.samples.apps.sunflower.viewmodels.PlantDetailViewModel

@Composable
fun PlantDetailDescription(plantDetailViewModel: PlantDetailViewModel = viewModel() ) {
    // Observes values coming from the VM's LiveData<Plant> field
    val plant by plantDetailViewModel.plant.observeAsState()

    // If plant is not null, display the content
    plant?.let {
        PlantDetailContent(it)
    }

}

@Composable
fun PlantDetailContent(plant: Plant) {
    PlantName(plant.name)
}

@Preview
@Composable
private fun PlantDetailContentPreview() {
    val plant = Plant("id", "Apple", "description", 3, 30, "")
    MaterialTheme {
        PlantDetailContent(plant)
    }
}


