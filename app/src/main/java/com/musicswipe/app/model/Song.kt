package com.musicswipe.app.model

data class Song(
    val id: String,
    val title: String,
    val artist: String,
    val album: String,
    val albumArtUrl: String,
    val previewUrl: String,
    val duration: Int, // in seconds
    val genre: String,
    val releaseYear: Int
)
