package com.musicswipe.app

import android.os.Bundle
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import com.musicswipe.app.adapter.SongCardAdapter
import com.musicswipe.app.data.SampleMusicData
import com.musicswipe.app.databinding.ActivityMainBinding
import com.musicswipe.app.model.Song
import com.musicswipe.app.model.SwipeDirection
import com.yuyakaido.android.cardstackview.*

class MainActivity : AppCompatActivity(), CardStackListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var cardStackLayoutManager: CardStackLayoutManager
    private lateinit var adapter: SongCardAdapter
    private val songs = mutableListOf<Song>()
    private var isPlaying = false
    private var currentSongIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupCardStackView()
        loadSongs()
        setupButtons()
    }

    private fun setupCardStackView() {
        cardStackLayoutManager = CardStackLayoutManager(this, this).apply {
            setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
            setOverlayInterpolator(LinearInterpolator())
            setCanScrollHorizontal(true)
            setCanScrollVertical(false)
            setVisibleCount(3)
            setTranslationInterval(8.0f)
            setScaleInterval(0.95f)
            setMaxDegree(20.0f)
            setDirections(Direction.HORIZONTAL)
        }

        adapter = SongCardAdapter(songs)
        
        binding.cardStackView.apply {
            layoutManager = cardStackLayoutManager
            adapter = this@MainActivity.adapter
            itemAnimator.apply {
                if (this is DefaultItemAnimator) {
                    supportsChangeAnimations = false
                }
            }
        }
    }

    private fun loadSongs() {
        songs.clear()
        songs.addAll(SampleMusicData.getSampleSongs())
        adapter.updateSongs(songs)
    }

    private fun setupButtons() {
        binding.likeButton.setOnClickListener {
            val setting = SwipeAnimationSetting.Builder()
                .setDirection(Direction.Right)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(LinearInterpolator())
                .build()
            cardStackLayoutManager.setSwipeAnimationSetting(setting)
            binding.cardStackView.swipe()
        }

        binding.dislikeButton.setOnClickListener {
            val setting = SwipeAnimationSetting.Builder()
                .setDirection(Direction.Left)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(LinearInterpolator())
                .build()
            cardStackLayoutManager.setSwipeAnimationSetting(setting)
            binding.cardStackView.swipe()
        }

        binding.playPauseButton.setOnClickListener {
            togglePlayPause()
        }
    }

    private fun togglePlayPause() {
        isPlaying = !isPlaying
        val iconRes = if (isPlaying) R.drawable.ic_pause else R.drawable.ic_play
        binding.playPauseButton.setImageResource(iconRes)
        
        // Here you would control the actual music playback
        // For now, it just toggles the icon
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {
        // Optional: Add visual feedback while dragging
    }

    override fun onCardSwiped(direction: Direction?) {
        currentSongIndex = cardStackLayoutManager.topPosition
        
        when (direction) {
            Direction.Right -> {
                handleSwipe(SwipeDirection.RIGHT)
            }
            Direction.Left -> {
                handleSwipe(SwipeDirection.LEFT)
            }
            Direction.Top -> {
                handleSwipe(SwipeDirection.UP)
            }
            Direction.Bottom -> {
                handleSwipe(SwipeDirection.DOWN)
            }
            else -> {}
        }

        // If we've swiped through all cards, reload
        if (currentSongIndex >= songs.size - 1) {
            // Could load more songs here or restart
            // For now, we'll just show a message
        }
    }

    override fun onCardRewound() {
        currentSongIndex = cardStackLayoutManager.topPosition
    }

    override fun onCardCanceled() {
        // Card returned to center
    }

    override fun onCardAppeared(view: View?, position: Int) {
        // New card appeared
        if (position < songs.size) {
            // Could start playing preview here
        }
    }

    override fun onCardDisappeared(view: View?, position: Int) {
        // Card disappeared
    }

    private fun handleSwipe(direction: SwipeDirection) {
        val swipedSong = songs.getOrNull(currentSongIndex - 1)
        swipedSong?.let { song ->
            when (direction) {
                SwipeDirection.RIGHT -> {
                    // User liked the song
                    saveLikedSong(song)
                }
                SwipeDirection.LEFT -> {
                    // User disliked the song
                    saveDislikedSong(song)
                }
                SwipeDirection.UP -> {
                    // Super like / Add to favorites
                    saveFavoriteSong(song)
                }
                SwipeDirection.DOWN -> {
                    // Maybe later
                }
            }
        }
    }

    private fun saveLikedSong(song: Song) {
        // Save to preferences or database
        // For now, just log it
        println("Liked: ${song.title} by ${song.artist}")
    }

    private fun saveDislikedSong(song: Song) {
        // Save to preferences or database
        println("Disliked: ${song.title} by ${song.artist}")
    }

    private fun saveFavoriteSong(song: Song) {
        // Save to favorites
        println("Added to favorites: ${song.title} by ${song.artist}")
    }
}
