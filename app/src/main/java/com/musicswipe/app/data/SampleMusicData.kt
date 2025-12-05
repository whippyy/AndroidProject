package com.musicswipe.app.data

import com.musicswipe.app.model.Song

object SampleMusicData {
    
    fun getSampleSongs(): List<Song> {
        return listOf(
            Song(
                id = "1",
                title = "Blinding Lights",
                artist = "The Weeknd",
                album = "After Hours",
                albumArtUrl = "https://via.placeholder.com/400x400/FF6B6B/FFFFFF?text=Blinding+Lights",
                previewUrl = "sample_preview_url",
                duration = 200,
                genre = "Pop",
                releaseYear = 2020
            ),
            Song(
                id = "2",
                title = "Shape of You",
                artist = "Ed Sheeran",
                album = "÷ (Divide)",
                albumArtUrl = "https://via.placeholder.com/400x400/4ECDC4/FFFFFF?text=Shape+of+You",
                previewUrl = "sample_preview_url",
                duration = 233,
                genre = "Pop",
                releaseYear = 2017
            ),
            Song(
                id = "3",
                title = "Bohemian Rhapsody",
                artist = "Queen",
                album = "A Night at the Opera",
                albumArtUrl = "https://via.placeholder.com/400x400/95E1D3/FFFFFF?text=Bohemian",
                previewUrl = "sample_preview_url",
                duration = 354,
                genre = "Rock",
                releaseYear = 1975
            ),
            Song(
                id = "4",
                title = "Levitating",
                artist = "Dua Lipa",
                album = "Future Nostalgia",
                albumArtUrl = "https://via.placeholder.com/400x400/F38181/FFFFFF?text=Levitating",
                previewUrl = "sample_preview_url",
                duration = 203,
                genre = "Pop",
                releaseYear = 2020
            ),
            Song(
                id = "5",
                title = "Smells Like Teen Spirit",
                artist = "Nirvana",
                album = "Nevermind",
                albumArtUrl = "https://via.placeholder.com/400x400/AA96DA/FFFFFF?text=Teen+Spirit",
                previewUrl = "sample_preview_url",
                duration = 301,
                genre = "Rock",
                releaseYear = 1991
            ),
            Song(
                id = "6",
                title = "Watermelon Sugar",
                artist = "Harry Styles",
                album = "Fine Line",
                albumArtUrl = "https://via.placeholder.com/400x400/FCBAD3/FFFFFF?text=Watermelon",
                previewUrl = "sample_preview_url",
                duration = 174,
                genre = "Pop",
                releaseYear = 2019
            ),
            Song(
                id = "7",
                title = "Billie Jean",
                artist = "Michael Jackson",
                album = "Thriller",
                albumArtUrl = "https://via.placeholder.com/400x400/FFFFD2/000000?text=Billie+Jean",
                previewUrl = "sample_preview_url",
                duration = 294,
                genre = "Pop",
                releaseYear = 1982
            ),
            Song(
                id = "8",
                title = "Lose Yourself",
                artist = "Eminem",
                album = "8 Mile Soundtrack",
                albumArtUrl = "https://via.placeholder.com/400x400/A8D8EA/FFFFFF?text=Lose+Yourself",
                previewUrl = "sample_preview_url",
                duration = 326,
                genre = "Hip Hop",
                releaseYear = 2002
            ),
            Song(
                id = "9",
                title = "Someone Like You",
                artist = "Adele",
                album = "21",
                albumArtUrl = "https://via.placeholder.com/400x400/AA96DA/FFFFFF?text=Someone+Like",
                previewUrl = "sample_preview_url",
                duration = 285,
                genre = "Soul",
                releaseYear = 2011
            ),
            Song(
                id = "10",
                title = "Uptown Funk",
                artist = "Mark Ronson ft. Bruno Mars",
                album = "Uptown Special",
                albumArtUrl = "https://via.placeholder.com/400x400/FCBAD3/FFFFFF?text=Uptown+Funk",
                previewUrl = "sample_preview_url",
                duration = 269,
                genre = "Funk",
                releaseYear = 2014
            )
        )
    }
}
