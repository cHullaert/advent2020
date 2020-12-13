package com.kaizoku.advent.application.y2015.d05

import com.kaizoku.advent.application.core.PuzzleTest
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ComputerTest: PuzzleTest() {

    @Test
    fun computeTest() {
        val data= listOf(
                "ugknbfddgicrmopn",
                "aaa",
                "jchzalrnumimnmhp",
                "haegwjzuvuyypxyu",
                "dvszwmarrgswjxmb"
        )

        val count=Computer().compute(data)
        assertEquals(2, count)

        val data2=listOf(
                "qjhvhtzxzqqjkmpb",
                "xxyxx",
                "uurcxstgmygtbstg",
                "ieodomkazucvgmuy",
                "aaa",
                "aaaxyxy"
        )
        val count2=Computer().compute2(data2)
        assertEquals(3, count2)
    }

    @Test
    fun puzzle() {
        this.checkPuzzle(D05Puzzle(), Pair("258", "53"))
    }

}