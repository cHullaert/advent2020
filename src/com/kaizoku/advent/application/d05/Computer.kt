package com.kaizoku.advent.application.d05

import java.lang.IllegalArgumentException

class Computer {
    fun computeSeats(seats: List<String>): List<Int> {
        return seats.map { computeSeat(it) }
    }

    private fun computeSeat(seat: String): Int {
        val pair = seat.asSequence().fold(Pair(Pair(0, 127), Pair(0, 7))) { acc, value ->
            when(value) {
                'F' -> {
                    Pair(minValue(acc.first), acc.second)
                }
                'B' -> {
                    Pair(maxValue(acc.first), acc.second)
                }
                'L' -> {
                    Pair(acc.first, minValue(acc.second))
                }
                'R' -> {
                    Pair(acc.first, maxValue(acc.second))
                }
                else -> {
                    throw IllegalArgumentException("unknown char $value")
                }
            }
        }
        return pair.first.first*8+pair.second.first
    }

    private fun minValue(pair: Pair<Int, Int>): Pair<Int, Int> {
        return Pair(pair.first, (pair.second-pair.first) / 2 + pair.first)
    }

    private fun maxValue(pair: Pair<Int, Int>): Pair<Int, Int> {
        return Pair((pair.second +1 - pair.first) /2 + pair.first, pair.second)
    }

    fun compute(seats: List<String>): Int {
        return computeSeats(seats).max()!!
    }

    fun compute2(seats: List<String>): Int {
        val usedSeats = computeSeats(seats)
        val freeSeats = (0..usedSeats.max()!!).subtract(usedSeats)

        return freeSeats.first { value ->
            (value != 0) && (value != 127 * 8 + 7) && (!freeSeats.contains(value-1)) && (!freeSeats.contains(value + 1))
        }
    }
}