package com.kaizoku.advent.application.d03

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TobogganTest {

    @Test
    fun validateTreeCount() {
        val tobogganRunner=TobogganRunner()
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

        val treeCount=tobogganRunner.slide(maps)
        assertEquals(7L, treeCount)
    }

    @Test
    fun validateTreeCountOffset() {
        val tobogganRunner=TobogganRunner()
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

        val trees=listOf(tobogganRunner.slide(maps, 1, 1),
                            tobogganRunner.slide(maps, 3, 1),
                            tobogganRunner.slide(maps, 5, 1),
                            tobogganRunner.slide(maps, 7, 1),
                            tobogganRunner.slide(maps, 1, 2))
        assertEquals(listOf(2L, 7L, 3L, 4L, 2L), trees)

        assertEquals(336L, trees.reduce { acc, i ->  acc * i })
    }}