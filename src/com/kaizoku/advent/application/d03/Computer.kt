package com.kaizoku.advent.application.d03

import com.kaizoku.advent.application.extensions.head
import com.kaizoku.advent.application.extensions.tail

class Computer {
    private fun compute(head: String, maps: List<String>, index: Int, offset: Int): Long {
        val tree=if (head[index % head.length]=='#') 1L else 0L

        return if(maps.isNotEmpty()) {
            compute(maps.head, maps.tail, index+offset, offset) + tree
        } else
            tree
    }

    fun compute(maps: List<String>): Long {
        return this.compute(maps.head, maps.tail, 0, 3)
    }

    fun compute(maps: List<String>, offset: Int, row: Int): Long {
        val filteredMap = maps.filterIndexed { index, _ ->  index % row == 0}
        return this.compute(filteredMap.head, filteredMap.tail, 0, offset)
    }
}
