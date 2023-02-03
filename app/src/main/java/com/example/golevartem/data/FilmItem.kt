package com.example.golevartem.data

data class FilmItem(
    val name: String,
    val posterUrl: String,
    val posterUrlPreview: String,
    val year: Int,
    val description: String,
    val genres: List<String>,
    val countries: List<String>
)
