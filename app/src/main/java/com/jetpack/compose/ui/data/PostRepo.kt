package com.jetpack.compose.ui.data

/**
 * A fake repo returning sample data
 */
object PostRepo {
    fun getPosts(): List<Post> = posts
    fun getFeaturedPost(): Post = posts.random()
}