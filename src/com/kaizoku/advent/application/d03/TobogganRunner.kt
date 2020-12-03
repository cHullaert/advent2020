package com.kaizoku.advent.application.d03

import com.kaizoku.advent.application.d01.Computer
import com.kaizoku.advent.application.extensions.head
import com.kaizoku.advent.application.extensions.tail
import java.io.File

class TobogganRunner {
    private fun slide(head: String, maps: List<String>, index: Int, offset: Int): Long {
        val tree=if (head[index % head.length]=='#') 1L else 0L

        return if(maps.isNotEmpty()) {
            slide(maps.head, maps.tail, index+offset, offset) + tree
        } else
            tree
    }

    fun slide(maps: List<String>): Long {
        return this.slide(maps.head, maps.tail, 0, 3)
    }

    fun slide(maps: List<String>, offset: Int, row: Int): Long {
        val filteredMap = maps.filterIndexed { index, _ ->  index % row == 0}
        return this.slide(filteredMap.head, filteredMap.tail, 0, offset)
    }
}


fun main() {
    val maps= File("C:\\Users\\Christof\\Documents\\development\\cover\\2020\\advent\\resources\\03.txt")
        .readLines()
    val tobogganRunner = TobogganRunner()
    println(tobogganRunner.slide(maps))

    val trees=listOf(tobogganRunner.slide(maps, 1, 1),
        tobogganRunner.slide(maps, 3, 1),
        tobogganRunner.slide(maps, 5, 1),
        tobogganRunner.slide(maps, 7, 1),
        tobogganRunner.slide(maps, 1, 2)
    )
    println(trees)
    println(trees.reduce { acc, i ->  acc * i })
}