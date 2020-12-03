package com.kaizoku.advent.application.core

import java.io.File

class Puzzle(private val inputFile: String,
             val step1: (puzzle: Puzzle)->Any,
             val step2: (puzzle: Puzzle)->Any) {

    private val file: File by lazy {
        File("./resources/$inputFile.txt")
    }

    val fileData: List<String> by lazy {
        file.readLines()
    }

    fun play() {
        println("step 1: "+this.step1(this))
        println("step 2: "+this.step2(this))
    }
}