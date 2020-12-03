package com.kaizoku.advent.application.d02

import com.kaizoku.advent.application.core.Puzzle

class Computer {

    private fun destructed(password: String): MatchResult.Destructured {
        val regex=Regex("([0-9]+)-([0-9]+) ([a-z]): ([a-z]+)")
        val value=regex.find(password)

        return value!!.destructured
    }

    fun compute2(password: String): Boolean {
        val (pos1, pos2, letter, word) = destructed(password)

        return (word[pos1.toInt()-1]==letter.first()) xor (word[pos2.toInt()-1]==letter.first())
    }

    fun compute(password: String): Boolean {
        val (min, max, letter, word) = destructed(password)

        val list = word.groupBy { it }.filter { it.key == letter.first() }.map { it.value }.firstOrNull()
        if(list!=null)
            return (list.size>=min.toInt()) && (list.size<=max.toInt())

        return min.toInt()==0
    }
}
