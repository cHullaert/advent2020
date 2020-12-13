package com.kaizoku.advent.application.y2015.d02

import com.kaizoku.advent.application.extensions.mul

class Computer {

    fun compute(data: List<String>): Int {
        return data.asSequence().map { it.split("x") }.map {
            Triple(it[0].toInt(), it[1].toInt(), it[2].toInt())
        }.map {
            Triple(it.first*it.second, it.second*it.third, it.first*it.third)
        }.map {
            listOf(it.first, it.second, it.third).sortedBy { s -> s }.zip(listOf(3, 2, 2)).map {
                p -> p.first*p.second
            }.sum()
        }.sum()
    }

    fun compute2(data: List<String>): Int {
        return data.asSequence().map { it.split("x") }.map {
            listOf(it[0].toInt(), it[1].toInt(), it[2].toInt()).sortedBy { s -> s }
        }.map {
            it.take(2).sum()*2+it.mul()
        }.sum()
    }

}
