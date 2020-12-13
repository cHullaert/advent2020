package com.kaizoku.advent.application.y2020.d09

import com.kaizoku.advent.application.extensions.head
import com.kaizoku.advent.application.extensions.tail

class Computer {

    private fun computeNumbers(data: List<Long>, size: Int): Long {
        return if(testSum(data.take(size), data[size])) {
            computeNumbers(data.tail, size)
        }
        else
            data[size]
    }

    private fun testSum(list: List<Long>, expected: Long): Boolean {
        if(list.isEmpty())
            return false

        val head=list.head
        val tail=list.tail

        return if(tail.any { it + head == expected })
            true
        else
            testSum(tail, expected)
    }

    fun compute(data: List<String>, size: Int=25): Long {
        return computeNumbers(data.map {
            it.toLong()
        }, size)
    }

    fun compute2(data: List<String>, size: Int=25): Long {
        val error=compute(data, size)
        val pair=findSum(error, data.map { it.toLong() })
        return pair.first+pair.second
    }

    private fun findSum(error: Long, numbers: List<Long>): Pair<Long, Long> {
        val value=(1..numbers.size).find {
            error==numbers.take(it).sum()
        }

        return if(value!=null) {
            val lasts=numbers.take(value)
            Pair(lasts.min()!!, lasts.max()!!)
        }
        else
            findSum(error, numbers.tail)
    }
}
