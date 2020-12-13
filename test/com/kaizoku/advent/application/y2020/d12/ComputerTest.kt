package com.kaizoku.advent.application.y2020.d12

import com.kaizoku.advent.application.core.PuzzleTest
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ComputerTest: PuzzleTest() {

    @Test
    fun computeTest() {
        val data= listOf(
                "F10",
                "N3",
                "F7",
                "R90",
                "F11"
        )

        assertEquals(Pair(1, 0), Computer().rotate(Pair(-1, 0), 180))
        val count=Computer().compute(data)
        assertEquals(25, count)

        val count2=Computer().compute2(data)
        assertEquals(286, count2)
    }

    @Test
    fun puzzle() {
        this.checkPuzzle(D12Puzzle(), Pair("998", "71586"))
    }

}