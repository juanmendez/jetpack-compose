package com.jetpack.compose.ui.comps

import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import com.jetpack.compose.R
import com.jetpack.compose.ui.data.Post
import com.jetpack.compose.ui.data.PostAuthor
import com.jetpack.compose.ui.data.PostDescription
import java.util.Locale

@Composable
fun PostMetadata(post: Post, modifier: Modifier = Modifier) {
    val divider = "  •  "
    val tagDivider = "  "
    val text = buildAnnotatedString {
        append(post.description.date)
        append(divider)
        append(stringResource(R.string.read_time, post.description.readTimeMinutes))
        append(divider)
        post.tags.forEachIndexed { index, tag ->
            if (index != 0) {
                append(tagDivider)
            }
            append(" ${tag.uppercase(Locale.getDefault())} ")
        }
    }
    Text(
        text = text,
        modifier = modifier
    )
}

@Preview
@Composable
fun PostMetadataPreview() {
    Surface {
        PostMetadata(
            post = Post(
                1,
                "title",
                "subtitle",
                "https://google.com",
                description = PostDescription(author = PostAuthor("Juan"), date = "12/12/2022", readTimeMinutes = 10),
                imageId = R.drawable.post_1,
                imageThumbId = R.drawable.post_1_thumb,
                tags = setOf("Modularization", "Gradle")
            )
        )
    }
}