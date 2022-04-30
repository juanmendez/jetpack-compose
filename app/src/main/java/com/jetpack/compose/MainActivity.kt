package com.jetpack.compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jetpack.compose.ui.theme.LayoutsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LayoutsCodelabTheme {
                PhotographerCard(clickable = {
                    Toast.makeText(baseContext, "You clicked on me", Toast.LENGTH_LONG).show()
                })
            }
        }
    }
}

/**
 * Most composables provide a modifier attribute.
 * So when making your own to follow the pattern add one and give it a default.
 */
@Composable
fun PhotographerCard(modifier: Modifier = Modifier, clickable: () -> Unit = {}) {
    /**
     * Order of modifiers matter
     * In the code, notice how you can chain multiple modifiers one after the other by using
     * the factory-extension functions.
     *
     * The modifier design makes this behavior explicit and predictable,
     * and gives you more control to achieve the exact behavior you want.
     */
Row(
    modifier
        .clickable(onClick = clickable)
        .padding(16.dp)
) {
        Surface(
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            color = MaterialTheme.colors.primary
        ) {
            // Image goes here
        }

        Column(
            modifier = Modifier
                .padding(start = 10.dp)
                .align(Alignment.CenterVertically)

        ) {
            Text("Alfred Sisley", fontWeight = FontWeight.Bold)
            // LocalContentAlpha is defining opacity level of its children
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text("3 minutes ago", style = MaterialTheme.typography.body2)
            }
        }
    }
}

@Preview
@Composable
fun PhotographerCardPreview() {
    LayoutsCodelabTheme {
        PhotographerCard()
    }
}
