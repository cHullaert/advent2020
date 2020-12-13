package com.kaizoku.advent.application.y2020.d13

import com.kaizoku.advent.application.extensions.mul
import com.kaizoku.advent.application.extensions.transform

class Computer {

    fun compute(data: List<String>): Int {
        val timestamp=data[0].toInt()
        val bus=data[1].split(",").filter { it != "x" }.map { it.toInt() }

        return bus.map {
            Pair(it, it - timestamp % it)
        }.minBy {
            it.second
        }!!.transform {
            it.first * it.second
        }
    }

    fun compute2(data: List<String>): Long {
        val bus=data[1].split(",").mapIndexed {
            index, v -> Pair(index, v)
        }.filter {
            it.second != "x"
        }.map {
            Pair(it.first, it.second.toLong() )
        }.map {
            Pair((it.second-it.first) % it.second, it.second)
        }

        return chineseRemainder(bus)
    }

    fun chineseRemainder(equations: List<Pair<Long, Long>>): Long {
        //https://www.youtube.com/watch?v=zIFehsBHB8o
        val N=equations.map { it.second }.mul()
        val n=equations.map { N/it.second }
        val x=equations.zip(n).map {
            val v = it.second % it.first.second
            println("${it.second} % ${it.first.second} = $v")
            (1 until it.first.second).first {
                index -> (v*index) % it.first.second == 1L
            }
        }
        val bnx=equations
                .zip(n)
                .zip(x).map {
            it.second*it.first.second*it.first.first.first
        }
        val X=bnx.sum()

        return X % N
    }

}
