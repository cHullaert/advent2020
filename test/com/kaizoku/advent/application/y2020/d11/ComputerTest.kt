package com.kaizoku.advent.application.y2020.d11

import com.kaizoku.advent.application.core.PuzzleTest
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ComputerTest: PuzzleTest() {

    @Test
    fun computeTest() {
        val data= listOf(
            "L.LL.LL.LL",
            "LLLLLLL.LL",
            "L.L.L..L..",
            "LLLL.LL.LL",
            "L.LL.LL.LL",
            "L.LLLLL.LL",
            "..L.L.....",
            "LLLLLLLLLL",
            "L.LLLLLL.L",
            "L.LLLLL.LL"
        )

        val count=Computer().compute(data)
        assertEquals(37, count)

        val count2=Computer().compute2(data)
        assertEquals(26, count2)
    }

    @Test
    fun puzzle() {
        this.checkPuzzle(D11Puzzle(), Pair("2472", "2197"))
    }

}