package com.jetpack.compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jetpack.compose.ui.theme.LayoutsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutsCodelabTheme {
                LayoutsCodelab(clickable = {
                    Toast.makeText(baseContext, "And the memory remains...", Toast.LENGTH_LONG).show()
                })
            }
        }
    }
}

@Composable
fun LayoutsCodelab(clickable: () -> Unit = {}) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Scrolling Memories")
                },
                actions = {
                    IconButton(onClick = clickable) {
                        Icon(Icons.Filled.Favorite, contentDescription = null)
                    }
                }
            )
        }
    ) {
        BodyContent()
    }

}

@Composable
fun BodyContent() {
    ScrollableList(PaddingValues(30.dp))
}

@Composable
fun ScrollableList(innerPadding: PaddingValues) {
    // We save the scrolling position with this state that can also
    // be used to programmatically scroll the list
    val scrollState = rememberScrollState()

    Column(Modifier.verticalScroll(scrollState)) {
        repeat(40) {
            Text("Item #$it", Modifier.padding(innerPadding))
        }
    }
}


@Preview
@Composable
fun LayoutsCodelabPreview() {
    LayoutsCodelabTheme {
        LayoutsCodelab()
    }
}
