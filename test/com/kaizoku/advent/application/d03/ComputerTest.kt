package com.kaizoku.advent.application.d03

import com.kaizoku.advent.application.core.PuzzleTest
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ComputerTest: PuzzleTest() {

    @Test
    fun validateTreeCount() {
        val computer=Computer()
        val maps = listOf(
            "..##.......",
            "#...#...#..",
            ".#....#..#.",
            "..#.#...#.#",
            ".#...##..#.",
            "..#.##.....",
            ".#.#.#....#",
            ".#........#",
            "#.##...#...",
            "#...##....#",
            ".#..#...#.#"
        )

        val treeCount=computer.compute(maps)
        assertEquals(7L, treeCount)
    }

    @Test
    fun validateTreeCountOffset() {
        val computer=Computer()
        val maps = listOf(
            "..##.......",
            "#...#...#..",
            ".#....#..#.",
            "..#.#...#.#",
            ".#...##..#.",
            "..#.##.....",
            ".#.#.#....#",
            ".#........#",
            "#.##...#...",
            "#...##....#",
            ".#..#...#.#"
        )

        val trees=listOf(computer.compute(maps, 1, 1),
            computer.compute(maps, 3, 1),
            computer.compute(maps, 5, 1),
            computer.compute(maps, 7, 1),
            computer.compute(maps, 1, 2))
        assertEquals(listOf(2L, 7L, 3L, 4L, 2L), trees)

        assertEquals(336L, trees.reduce { acc, i ->  acc * i })
    }

    @Test
    fun puzzle() {
        this.checkPuzzle(D3Puzzle(), Pair("159", "6419669520"))
        this.checkPuzzle(D3PuzzleConcurrent(), Pair("159", "6419669520"))
    }
}