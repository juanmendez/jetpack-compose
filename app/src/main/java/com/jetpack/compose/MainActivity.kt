package com.jetpack.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jetpack.compose.ui.theme.ComposeTheme

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
fun MyApp(names: List<String> = listOf("World", "Compose")) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        for (name in names) {
            Greeting(name = name)
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
    Surface(color = MaterialTheme.colors.primary, modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {
        // To add multiple modifiers to an element, you simply chain them.
        Column(Modifier.fillMaxWidth().padding(24.dp)) {
            Text("Hello")
            Text(name)
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    MyApp()
}