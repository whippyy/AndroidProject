package com.musicswipe.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.chip.Chip
import com.musicswipe.app.R
import com.musicswipe.app.model.Song

class SongCardAdapter(private var songs: List<Song>) :
    RecyclerView.Adapter<SongCardAdapter.SongCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongCardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_song_card, parent, false)
        return SongCardViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongCardViewHolder, position: Int) {
        val song = songs[position]
        holder.bind(song)
    }

    override fun getItemCount(): Int = songs.size

    fun updateSongs(newSongs: List<Song>) {
        songs = newSongs
        notifyDataSetChanged()
    }

    class SongCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val albumArt: ImageView = itemView.findViewById(R.id.albumArt)
        private val songTitle: TextView = itemView.findViewById(R.id.songTitle)
        private val artistName: TextView = itemView.findViewById(R.id.artistName)
        private val albumInfo: TextView = itemView.findViewById(R.id.albumInfo)
        private val genreChip: Chip = itemView.findViewById(R.id.genreChip)

        fun bind(song: Song) {
            songTitle.text = song.title
            artistName.text = song.artist
            albumInfo.text = "${song.album} • ${song.releaseYear}"
            genreChip.text = song.genre

            // Load album art using Glide
            Glide.with(itemView.context)
                .load(song.albumArtUrl)
                .placeholder(R.drawable.ic_music_placeholder)
                .error(R.drawable.ic_music_placeholder)
                .centerCrop()
                .into(albumArt)
        }
    }
}
