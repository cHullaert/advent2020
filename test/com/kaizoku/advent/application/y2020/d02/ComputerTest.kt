package com.kaizoku.advent.application.y2020.d02

import com.kaizoku.advent.application.core.PuzzleTest
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ComputerTest: PuzzleTest() {

    @Test
    fun compute() {
        val validator = Computer()
        assertTrue(validator.compute("1-3 a: abcde"))
        assertFalse(validator.compute("1-3 b: cdefg"))
        assertTrue(validator.compute("2-9 c: ccccccccc"))
    }

    @Test
    fun compute2() {
        val validator = Computer()
        assertTrue(validator.compute2("1-3 a: abcde"))
        assertFalse(validator.compute2("1-3 b: cdefg"))
        assertFalse(validator.compute2("2-9 c: ccccccccc"))
    }

    @Test
    fun puzzle() {
        this.checkPuzzle(D2Puzzle(), Pair("622", "263"))
        this.checkPuzzle(D2PuzzleConcurrent(), Pair("622", "263"))
    }
}