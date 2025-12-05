package com.musicswipe.app.data

import com.musicswipe.app.model.Song
import org.junit.Test
import org.junit.Assert.*

class SampleMusicDataTest {

    @Test
    fun testGetSampleSongsNotEmpty() {
        val songs = SampleMusicData.getSampleSongs()
        assertNotNull(songs)
        assertFalse(songs.isEmpty())
    }

    @Test
    fun testGetSampleSongsCount() {
        val songs = SampleMusicData.getSampleSongs()
        assertEquals(10, songs.size)
    }

    @Test
    fun testSampleSongsHaveValidData() {
        val songs = SampleMusicData.getSampleSongs()

        for (song in songs) {
            assertNotNull(song.id)
            assertNotNull(song.title)
            assertNotNull(song.artist)
            assertNotNull(song.album)
            assertNotNull(song.albumArtUrl)
            assertNotNull(song.previewUrl)
            assertTrue(song.duration > 0)
            assertNotNull(song.genre)
            assertTrue(song.releaseYear > 0)
        }
    }

    @Test
    fun testSampleSongsUniqueIds() {
        val songs = SampleMusicData.getSampleSongs()
        val ids = songs.map { it.id }

        assertEquals(songs.size, ids.distinct().size)
    }

    @Test
    fun testSampleSongsHaveGenres() {
        val songs = SampleMusicData.getSampleSongs()

        assertTrue(songs.any { it.genre == "Pop" })
        assertTrue(songs.any { it.genre == "Rock" })
        assertTrue(songs.any { it.genre == "Hip Hop" })
    }

    @Test
    fun testSampleSongsRealisticDuration() {
        val songs = SampleMusicData.getSampleSongs()

        for (song in songs) {
            assertTrue(song.duration in 100..600)
        }
    }

    @Test
    fun testSampleSongsRealisticReleaseYear() {
        val songs = SampleMusicData.getSampleSongs()

        for (song in songs) {
            assertTrue(song.releaseYear in 1970..2025)
        }
    }

    @Test
    fun testSampleSongsConsistency() {
        val songs1 = SampleMusicData.getSampleSongs()
        val songs2 = SampleMusicData.getSampleSongs()

        assertEquals(songs1, songs2)
    }

    @Test
    fun testSampleSongsUrls() {
        val songs = SampleMusicData.getSampleSongs()

        for (song in songs) {
            assertTrue(song.albumArtUrl.startsWith("http"))
            assertNotNull(song.previewUrl)
        }
    }

    @Test
    fun testFirstSongIsBlindingLights() {
        val songs = SampleMusicData.getSampleSongs()
        val firstSong = songs[0]

        assertEquals("1", firstSong.id)
        assertEquals("Blinding Lights", firstSong.title)
        assertEquals("The Weeknd", firstSong.artist)
    }

    @Test
    fun testLastSongIsUptownFunk() {
        val songs = SampleMusicData.getSampleSongs()
        val lastSong = songs[songs.size - 1]

        assertEquals("10", lastSong.id)
        assertEquals("Uptown Funk", lastSong.title)
        assertEquals("Mark Ronson ft. Bruno Mars", lastSong.artist)
    }
}
