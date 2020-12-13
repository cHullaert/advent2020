package com.kaizoku.advent.application.y2015.d04

import com.kaizoku.advent.application.core.PuzzleTest
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ComputerTest: PuzzleTest() {

    @Test
    fun computeTest() {
        val data= listOf(
                "abcdef",
                "pqrstuv"
        )

        val count=Computer().compute(listOf(data[0]))
        assertEquals(609043, count)
        val countB=Computer().compute(listOf(data[1]))
        assertEquals(1048970, countB)
    }

    @Test
    fun puzzle() {
        this.checkPuzzle(D04Puzzle(), Pair("282749", "9962624"))
    }

}