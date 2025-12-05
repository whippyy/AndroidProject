package com.musicswipe.app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.musicswipe.app.R
import com.musicswipe.app.model.Song
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class SongCardAdapterTest {

    private lateinit var context: Context
    private lateinit var adapter: SongCardAdapter
    private lateinit var songs: List<Song>

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
        songs = createSampleSongs()
        adapter = SongCardAdapter(songs)
    }

    @Test
    fun testAdapterInitialization() {
        assertEquals(songs.size, adapter.itemCount)
    }

    @Test
    fun testAdapterItemCount() {
        val testSongs = createSampleSongs(5)
        adapter.updateSongs(testSongs)

        assertEquals(5, adapter.itemCount)
    }

    @Test
    fun testAdapterEmptyList() {
        adapter.updateSongs(emptyList())

        assertEquals(0, adapter.itemCount)
    }

    @Test
    fun testUpdateSongs() {
        val newSongs = createSampleSongs(3)
        adapter.updateSongs(newSongs)

        assertEquals(3, adapter.itemCount)
    }

    @Test
    fun testAdapterWithSingleSong() {
        val singleSong = listOf(Song(
            id = "1",
            title = "Single Song",
            artist = "Single Artist",
            album = "Single Album",
            albumArtUrl = "url",
            previewUrl = "preview",
            duration = 200,
            genre = "Pop",
            releaseYear = 2023
        ))

        adapter.updateSongs(singleSong)

        assertEquals(1, adapter.itemCount)
    }

    @Test
    fun testAdapterWithMultipleSongs() {
        val multipleSongs = createSampleSongs(10)
        adapter.updateSongs(multipleSongs)

        assertEquals(10, adapter.itemCount)
    }

    @Test
    fun testAdapterUpdateWithDifferentSizes() {
        adapter.updateSongs(createSampleSongs(5))
        assertEquals(5, adapter.itemCount)

        adapter.updateSongs(createSampleSongs(3))
        assertEquals(3, adapter.itemCount)

        adapter.updateSongs(createSampleSongs(8))
        assertEquals(8, adapter.itemCount)
    }

    @Test
    fun testCreateViewHolder() {
        val parent = createMockViewGroup()
        val viewHolder = adapter.onCreateViewHolder(parent, 0)

        assertNotNull(viewHolder)
    }

    private fun createSampleSongs(count: Int = 10): List<Song> {
        val songs = mutableListOf<Song>()
        for (i in 1..count) {
            songs.add(Song(
                id = "song-$i",
                title = "Song $i",
                artist = "Artist $i",
                album = "Album $i",
                albumArtUrl = "http://example.com/image$i.jpg",
                previewUrl = "http://example.com/preview$i.mp3",
                duration = 200 + i,
                genre = if (i % 2 == 0) "Pop" else "Rock",
                releaseYear = 2020 + i
            ))
        }
        return songs
    }

    private fun createMockViewGroup(): android.view.ViewGroup {
        return object : android.view.ViewGroup(context) {
            override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {}
        }
    }
}
