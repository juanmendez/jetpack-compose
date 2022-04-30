package com.jetpack.compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
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
                    Toast.makeText(baseContext, "Pour some sugar on me!!!!", Toast.LENGTH_LONG).show()
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
                    Text(text = "Def Leppard")
                },
                actions = {
                    IconButton(onClick = clickable) {
                        Icon(Icons.Filled.Favorite, contentDescription = null)
                    }
                }
            )
        }
    ) { innerPadding ->
        BodyContent(innerPadding)
    }

}

@Composable
fun BodyContent(innerPadding: PaddingValues) {
    Column(modifier = Modifier.padding(innerPadding)) {
        Text(text = "Hysteria", modifier = Modifier.padding(vertical = 18.dp))
        Text(text = "Hysteria is the fourth studio album by English rock band Def Leppard, released on 3 August 1987 through Mercury Records. It is Def Leppard's best-selling album to date, selling over 20 million copies worldwide, including 12 million in the US, and spawning seven hit singles. The album charted at number one on both the Billboard 200 and the UK Albums Chart.")
    }
}


@Preview
@Composable
fun LayoutsCodelabPreview() {
    LayoutsCodelabTheme {
        LayoutsCodelab()
    }
}
