package com.musicswipe.app.model

import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class UserPreferencesTest {

    private lateinit var userPreferences: UserPreferences

    @Before
    fun setUp() {
        userPreferences = UserPreferences()
    }

    @Test
    fun testUserPreferencesInitialization() {
        assertTrue(userPreferences.likedSongs.isEmpty())
        assertTrue(userPreferences.dislikedSongs.isEmpty())
        assertTrue(userPreferences.favoriteGenres.isEmpty())
    }

    @Test
    fun testAddLikedSong() {
        userPreferences.likedSongs.add("song-1")
        userPreferences.likedSongs.add("song-2")

        assertEquals(2, userPreferences.likedSongs.size)
        assertTrue(userPreferences.likedSongs.contains("song-1"))
        assertTrue(userPreferences.likedSongs.contains("song-2"))
    }

    @Test
    fun testAddDislikedSong() {
        userPreferences.dislikedSongs.add("song-3")

        assertEquals(1, userPreferences.dislikedSongs.size)
        assertTrue(userPreferences.dislikedSongs.contains("song-3"))
    }

    @Test
    fun testAddFavoriteGenre() {
        userPreferences.favoriteGenres.add("Rock")
        userPreferences.favoriteGenres.add("Pop")
        userPreferences.favoriteGenres.add("Jazz")

        assertEquals(3, userPreferences.favoriteGenres.size)
        assertTrue(userPreferences.favoriteGenres.contains("Rock"))
        assertTrue(userPreferences.favoriteGenres.contains("Pop"))
        assertTrue(userPreferences.favoriteGenres.contains("Jazz"))
    }

    @Test
    fun testRemoveLikedSong() {
        userPreferences.likedSongs.add("song-1")
        userPreferences.likedSongs.add("song-2")

        userPreferences.likedSongs.remove("song-1")

        assertEquals(1, userPreferences.likedSongs.size)
        assertFalse(userPreferences.likedSongs.contains("song-1"))
        assertTrue(userPreferences.likedSongs.contains("song-2"))
    }

    @Test
    fun testClearAllPreferences() {
        userPreferences.likedSongs.add("song-1")
        userPreferences.dislikedSongs.add("song-2")
        userPreferences.favoriteGenres.add("Rock")

        userPreferences.likedSongs.clear()
        userPreferences.dislikedSongs.clear()
        userPreferences.favoriteGenres.clear()

        assertTrue(userPreferences.likedSongs.isEmpty())
        assertTrue(userPreferences.dislikedSongs.isEmpty())
        assertTrue(userPreferences.favoriteGenres.isEmpty())
    }

    @Test
    fun testDuplicateLikedSongs() {
        userPreferences.likedSongs.add("song-1")
        userPreferences.likedSongs.add("song-1")

        assertEquals(2, userPreferences.likedSongs.size)
    }

    @Test
    fun testMultipleOperations() {
        // Add multiple songs
        userPreferences.likedSongs.addAll(listOf("song-1", "song-2", "song-3"))
        userPreferences.dislikedSongs.addAll(listOf("song-4", "song-5"))
        userPreferences.favoriteGenres.addAll(listOf("Rock", "Pop", "Electronic"))

        assertEquals(3, userPreferences.likedSongs.size)
        assertEquals(2, userPreferences.dislikedSongs.size)
        assertEquals(3, userPreferences.favoriteGenres.size)

        // Remove one liked song
        userPreferences.likedSongs.remove("song-2")

        assertEquals(2, userPreferences.likedSongs.size)
        assertEquals(2, userPreferences.dislikedSongs.size)
        assertEquals(3, userPreferences.favoriteGenres.size)
    }
}
