package com.kaizoku.advent.application.y2020.d13

import com.kaizoku.advent.application.core.PuzzleTest
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ComputerTest: PuzzleTest() {

    @Test
    fun chineseRemainderTest() {
        val computer=Computer()
        val equations= listOf(Pair(3L, 5L), Pair(1L, 7L), Pair(6L, 8L))

        assertEquals(78, computer.chineseRemainder(equations))
    }

    @Test
    fun computeTest() {
        val data= listOf(
            "939",
            "7,13,x,x,59,x,31,19"
        )

        val count=Computer().compute(data)
        assertEquals(295, count)

        val count2=Computer().compute2(data)
        assertEquals(1068781L, count2)

        val count2B=Computer().compute2(listOf(
                "",
                "1789,37,47,1889"
        ))
        assertEquals(1202161486L, count2B)
    }

    @Test
    fun puzzle() {
        this.checkPuzzle(D13Puzzle(), Pair("6559", "626670513163231"))
    }

}