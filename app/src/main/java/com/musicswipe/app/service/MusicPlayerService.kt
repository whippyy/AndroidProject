package com.musicswipe.app.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player

class MusicPlayerService : Service() {

    private var exoPlayer: ExoPlayer? = null
    private val binder = MusicBinder()
    private var playerListener: Player.Listener? = null

    inner class MusicBinder : Binder() {
        fun getService(): MusicPlayerService = this@MusicPlayerService
    }

    override fun onCreate() {
        super.onCreate()
        initializePlayer()
    }

    private fun initializePlayer() {
        exoPlayer = ExoPlayer.Builder(this).build()
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    fun playSong(url: String) {
        exoPlayer?.let { player ->
            val mediaItem = MediaItem.fromUri(url)
            player.setMediaItem(mediaItem)
            player.prepare()
            player.play()
        }
    }

    fun pauseSong() {
        exoPlayer?.pause()
    }

    fun resumeSong() {
        exoPlayer?.play()
    }

    fun stopSong() {
        exoPlayer?.stop()
    }

    fun isPlaying(): Boolean {
        return exoPlayer?.isPlaying ?: false
    }

    fun getCurrentPosition(): Long {
        return exoPlayer?.currentPosition ?: 0
    }

    fun getDuration(): Long {
        return exoPlayer?.duration ?: 0
    }

    fun seekTo(position: Long) {
        exoPlayer?.seekTo(position)
    }

    fun setPlayerListener(listener: Player.Listener) {
        playerListener = listener
        exoPlayer?.addListener(listener)
    }

    fun removePlayerListener() {
        playerListener?.let {
            exoPlayer?.removeListener(it)
        }
        playerListener = null
    }

    override fun onDestroy() {
        super.onDestroy()
        exoPlayer?.release()
        exoPlayer = null
    }
}
