package com.kaizoku.advent.application.extensions

import com.kaizoku.advent.application.core.Puzzle

val <T> List<T>.tail: List<T>
    get() = drop(1)

val <T> List<T>.head: T
    get() = first()

val Puzzle.numbers: List<Int>
    get() = this.fileData.map { number -> number.toInt() }
