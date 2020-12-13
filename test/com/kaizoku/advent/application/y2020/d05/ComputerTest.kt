package com.kaizoku.advent.application.y2020.d05

import com.kaizoku.advent.application.core.PuzzleTest
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ComputerTest: PuzzleTest() {

    @Test
    fun computeTest() {
        val seats= listOf("FBFBBFFRLR",
        "BFFFBBFRRR",
        "FFFBBBFRRR",
        "BBFFBBFRLL")

        val ids=Computer().computeSeats(seats)

        assertEquals(ids, listOf(357, 567, 119, 820))
    }

    @Test
    fun puzzle() {
        this.checkPuzzle(D5Puzzle(), Pair("885", "623"))
    }

}