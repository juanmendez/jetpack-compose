/*
 * Copyright 2022 The Android Open Source Project
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
package com.jetpack.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen(viewModel: MainViewModel = viewModel(), modifier: Modifier = Modifier) {
    Column {
        /**
         * This is a long way
         * val count: MutableState<Int> = remember { mutableStateOf(0) }
         */

        /**
         * This way it saves the data but if the Activity has to reset due to settings it is then restarted
         * var count by remember { mutableStateOf(0) }
         */

        /**
         * Even if the activity is reset due to configurations such as rotation this
         * composable is retained
         * var count by rememberSaveable { mutableStateOf(0) }
         */

        val count by viewModel.countData.observeAsState(initial = 0)
        val lifecycleState by viewModel.currentStateData.observeAsState()

        Text("Current state $lifecycleState")
        Text("You've had $count glasses.")
        Button(onClick = { viewModel.incrementCount() }, Modifier.padding(top = 8.dp)) {
            Text("Add one")
        }
    }

}
