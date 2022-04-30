package com.jetpack.compose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.jetpack.compose.ui.theme.BasicsCodelabTheme


/**
 * In my case I rename code hint to refresh for control + r, I can now update previous state quicker :)
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * You use setContent to define your layout, but instead of using an XML file as you'd do in the traditional View system,
         * you call Composable functions within it.
         */
        setContent {
            // right click, refactor, function to scope, and apply MainActivity.kt
            // then name your method `MyApp`, and it will generate MyApp function below
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    // rememberSaveable ensures to store data in a save instance state mechanism
    // when we rotate the device, the value is retained allowing to go to the same expected screen.
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    BasicsCodelabTheme {
        if (shouldShowOnboarding) {
            OnboardingScreen(onContinueClicked = {
                shouldShowOnboarding = !shouldShowOnboarding
            })
        } else {
            CardListView()
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    MyApp()
}