package com.kaizoku.advent.application.y2015.d06

import com.kaizoku.advent.application.core.PuzzleTest
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ComputerTest: PuzzleTest() {

    @Test
    fun computeTest() {
        val data= listOf(
            "turn on 0,0 through 999,999",
            "toggle 0,0 through 999,0",
            "turn off 499,499 through 500,500"
        )

        val count=Computer().compute(data)
        assertEquals(1000000-1000-4, count)

        val count2=Computer().compute2(listOf("turn on 0,0 through 0,0"))
        assertEquals(1, count2)

        val count2B=Computer().compute2(listOf("toggle 0,0 through 999,999"))
        assertEquals(2000000, count2B)

        val count2C=Computer().compute2(listOf("turn on 0,0 through 0,0",
                                                "toggle 0,0 through 999,999"))
        assertEquals(2000001, count2C)
    }

    @Test
    fun puzzle() {
        this.checkPuzzle(D06Puzzle(), Pair("569999", "17836115"))
    }

}