# MusicSwipe 🎵

A Tinder-style Android app for discovering music! Swipe right to like songs, swipe left to pass, and discover your next favorite tracks.

## Features

- 🎴 **Card-based UI**: Swipe through songs with smooth animations
- 👍 **Like/Dislike**: Swipe right to like, left to dislike
- ▶️ **Music Preview**: Play/pause song previews
- 🎨 **Beautiful Design**: Modern Material Design 3 UI
- 📱 **Smooth Animations**: Fluid card stack animations

## How to Use

1. **Swipe Right** ➡️ - Like the song
2. **Swipe Left** ⬅️ - Pass on the song
3. **Tap Play Button** ▶️ - Preview the song
4. **Use Bottom Buttons** - Quick actions for like/dislike

## Tech Stack

- **Language**: Kotlin
- **UI**: Material Design 3, ViewBinding
- **Card Swipe**: CardStackView library
- **Image Loading**: Glide
- **Music Playback**: ExoPlayer
- **Architecture**: Service-based music player

## Project Structure

```
app/
├── src/main/
│   ├── java/com/musicswipe/app/
│   │   ├── MainActivity.kt           # Main activity with swipe logic
│   │   ├── adapter/
│   │   │   └── SongCardAdapter.kt    # RecyclerView adapter for song cards
│   │   ├── data/
│   │   │   └── SampleMusicData.kt    # Sample song data
│   │   ├── model/
│   │   │   ├── Song.kt               # Song data model
│   │   │   ├── UserPreferences.kt    # User preferences model
│   │   │   └── SwipeDirection.kt     # Swipe direction enum
│   │   └── service/
│   │       └── MusicPlayerService.kt # Music playback service
│   ├── res/
│   │   ├── layout/
│   │   │   ├── activity_main.xml     # Main screen layout
│   │   │   └── item_song_card.xml    # Song card layout
│   │   ├── drawable/                 # Icons and graphics
│   │   ├── values/
│   │   │   ├── colors.xml            # Color palette
│   │   │   ├── strings.xml           # String resources
│   │   │   └── themes.xml            # App theme
│   │   └── xml/                      # Backup rules
│   └── AndroidManifest.xml
├── build.gradle                      # App-level Gradle config
└── proguard-rules.pro               # ProGuard rules
```

## Build Instructions

### Prerequisites
- Android Studio Arctic Fox or later
- JDK 8 or higher
- Android SDK API 24+ (Android 7.0+)

### Steps

1. **Clone the repository**
   ```bash
   cd /Users/henryle/Documents/CSCI3081W/AndroidProject
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an existing project"
   - Navigate to the project directory

3. **Sync Gradle**
   - Wait for Gradle sync to complete
   - If prompted, accept any SDK or dependency updates

4. **Run the app**
   - Connect an Android device or start an emulator
   - Click the "Run" button (▶️) or press `Shift + F10`

### Build from Command Line

```bash
# Clean build
./gradlew clean

# Build debug APK
./gradlew assembleDebug

# Install on connected device
./gradlew installDebug

# Build and run
./gradlew installDebug && adb shell am start -n com.musicswipe.app/.MainActivity
```

## Dependencies

- **AndroidX Core**: 1.12.0
- **AppCompat**: 1.6.1
- **Material Design**: 1.11.0
- **ConstraintLayout**: 2.1.4
- **CardStackView**: 2.3.4
- **Kotlin Coroutines**: 1.7.3
- **Lifecycle Components**: 2.7.0
- **Glide**: 4.16.0
- **ExoPlayer**: 2.19.1

## Future Enhancements

- 🔗 Integration with Spotify/Apple Music API
- 💾 Local database for liked songs
- 🎵 Real music playback with 30s previews
- 📊 Personalized recommendations based on likes
- 👥 Social features - share with friends
- 🎧 Playlist creation from liked songs
- 🔍 Search and filter by genre/artist
- 📱 User authentication and profiles

## Customization

### Adding Real Music Data

Replace the sample data in `SampleMusicData.kt` with real music from:
- Spotify API
- Apple Music API
- Last.fm API
- Your own music database

### Changing Colors

Edit `app/src/main/res/values/colors.xml` to customize the color scheme.

### Modifying Swipe Behavior

Adjust swipe settings in `MainActivity.kt`:
```kotlin
cardStackLayoutManager = CardStackLayoutManager(this, this).apply {
    setVisibleCount(3)           // Number of visible cards
    setTranslationInterval(8.0f) // Card translation distance
    setScaleInterval(0.95f)      // Card scale factor
    setMaxDegree(20.0f)          // Max rotation angle
}
```

## License

This project is for educational purposes. See LICENSE file for details.

## Credits

- CardStackView by yuyakaido
- Material Design by Google
- ExoPlayer by Google
- Glide by Bump Technologies

---

Built with ❤️ for music lovers everywhere! 🎶