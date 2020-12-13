package com.kaizoku.advent.application.y2015.d02

import com.kaizoku.advent.application.core.PuzzleTest
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ComputerTest: PuzzleTest() {

    @Test
    fun computeTest() {
        val data= listOf(
            "2x3x4",
            "1x1x10"
        )

        val count=Computer().compute(data)
        assertEquals(101, count)

        val count2=Computer().compute2(data)
        assertEquals(48, count2)
    }

    @Test
    fun puzzle() {
        this.checkPuzzle(D02Puzzle(), Pair("1588178", "3783758"))
    }

}