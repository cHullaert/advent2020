package com.kaizoku.advent.application.y2015.d01

import com.kaizoku.advent.application.core.PuzzleTest
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ComputerTest: PuzzleTest() {

    @Test
    fun computeTest() {
        val data= listOf(
                "()())"
        )

        val count= Computer().compute(data)
        assertEquals(-1, count)

        val count2=Computer().compute2(data)
        assertEquals(5, count2)
    }

    @Test
    fun puzzle() {
        this.checkPuzzle(D01Puzzle(), Pair("138", "1771"))
    }

}