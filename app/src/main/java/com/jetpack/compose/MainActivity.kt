package com.jetpack.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
    // TODO: This state should be hoisted
    var shouldShowOnboarding by remember { mutableStateOf(true) }

    if (shouldShowOnboarding) {
        OnboardingScreen(onContinueClicked = {
            shouldShowOnboarding = !shouldShowOnboarding
        })
    } else {
        Greetings(onContinueClicked = {
            shouldShowOnboarding = !shouldShowOnboarding
        })
    }
}

@Composable
private fun Greetings(
    names:
    List<String> = listOf(stringResource(id = R.string.world), stringResource(id = R.string.compose)),
    onContinueClicked: () -> Unit
) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Button(
            modifier = Modifier
                .padding(vertical = 24.dp)
                .align(Alignment.CenterHorizontally),
            onClick = onContinueClicked
        ) {
            Text(stringResource(id = R.string.flip))
        }
        for (name in names) {
            Greeting(name = name)
        }
    }
}

@Composable
fun OnboardingScreen(onContinueClicked: () -> Unit) {

    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(stringResource(id = R.string.welcome))
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = onContinueClicked
            ) {
                Text(stringResource(id = R.string.flip))
            }
        }
    }
}

/**
 * A Compose app is made up of composable functions - just regular functions marked with @Composable, which can call other composable functions.
 * A function is all you need to create a new UI component. The annotation tells Compose to add special support to the function for updating and
 * maintaining your UI over time. Compose lets you structure your code into small chunks. Composable functions are often referred to as "composables"
 * for short.
 */
@Composable
fun Greeting(name: String) {
    // `remember` is used to guard against recomposition, so the state is not reset.
    // The composable function will automatically be "subscribed" to the state. If the state changes, composables
    // that read these fields will be recomposed to display the updates.
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(text = stringResource(id = R.string.hello))
                Text(text = name)
            }
            OutlinedButton(
                onClick = {
                    expanded.value = !expanded.value
                }
            ) {
                val text = if (expanded.value) {
                    stringResource(id = R.string.show_less)
                } else {
                    stringResource(id = R.string.show_more)
                }

                Text(text)
            }
        }
    }

}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    MyApp()
}