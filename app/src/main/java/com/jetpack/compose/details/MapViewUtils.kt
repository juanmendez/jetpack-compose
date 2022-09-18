/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jetpack.compose.details

import android.os.Bundle
import androidx.annotation.FloatRange
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import com.jetpack.compose.R
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import com.google.android.libraries.maps.GoogleMap
import com.google.android.libraries.maps.MapView

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver


/**
 * Remembers a MapView and gives it the lifecycle of the current LifecycleOwner
 */
@Composable
fun rememberMapViewWithLifecycle(): MapView {
    val context = LocalContext.current

    /**
     * As the MapView is a View and not a composable, we want it to follow the lifecycle of the Activity where it's used
     * instead of the lifecycle of the Composition. That means we need to create a LifecycleEventObserver to listen for
     * lifecycle events and call the right methods on the MapView. Then, we need to add this observer to the current activity's lifecycle.
     */

    return remember {
        MapView(context).apply {
            id = R.id.map
        }
    }.also { mapView ->
        val lifecycle = LocalLifecycleOwner.current.lifecycle
        DisposableEffect(key1 = lifecycle, key2 = mapView) {
            // Make MapView follow the current lifecycle attached when added to the composition
            val lifecycleObserver = getMapLifecycleObserver(mapView)
            lifecycle.addObserver(lifecycleObserver)

            onDispose {
                lifecycle.removeObserver(lifecycleObserver)
            }
        }
    }
}

// details/MapViewUtils.kt file

private fun getMapLifecycleObserver(mapView: MapView): LifecycleEventObserver =
    LifecycleEventObserver { _, event ->
        when (event) {
            Lifecycle.Event.ON_CREATE -> mapView.onCreate(Bundle())
            Lifecycle.Event.ON_START -> mapView.onStart()
            Lifecycle.Event.ON_RESUME -> mapView.onResume()
            Lifecycle.Event.ON_PAUSE -> mapView.onPause()
            Lifecycle.Event.ON_STOP -> mapView.onStop()
            Lifecycle.Event.ON_DESTROY -> mapView.onDestroy()
            else -> throw IllegalStateException()
        }
    }



fun GoogleMap.setZoom(
    @FloatRange(from = MinZoom.toDouble(), to = MaxZoom.toDouble()) zoom: Float
) {
    resetMinMaxZoomPreference()
    setMinZoomPreference(zoom)
    setMaxZoomPreference(zoom)
}
