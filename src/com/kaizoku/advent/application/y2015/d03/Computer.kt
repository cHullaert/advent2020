package com.kaizoku.advent.application.y2015.d03

class Computer {

    fun compute(data: List<String>): Int {
        return createJourney(data.flatMap { it.asIterable() }).distinct().count()
    }

    private fun createJourney(data: List<Char>): List<Pair<Int, Int>> {
        return data.fold(listOf(Pair(0, 0))) { acc, iterable ->
            acc + when (iterable) {
                '^' -> Pair(acc.last().first - 1, acc.last().second)
                'v' -> Pair(acc.last().first + 1, acc.last().second)
                '<' -> Pair(acc.last().first, acc.last().second - 1)
                '>' -> Pair(acc.last().first, acc.last().second + 1)
                else -> error("cannot have $iterable parameter")
            }
        }
    }

    fun compute2(data: List<String>): Int {
        return createJourney(data.flatMap { it.asIterable() }.filterIndexed { index, _ -> index % 2 == 0 })
                .union(createJourney(data.flatMap { it.asIterable() }.filterIndexed { index, _ -> index % 2 == 1 }))
                .distinct()
                .count()
    }

}
