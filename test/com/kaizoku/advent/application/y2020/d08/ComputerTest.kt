package com.kaizoku.advent.application.y2020.d08

import com.kaizoku.advent.application.core.PuzzleTest
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ComputerTest: PuzzleTest() {

    @Test
    fun computeTest() {
        val data= listOf(
                "nop +0",
                "acc +1",
                "jmp +4",
                "acc +3",
                "jmp -3",
                "acc -99",
                "acc +1",
                "jmp -4",
                "acc +6"
        )

        val count=Computer().compute(data)
        assertEquals(5, count)

        val count2=Computer().compute2(data)
        assertEquals(8, count2)
    }

    @Test
    fun puzzle() {
        this.checkPuzzle(D8Puzzle(), Pair("1684", "1"))
    }

}