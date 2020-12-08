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

fun <T> List<T>.indexesOf(predicate: (value: T) -> Boolean): List<Int> {
    return this.mapIndexed {
        index, value -> if(predicate(value)) index else -1
    }.filter {
        it != -1
    }
}

fun <T> List<T>.splitBy(predicate: (value: T) -> Boolean): List<List<T>> {
    var current = 0
    return this.map {
        value -> if(!predicate(value)) Pair(value, current) else {
            current++
            Pair(value, -1)
        }
    }.filter {
        it.second != -1
    }.groupBy({it.second}, {it.first})
            .values.toList()
}

fun <K, V1, V2, R> Map<K, V1>.mergeReduce(other: Map<K, V2>, reduce: (key: K, value1: V1?, value2: V2?) -> R): Map<K, R> =
        (this.keys + other.keys).associateWith { reduce(it, this[it], other[it]) }

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
