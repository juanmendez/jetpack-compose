/*
 * Copyright 2021 The Android Open Source Project
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

package com.jetpack.compose.rally

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.MainTestClock
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.unit.dp
import androidx.test.filters.SdkSuppress
import com.jetpack.compose.rally.ui.components.AnimatedCircle
import com.jetpack.compose.rally.ui.theme.RallyTheme
import org.junit.Rule
import org.junit.Test

/**
 * Test to showcase [MainTestClock] present in [ComposeTestRule]. It allows for animation
 * testing at specific points in time.
 *
 * For assertions, a simple screenshot testing framework is used. It requires SDK 26+ and to
 * be run on a device with 420dpi, as that the density used to generate the golden images
 * present in androidTest/assets. It runs bitmap comparisons on device.
 *
 * Note that different systems can produce slightly different screenshots making the test fail.
 */
@ExperimentalTestApi
@SdkSuppress(minSdkVersion = Build.VERSION_CODES.O)
class AnimatingCircleTests
