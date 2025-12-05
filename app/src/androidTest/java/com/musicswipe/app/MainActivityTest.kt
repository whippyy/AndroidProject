package com.musicswipe.app

import android.view.View
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.musicswipe.app.model.SwipeDirection
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setUp() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun testActivityCreation() {
        scenario.onActivity { activity ->
            assertNotNull(activity)
            assertNotNull(activity.window)
        }
    }

    @Test
    fun testLikeButtonVisible() {
        scenario.onActivity { activity ->
            val likeButton = activity.findViewById<View>(com.musicswipe.app.R.id.likeButton)
            assertNotNull(likeButton)
            assertEquals(View.VISIBLE, likeButton.visibility)
        }
    }

    @Test
    fun testDislikeButtonVisible() {
        scenario.onActivity { activity ->
            val dislikeButton = activity.findViewById<View>(com.musicswipe.app.R.id.dislikeButton)
            assertNotNull(dislikeButton)
            assertEquals(View.VISIBLE, dislikeButton.visibility)
        }
    }

    @Test
    fun testPlayPauseButtonVisible() {
        scenario.onActivity { activity ->
            val playButton = activity.findViewById<View>(com.musicswipe.app.R.id.playPauseButton)
            assertNotNull(playButton)
            assertEquals(View.VISIBLE, playButton.visibility)
        }
    }

    @Test
    fun testCardStackViewVisible() {
        scenario.onActivity { activity ->
            val cardStackView = activity.findViewById<View>(com.musicswipe.app.R.id.cardStackView)
            assertNotNull(cardStackView)
            assertEquals(View.VISIBLE, cardStackView.visibility)
        }
    }

    @Test
    fun testAppTitle() {
        scenario.onActivity { activity ->
            val titleView = activity.findViewById<View>(com.musicswipe.app.R.id.appTitle)
            assertNotNull(titleView)
        }
    }

    @Test
    fun testControlPanelVisible() {
        scenario.onActivity { activity ->
            val controlPanel = activity.findViewById<View>(com.musicswipe.app.R.id.controlPanel)
            assertNotNull(controlPanel)
            assertEquals(View.VISIBLE, controlPanel.visibility)
        }
    }
}
