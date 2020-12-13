package com.kaizoku.advent.application.y2020.d01

import com.kaizoku.advent.application.core.PuzzleTest
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ComputerTest: PuzzleTest() {

    @Test
    fun compute() {
        val computer = Computer()
        val value=computer.compute(listOf(1, 2, 3, 4, 5, 2019))
        assertEquals(2019, value)
    }

    @Test
    fun compute3() {
        val computer = Computer()
        val value=computer.compute3(listOf(1, 2, 3, 4, 5, 2010, 6, 2019))
        assertEquals(6*2010*4, value)
    }

    @Test
    fun puzzle() {
        this.checkPuzzle(D1Puzzle(), Pair("381699", "111605670"))
    }
}