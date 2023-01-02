package com.jetpack.compose.ui.comps

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jetpack.compose.R
import com.jetpack.compose.ui.data.PostRepo
import com.jetpack.compose.ui.theme.JetNewsTheme

@Composable
fun Home() {
    val featured = remember { PostRepo.getFeaturedPost() }
    val posts = remember { PostRepo.getPosts() }

    JetNewsTheme {
        Scaffold(topBar = { AppBar() }) { innerPadding ->
            LazyColumn(contentPadding = innerPadding) {
                item {
                    Header(stringResource(id = R.string.top))
                }

                item {
                    FeaturedPost(post = featured, modifier = Modifier.padding(16.dp))
                }

                item {
                    Header(stringResource(id = R.string.popular))
                }

                items(posts) { post ->
                    PostItem(post = post)
                    Divider(startIndent = 72.dp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomePreview() {
    JetNewsTheme {
        Home()
    }
}

