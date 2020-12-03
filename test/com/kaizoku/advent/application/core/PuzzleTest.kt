package com.kaizoku.advent.application.core

import kotlin.test.assertEquals

abstract class PuzzleTest {

    protected fun checkPuzzle(puzzle: Puzzle, expected: Pair<String, String>) {
        val result = puzzle.play()
        assertEquals(expected, result)
    }
}