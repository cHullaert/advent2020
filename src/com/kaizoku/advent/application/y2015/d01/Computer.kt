package com.kaizoku.advent.application.y2015.d01

import com.kaizoku.advent.application.extensions.head
import com.kaizoku.advent.application.extensions.tail

class Computer {
    fun compute(data: List<String>): Int {
        return data.flatMap {
            it.asIterable()
        }.fold(0) {
            acc, value -> if(value=='(') acc+1 else acc-1
        }
    }

    fun compute2(data: List<String>): Int {
        val list=data.flatMap {
            it.asIterable()
        }

        return find(list.head, list.tail, 0, 0)+1
    }

    private fun find(head: Char, tail: List<Char>, acc: Int, index: Int): Int {

        val local = acc + (if(head=='(') 1 else -1)

        if(local==-1)
            return index


        return find(tail.head, tail.tail, local, index+1)
    }

}

