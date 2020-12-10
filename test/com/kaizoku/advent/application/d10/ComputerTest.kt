package com.kaizoku.advent.application.d10

import com.kaizoku.advent.application.core.PuzzleTest
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ComputerTest: PuzzleTest() {

    @Test
    fun computeTest() {
        val data= listOf(
                "16",
                "10",
                "15",
                "5",
                "1",
                "11",
                "7",
                "19",
                "6",
                "12",
                "4"
        )

        val count=Computer().compute(data)
        assertEquals(35, count)

        val data2=listOf(
                "28",
                "33",
                "18",
                "42",
                "31",
                "14",
                "46",
                "20",
                "48",
                "47",
                "24",
                "23",
                "49",
                "45",
                "19",
                "38",
                "39",
                "11",
                "1",
                "32",
                "25",
                "35",
                "8",
                "17",
                "7",
                "9",
                "4",
                "2",
                "34",
                "10",
                "3"
        )

        val countB=Computer().compute(data2)
        assertEquals(220, countB)

        val count2=Computer().compute2(data)
        assertEquals(8, count2)
        val count2B=Computer().compute2(data2)
        assertEquals(19208, count2B)
    }

    @Test
    fun puzzle() {
        this.checkPuzzle(D10Puzzle(), Pair("2775", "518344341716992"))
    }

}