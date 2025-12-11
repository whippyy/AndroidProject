# MusicSwipe Unit Tests Documentation

## Overview

This document describes the comprehensive unit test suite for the MusicSwipe Android application. The tests cover data models, adapters, activities, services, and business logic.

## Test Structure

Tests are organized in two locations:

- **`src/test/java/`** - Unit tests (no Android framework dependencies)
- **`src/androidTest/java/`** - Instrumented tests (require Android framework)

## Test Categories

### 1. Data Model Tests (`src/test/java/com/musicswipe/app/model/`)

#### SongTest
Tests the `Song` data class:
- **testSongCreation**: Verifies song object creation with all properties
- **testSongEquality**: Tests equality of identical songs
- **testSongInequality**: Tests inequality of different songs
- **testSongWithDifferentDuration**: Tests duration comparison between songs

#### UserPreferencesTest
Tests the `UserPreferences` data class:
- **testUserPreferencesInitialization**: Verifies empty initialization
- **testAddLikedSong**: Tests adding liked songs
- **testAddDislikedSong**: Tests adding disliked songs
- **testAddFavoriteGenre**: Tests adding favorite genres
- **testRemoveLikedSong**: Tests removing songs from preferences
- **testClearAllPreferences**: Tests clearing all preferences
- **testDuplicateLikedSongs**: Tests handling duplicate songs
- **testMultipleOperations**: Tests complex operations on preferences

#### SwipeDirectionTest
Tests the `SwipeDirection` enum:
- **testSwipeDirectionValues**: Verifies all enum values exist
- **testSwipeDirectionLeft**: Tests LEFT direction
- **testSwipeDirectionRight**: Tests RIGHT direction
- **testSwipeDirectionUp**: Tests UP direction
- **testSwipeDirectionDown**: Tests DOWN direction
- **testSwipeDirectionComparison**: Tests direction comparison
- **testSwipeDirectionEquality**: Tests direction equality

### 2. Data Source Tests (`src/test/java/com/musicswipe/app/data/`)

#### SampleMusicDataTest
Tests the `SampleMusicData` provider:
- **testGetSampleSongsNotEmpty**: Verifies sample data is not empty
- **testGetSampleSongsCount**: Verifies correct number of sample songs (10)
- **testSampleSongsHaveValidData**: Verifies all songs have valid properties
- **testSampleSongsUniqueIds**: Verifies all song IDs are unique
- **testSampleSongsHaveGenres**: Verifies sample data includes various genres
- **testSampleSongsRealisticDuration**: Verifies songs have realistic durations (100-600 seconds)
- **testSampleSongsRealisticReleaseYear**: Verifies release years are realistic (1970-2025)
- **testSampleSongsConsistency**: Verifies data consistency across calls
- **testSampleSongsUrls**: Verifies URL validity
- **testFirstSongIsBlindingLights**: Verifies first song data
- **testLastSongIsUptownFunk**: Verifies last song data

### 3. Adapter Tests (`src/androidTest/java/com/musicswipe/app/adapter/`)

#### SongCardAdapterTest
Tests the `SongCardAdapter` RecyclerView adapter:
- **testAdapterInitialization**: Verifies adapter is initialized with correct item count
- **testAdapterItemCount**: Tests item count with 5 songs
- **testAdapterEmptyList**: Tests adapter with empty list
- **testUpdateSongs**: Tests updating songs in adapter
- **testAdapterWithSingleSong**: Tests adapter with 1 song
- **testAdapterWithMultipleSongs**: Tests adapter with 10 songs
- **testAdapterUpdateWithDifferentSizes**: Tests updating with different sizes
- **testCreateViewHolder**: Verifies ViewHolder creation

### 4. Activity Tests (`src/androidTest/java/com/musicswipe/app/`)

#### MainActivityTest
Tests the main activity UI components:
- **testActivityCreation**: Verifies activity is created successfully
- **testLikeButtonVisible**: Verifies like button is visible
- **testDislikeButtonVisible**: Verifies dislike button is visible
- **testPlayPauseButtonVisible**: Verifies play/pause button is visible
- **testCardStackViewVisible**: Verifies card stack view is visible
- **testAppTitle**: Verifies app title is present
- **testControlPanelVisible**: Verifies control panel is visible

