package com.kaizoku.advent.application.y2015.d03

import com.kaizoku.advent.application.core.PuzzleTest
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ComputerTest: PuzzleTest() {

    @Test
    fun computeTest() {
        val data= listOf(
            "^v^v^v^v^v",
            "^>v<"
        )

        val count=Computer().compute(listOf(data[0]))
        assertEquals(2, count)
        val countB=Computer().compute(listOf(data[1]))
        assertEquals(4, countB)

        val count2=Computer().compute2(listOf(data[0]))
        assertEquals(11, count2)
    }

    @Test
    fun puzzle() {
        this.checkPuzzle(D03Puzzle(), Pair("2592", "2360"))
    }

}