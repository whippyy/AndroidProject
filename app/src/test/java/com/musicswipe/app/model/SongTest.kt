package com.musicswipe.app.model

import org.junit.Test
import org.junit.Assert.*

class SongTest {

    @Test
    fun testSongCreation() {
        val song = Song(
            id = "test-1",
            title = "Test Song",
            artist = "Test Artist",
            album = "Test Album",
            albumArtUrl = "http://example.com/image.jpg",
            previewUrl = "http://example.com/preview.mp3",
            duration = 180,
            genre = "Rock",
            releaseYear = 2023
        )

        assertEquals("test-1", song.id)
        assertEquals("Test Song", song.title)
        assertEquals("Test Artist", song.artist)
        assertEquals("Test Album", song.album)
        assertEquals("http://example.com/image.jpg", song.albumArtUrl)
        assertEquals("http://example.com/preview.mp3", song.previewUrl)
        assertEquals(180, song.duration)
        assertEquals("Rock", song.genre)
        assertEquals(2023, song.releaseYear)
    }

    @Test
    fun testSongEquality() {
        val song1 = Song(
            id = "1",
            title = "Song A",
            artist = "Artist A",
            album = "Album A",
            albumArtUrl = "url1",
            previewUrl = "preview1",
            duration = 200,
            genre = "Pop",
            releaseYear = 2020
        )

        val song2 = Song(
            id = "1",
            title = "Song A",
            artist = "Artist A",
            album = "Album A",
            albumArtUrl = "url1",
            previewUrl = "preview1",
            duration = 200,
            genre = "Pop",
            releaseYear = 2020
        )

        assertEquals(song1, song2)
    }

    @Test
    fun testSongInequality() {
        val song1 = Song(
            id = "1",
            title = "Song A",
            artist = "Artist A",
            album = "Album A",
            albumArtUrl = "url1",
            previewUrl = "preview1",
            duration = 200,
            genre = "Pop",
            releaseYear = 2020
        )

        val song2 = Song(
            id = "2",
            title = "Song B",
            artist = "Artist B",
            album = "Album B",
            albumArtUrl = "url2",
            previewUrl = "preview2",
            duration = 220,
            genre = "Rock",
            releaseYear = 2021
        )

        assertNotEquals(song1, song2)
    }

    @Test
    fun testSongWithDifferentDuration() {
        val shortSong = Song(
            id = "1",
            title = "Short",
            artist = "Artist",
            album = "Album",
            albumArtUrl = "url",
            previewUrl = "preview",
            duration = 60,
            genre = "Pop",
            releaseYear = 2020
        )

        val longSong = Song(
            id = "2",
            title = "Long",
            artist = "Artist",
            album = "Album",
            albumArtUrl = "url",
            previewUrl = "preview",
            duration = 300,
            genre = "Pop",
            releaseYear = 2020
        )

        assertTrue(shortSong.duration < longSong.duration)
    }
}
