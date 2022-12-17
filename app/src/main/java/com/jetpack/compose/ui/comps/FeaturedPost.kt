package com.jetpack.compose.ui.comps

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jetpack.compose.ui.data.Post
import com.jetpack.compose.ui.data.PostRepo
import com.jetpack.compose.ui.theme.JetNewsTheme

@Composable
fun FeaturedPost(post: Post, modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .clickable { }) {
            Image(
                painter = painterResource(post.imageId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .heightIn(min = 180.dp)
                    .fillMaxWidth()
            )

            Spacer(Modifier.height(180.dp))

            val padding = Modifier.padding(horizontal = 16.dp)

            Text(
                text = post.title,
                modifier = padding
            )

            Text(
                text = post.description.author.name,
                modifier = padding
            )

            PostMetadata(post, padding)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview
@Composable
fun FeaturePostPreview() {
    val post = remember { PostRepo.getFeaturedPost() }
    JetNewsTheme(darkTheme = true) {
        FeaturedPost(post = post)
    }
}