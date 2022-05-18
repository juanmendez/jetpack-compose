package com.jetpack.compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.jetpack.compose.ui.theme.LayoutsCodelabTheme
import kotlinx.coroutines.launch

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
    ScrollableList()
}

@Composable
fun ScrollableList() {
    val listSize = 100
    // We save the scrolling position with this state
    val scrollState = rememberLazyListState()

    // We save the coroutine scope where our animated scroll will be executed
    val coroutineScope = rememberCoroutineScope()

    Column {
        Button(onClick = {
            coroutineScope.launch {
                // 0 is the first item index
                scrollState.animateScrollToItem(0)
            }
        }, Modifier.fillMaxWidth()) {
            Text("Scroll to the top")
        }
        LazyColumn(state = scrollState, modifier = Modifier
            .weight(1f, true)
            .fillMaxWidth()) {
            items(listSize) {
                ImageListItem(it)
            }
        }

        Button(onClick = {
            coroutineScope.launch {
                // listSize - 1 is the last index of the list
                scrollState.animateScrollToItem(listSize - 1)
            }
        }, Modifier.fillMaxWidth()) {
            Text("Scroll to the end")
        }
    }
}

@Composable
fun ImageListItem(index: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {

        Image(
            painter = rememberAsyncImagePainter(
                model = "https://developer.android.com/images/brand/Android_Robot.png"
            ),
            contentDescription = "Android Logo",
            modifier = Modifier.size(50.dp)
        )
        Spacer(Modifier.width(10.dp))
        Text("Item #$index", style = MaterialTheme.typography.subtitle1)
    }
}


@Preview
@Composable
fun LayoutsCodelabPreview() {
    LayoutsCodelabTheme {
        LayoutsCodelab()
    }
}
