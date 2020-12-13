package com.kaizoku.advent.application.y2020.d01

import com.kaizoku.advent.application.extensions.head
import com.kaizoku.advent.application.extensions.tail

class Computer {

    private fun compute(head: Int, tail: List<Int>, expected: Int): Int {
        val numbers=tail.filter { head + it == expected }
        return when {
            numbers.isNotEmpty() -> {
                numbers.first()*head
            }
            tail.isNotEmpty() -> this.compute(tail.head, tail.tail, expected)
            else -> -1
        }
    }

    private fun compute2(numbers: List<Int>, expected: Int): Int {
        if(numbers.isEmpty())
            return -1

        return compute(numbers.head, numbers.tail, expected)
    }

    fun compute(numbers: List<Int>): Int {
        return compute2(numbers, 2020)
    }

    private fun compute3(head: Int, tail: List<Int>): Int {
        if(tail.isEmpty())
            return -1

        val value=compute2(tail, 2020-head)
        if(value==-1)
            return compute3(tail.head, tail.tail)

        return value*head
    }

    fun compute3(numbers: List<Int>): Int {
        if(numbers.isEmpty())
            return -1

        return compute3(numbers.head, numbers.tail)
    }
}
