package com.musicswipe.app.service

import android.content.Context
import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ServiceTestRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import java.util.concurrent.TimeoutException

@RunWith(AndroidJUnit4::class)
class MusicPlayerServiceTest {

    @get:Rule
    val serviceRule = ServiceTestRule()

    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun testServiceBinding() {
        val intent = Intent(context, MusicPlayerService::class.java)
        val binder = serviceRule.bindService(intent)

        assertNotNull(binder)
    }

    @Test
    fun testServiceBinder() {
        val intent = Intent(context, MusicPlayerService::class.java)
        val binder = serviceRule.bindService(intent)
        val service = (binder as MusicPlayerService.MusicBinder).getService()

        assertNotNull(service)
    }

    @Test
    fun testInitialPlayingState() {
        val intent = Intent(context, MusicPlayerService::class.java)
        val binder = serviceRule.bindService(intent)
        val service = (binder as MusicPlayerService.MusicBinder).getService()

        assertFalse(service.isPlaying())
    }

    @Test
    fun testGetCurrentPosition() {
        val intent = Intent(context, MusicPlayerService::class.java)
        val binder = serviceRule.bindService(intent)
        val service = (binder as MusicPlayerService.MusicBinder).getService()

        assertEquals(0L, service.getCurrentPosition())
    }

    @Test
    fun testGetDuration() {
        val intent = Intent(context, MusicPlayerService::class.java)
        val binder = serviceRule.bindService(intent)
        val service = (binder as MusicPlayerService.MusicBinder).getService()

        assertEquals(0L, service.getDuration())
    }
}
