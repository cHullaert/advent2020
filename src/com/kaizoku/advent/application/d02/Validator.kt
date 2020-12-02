package com.kaizoku.advent.application.d02

import java.io.File

class Validator {

    private fun destructed(password: String): MatchResult.Destructured {
        val regex=Regex("([0-9]+)-([0-9]+) ([a-z]): ([a-z]+)")
        val value=regex.find(password)

        return value!!.destructured
    }

    fun isValid2(password: String): Boolean {
        val (pos1, pos2, letter, word) = destructed(password)

        return (word[pos1.toInt()-1]==letter.first()) xor (word[pos2.toInt()-1]==letter.first())
    }

    fun isValid(password: String): Boolean {
        val (min, max, letter, word) = destructed(password)

        val list = word.groupBy { it }.filter { it.key == letter.first() }.map { it.value }.firstOrNull()
        if(list!=null)
            return (list.size>=min.toInt()) && (list.size<=max.toInt())

        return min.toInt()==0
    }
}

fun main() {
    val passwords= File("C:\\Users\\Christof\\Documents\\development\\cover\\2020\\advent\\resources\\02.txt")
        .readLines()
    val validator = Validator()
    println(passwords.filter { validator.isValid(it) }.count())
    println(passwords.filter { validator.isValid2(it) }.count())
}