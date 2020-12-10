package com.kaizoku.advent.application.d10

import com.kaizoku.advent.application.extensions.head
import com.kaizoku.advent.application.extensions.tail

class Computer {

    private fun createDataset(data: List<String>): List<Int> {
        val sorted=(listOf("0")+data).asSequence().map { it.toInt() }
                .sortedBy { it }
        return (sorted+listOf(sorted.max()!!+3)).toList()
    }

    fun compute(data: List<String>): Int {
        val pairs=createDataset(data)
                .zipWithNext()
                .map { it.second-it.first }
                .groupBy { it }

        return (pairs[3] ?: error("must have pair 3")).count()* (pairs[1] ?: error("must have pair 1")).count()
    }

    fun compute2(data: List<String>): Long {
        val dataset = createDataset(data)
        val pathList=computePath(dataset.head, dataset.tail)
        return evaluatePath(pathList)
    }

    private fun evaluatePath(path: List<Int>): Long {
        if(path.isEmpty())
            return 1

        return when(path.head) {
            1 -> evaluatePath(path.tail)
            2 -> {
                2*evaluatePath(path.tail)
            }
            3 -> {
                val count=path.takeWhile { it != 1 }.count()
                fibonnaci(count+1)*evaluatePath(path.drop(count+1))
            }
            else -> -1
        }
    }

    private fun fibonnaci(value: Int): Long {
        return if(value<0)
            0L
        else if(value<=1)
            1L
        else
            fibonnaci(value-1)+fibonnaci(value-2)+fibonnaci(value-3)
    }

    private fun computePath(head: Int, tail: List<Int>): List<Int> {
        if(tail.isEmpty())
            return emptyList()

        return if((tail.size>=3) && (head+3 == tail[2])) {
            listOf(3)+computePath(tail.head, tail.tail)
        } else if((tail.size>=2) && (tail[1] in (head+2..head+3))) {
            listOf(2)+computePath(tail.head, tail.tail)
        } else
            listOf(1)+computePath(tail.head, tail.tail)
    }
}