### 5. Service Tests (`src/androidTest/java/com/musicswipe/app/service/`)

#### MusicPlayerServiceTest
Tests the `MusicPlayerService`:
- **testServiceBinding**: Verifies service binding
- **testServiceBinder**: Tests service binder functionality
- **testInitialPlayingState**: Verifies initial playing state is false
- **testGetCurrentPosition**: Verifies current position is 0 initially
- **testGetDuration**: Verifies duration is 0 initially

## Running the Tests

### Run All Tests
```bash
./gradlew test                    # Run all unit tests
./gradlew connectedAndroidTest   # Run all instrumented tests
```

### Run Specific Test Class
```bash
./gradlew test --tests SongTest
./gradlew test --tests UserPreferencesTest
./gradlew connectedAndroidTest --tests MainActivityTest
```

### Run Tests with Coverage
```bash
./gradlew testDebugUnitTestCoverage
./gradlew testDebugAndroidTestCoverage
```

### Run from Android Studio
1. Right-click on test class or method
2. Select "Run 'ClassName'" or "Run 'methodName()'"
3. View results in the Run window

## Test Dependencies

```gradle
// Unit Testing
testImplementation 'junit:junit:4.13.2'
testImplementation 'org.mockito:mockito-core:5.7.0'
testImplementation 'org.mockito.kotlin:mockito-kotlin:5.1.0'

// Android Instrumented Testing
androidTestImplementation 'androidx.test.ext:junit:1.1.5'
androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
androidTestImplementation 'androidx.test:core:1.5.1'
androidTestImplementation 'androidx.test:runner:1.5.2'
androidTestImplementation 'androidx.test:rules:1.5.1'
```

## Coverage Goals

- **Models**: 95%+ coverage
- **Adapters**: 85%+ coverage
- **Activities**: 80%+ coverage
- **Services**: 85%+ coverage
- **Overall**: 85%+ coverage

## Best Practices Used

1. **Separation of Concerns**: Unit tests separate from instrumented tests
2. **Meaningful Names**: Test methods have descriptive names
3. **AAA Pattern**: Tests follow Arrange-Act-Assert pattern
4. **Isolation**: Each test is independent
5. **Clarity**: Tests are easy to understand and maintain
6. **Coverage**: Critical business logic is tested

## Adding New Tests

When adding new features:

1. Create a new test class in appropriate directory
2. Use `@Test` annotation for test methods
3. Use `@Before` for setup and `@After` for cleanup
4. Follow naming convention: `test<Feature><Scenario>`
5. Use meaningful assertions
6. Test both happy path and edge cases

## Example Test Structure

```kotlin
class MyFeatureTest {
    
    private lateinit var feature: MyFeature
    
    @Before
    fun setUp() {
        feature = MyFeature()
    }
    
    @Test
    fun testFeatureDoesExpectedBehavior() {
        // Arrange
        val input = "test"
        
        // Act
        val result = feature.doSomething(input)
        
        // Assert
        assertEquals("expected", result)
    }
}
```

## Continuous Integration

Tests are automatically run on:
- Every push to repository
- Pull request creation
- Before merge to main branch

## Troubleshooting

### Test Fails Locally But Passes on CI
- Clear gradle cache: `./gradlew clean`
- Rebuild: `./gradlew build`
- Check API level compatibility

### Instrumented Tests Won't Run
- Connect Android device or start emulator
- Update Android SDK and build tools
- Check `testInstrumentationRunner` in build.gradle

### Coverage Reports Not Generated
```bash
./gradlew testDebugUnitTestCoverage --info
./gradlew connectedAndroidTestCoverage --info
```

## Future Test Enhancements

- [ ] Add Espresso UI tests for button clicks and navigation
- [ ] Add performance tests for large song lists
- [ ] Add integration tests with mock music APIs
- [ ] Add property-based tests with QuickCheck
- [ ] Add screenshot testing for UI regression
- [ ] Mock ExoPlayer for service testing

---

For more information on testing Android apps, see:
- [Android Testing Documentation](https://developer.android.com/training/testing)
- [JUnit 4 Documentation](https://junit.org/junit4/)
- [Espresso Testing Framework](https://developer.android.com/training/testing/espresso)



