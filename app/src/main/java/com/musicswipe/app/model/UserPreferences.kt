package com.musicswipe.app.model

data class UserPreferences(
    val likedSongs: MutableList<String> = mutableListOf(),
    val dislikedSongs: MutableList<String> = mutableListOf(),
    val favoriteGenres: MutableList<String> = mutableListOf()
)
