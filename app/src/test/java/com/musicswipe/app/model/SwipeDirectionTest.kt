package com.musicswipe.app.model

import org.junit.Test
import org.junit.Assert.*

class SwipeDirectionTest {

    @Test
    fun testSwipeDirectionValues() {
        assertEquals(4, SwipeDirection.values().size)
    }

    @Test
    fun testSwipeDirectionLeft() {
        val direction = SwipeDirection.LEFT
        assertEquals("LEFT", direction.name)
    }

    @Test
    fun testSwipeDirectionRight() {
        val direction = SwipeDirection.RIGHT
        assertEquals("RIGHT", direction.name)
    }

    @Test
    fun testSwipeDirectionUp() {
        val direction = SwipeDirection.UP
        assertEquals("UP", direction.name)
    }

    @Test
    fun testSwipeDirectionDown() {
        val direction = SwipeDirection.DOWN
        assertEquals("DOWN", direction.name)
    }

    @Test
    fun testSwipeDirectionComparison() {
        val left = SwipeDirection.LEFT
        val right = SwipeDirection.RIGHT

        assertNotEquals(left, right)
    }

    @Test
    fun testSwipeDirectionEquality() {
        val direction1 = SwipeDirection.RIGHT
        val direction2 = SwipeDirection.RIGHT

        assertEquals(direction1, direction2)
    }
}
