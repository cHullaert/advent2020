package com.kaizoku.advent.application.core

import java.io.File

abstract class Puzzle(private val inputFile: String,
             val step1: (puzzle: Puzzle)->Any,
             val step2: (puzzle: Puzzle)->Any) {

    private val file: File by lazy {
        File("./resources/$inputFile.txt")
    }

    val fileData: List<String> by lazy {
        file.readLines()
    }

    fun play(): Pair<String, String> {
        return Pair(this.step1(this).toString(), this.step2(this).toString())
    }
}