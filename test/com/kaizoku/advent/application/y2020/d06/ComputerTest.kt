package com.kaizoku.advent.application.y2020.d06

import com.kaizoku.advent.application.core.PuzzleTest
import com.kaizoku.advent.application.y2020.d07.D7Puzzle
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ComputerTest: PuzzleTest() {

    @Test
    fun computeTest() {
        val data= listOf("abc", "",
                         "a", "b", "c", "",
                         "ab", "ac", "",
                         "a", "a", "a", "a", "",
                         "b")

        val count=Computer().compute(data)
        assertEquals(11, count)

        val count2=Computer().compute2(data)
        assertEquals(6, count2)
    }

    @Test
    fun puzzle() {
        this.checkPuzzle(D7Puzzle(), Pair("6430", "3125"))
    }

}