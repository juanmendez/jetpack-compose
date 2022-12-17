package com.jetpack.compose.ui.data

import com.jetpack.compose.R

/**
 * Sample Data
 */

private val pietro = PostAuthor("Pietro Maggi", "https://medium.com/@pmaggi")
private val manuel = PostAuthor("Manuel Vivo", "https://medium.com/@manuelvicnt")
private val florina = PostAuthor("Florina Muntenescu", "https://medium.com/@florina.muntenescu")
private val jose = PostAuthor("Jose Alcérreca", "https://medium.com/@JoseAlcerreca")

val post1 = Post(
    id = 1L,
    title = "A Little Thing about Android Module Paths",
    subtitle = "How to configure your module paths, instead of using Gradle’s default.",
    url = "https://medium.com/androiddevelopers/gradle-path-configuration-dc523f0ed25c",
    description = PostDescription(
        author = pietro,
        date = "August 02",
        readTimeMinutes = 1
    ),
    imageId = R.drawable.post_1,
    imageThumbId = R.drawable.post_1_thumb,
    tags = setOf("Modularization", "Gradle")
)

val post2 = Post(
    id = 2L,
    title = "Dagger in Kotlin: Gotchas and Optimizations",
    subtitle = "Use Dagger in Kotlin! This article includes best practices to optimize your build time and gotchas you might encounter.",
    url = "https://medium.com/androiddevelopers/dagger-in-kotlin-gotchas-and-optimizations-7446d8dfd7dc",
    description = PostDescription(
        author = manuel,
        date = "July 30",
        readTimeMinutes = 3
    ),
    imageId = R.drawable.post_2,
    imageThumbId = R.drawable.post_2_thumb,
    tags = setOf("Dagger", "Kotlin")
)

val post3 = Post(
    id = 3L,
    title = "From Java Programming Language to Kotlin — the idiomatic way",
    subtitle = "Learn how to get started converting Java Programming Language code to Kotlin, making it more idiomatic and avoid common pitfalls, by…",
    url = "https://medium.com/androiddevelopers/from-java-programming-language-to-kotlin-the-idiomatic-way-ac552dcc1741",
    description = PostDescription(
        author = florina,
        date = "July 09",
        readTimeMinutes = 1
    ),
    imageId = R.drawable.post_3,
    imageThumbId = R.drawable.post_3_thumb,
    tags = setOf("Kotlin")
)

val post4 = Post(
    id = 4L,
    title = "Locale changes and the AndroidViewModel antipattern",
    subtitle = "TL;DR: Expose resource IDs from ViewModels to avoid showing obsolete data.",
    url = "https://medium.com/androiddevelopers/locale-changes-and-the-androidviewmodel-antipattern-84eb677660d9",
    description = PostDescription(
        author = jose,
        date = "April 02",
        readTimeMinutes = 1
    ),
    imageId = R.drawable.post_4,
    imageThumbId = R.drawable.post_4_thumb,
    tags = setOf("ViewModel", "Locale")
)

val post5 = Post(
    id = 5L,
    title = "Collections and sequences in Kotlin",
    subtitle = "Working with collections is a common task and the Kotlin Standard Library offers many great utility functions. It also offers two ways of…",
    url = "https://medium.com/androiddevelopers/collections-and-sequences-in-kotlin-55db18283aca",
    description = PostDescription(
        author = florina,
        date = "July 24",
        readTimeMinutes = 4
    ),
    imageId = R.drawable.post_5,
    imageThumbId = R.drawable.post_5_thumb,
    tags = setOf("Kotlin", "Collections", "Sequences")
)

val posts = listOf(
    post1,
    post2,
    post3,
    post4,
    post5,
    post1.copy(id = 6L),
    post2.copy(id = 7L),
    post3.copy(id = 8L),
    post4.copy(id = 9L),
    post5.copy(id = 10L)
)