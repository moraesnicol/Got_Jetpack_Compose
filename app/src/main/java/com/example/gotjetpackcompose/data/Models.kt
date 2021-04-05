package com.example.gotjetpackcompose.data

data class Series (
    val title: String,
    val episodes: List<Episode>
)

data class Episode (
    val title: String,
    val imdbId: String,
     val posterUrl: String? = null
)

data class Poster (
    val url: String

)