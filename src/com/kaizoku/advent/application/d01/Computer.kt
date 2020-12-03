package com.kaizoku.advent.application.d01

import com.kaizoku.advent.application.extensions.head
import com.kaizoku.advent.application.extensions.tail
import java.io.File


class Computer {

    private fun compute(head: Int, tail: List<Int>, expected: Int): Int {
        val numbers=tail.filter { head + it == expected }
        return if(numbers.isNotEmpty()) {
            numbers.first()*head
        } else if(tail.isNotEmpty())
            this.compute(tail.head, tail.tail, expected)
        else
            -1
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

fun main() {
    val numbers=File("C:\\Users\\Christof\\Documents\\development\\cover\\2020\\advent\\resources\\01.txt")
        .readLines().map { it.toInt() }
    val computer = Computer()
    println(computer.compute(numbers))
    println(computer.compute3(numbers))

}