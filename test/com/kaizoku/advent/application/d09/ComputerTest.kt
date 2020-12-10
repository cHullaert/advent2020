package com.kaizoku.advent.application.d09

import com.kaizoku.advent.application.core.PuzzleTest
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ComputerTest: PuzzleTest() {

    @Test
    fun computeTest() {
        val data= listOf(
                "35",
                "20",
                "15",
                "25",
                "47",
                "40",
                "62",
                "55",
                "65",
                "95",
                "102",
                "117",
                "150",
                "182",
                "127",
                "219",
                "299",
                "277",
                "309",
                "576"
        )

        val count=Computer().compute(data, 5)
        assertEquals(127, count)

        val count2=Computer().compute2(data, 5)
        assertEquals(62, count2)
    }

    @Test
    fun puzzle() {
        this.checkPuzzle(D9Puzzle(), Pair("257342611", "35602097"))
    }

}