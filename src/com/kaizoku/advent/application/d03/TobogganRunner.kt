package com.kaizoku.advent.application.d03

import com.kaizoku.advent.application.core.Puzzle
import com.kaizoku.advent.application.extensions.head
import com.kaizoku.advent.application.extensions.tail

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
    Puzzle(
        "03",
        {
            TobogganRunner().slide(it.fileData)
        },
        {
            listOf(Pair(1, 1), Pair(3, 1), Pair(5, 1), Pair(7, 1), Pair(1, 2))
                .map {
                    pair -> TobogganRunner().slide(it.fileData, pair.first, pair.second)
                }.reduce { acc, i ->  acc * i }
        }
    ).play()
}