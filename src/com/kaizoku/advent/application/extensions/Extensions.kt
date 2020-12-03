package com.kaizoku.advent.application.extensions

import com.kaizoku.advent.application.core.Puzzle
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList

val <T> List<T>.tail: List<T>
    get() = drop(1)

val <T> List<T>.head: T
    get() = first()

val Puzzle.numbers: List<Int>
    get() = this.fileData.map { number -> number.toInt() }

fun <T, R> Iterable<T>.pmap(
    numThreads: Int = Runtime.getRuntime().availableProcessors() - 2,
    exec: ExecutorService = Executors.newFixedThreadPool(numThreads),
    transform: (T) -> R): List<R> {

    // default size is just an inlined version of kotlin.collections.collectionSizeOrDefault
    val defaultSize = if (this is Collection<*>) this.size else 10
    val destination = Collections.synchronizedList(ArrayList<R>(defaultSize))

    for (item in this) {
        exec.submit { destination.add(transform(item)) }
    }

    exec.shutdown()
    exec.awaitTermination(1, TimeUnit.DAYS)

    return ArrayList<R>(destination)
}