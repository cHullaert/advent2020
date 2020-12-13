package com.kaizoku.advent.application.y2020.d12

import com.kaizoku.advent.application.extensions.transform
import java.lang.IllegalArgumentException
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.round
import kotlin.math.sin


class Computer {

    private fun manhattan(pair: Pair<Int, Int>): Int {
        return abs(pair.first)+ abs(pair.second)
    }

    private fun parse(move: String): Pair<Char, Int> {
        return Pair(move[0], move.takeLast(move.length-1).toInt())
    }

    private fun doMove(ship: Pair<Pair<Int, Int>, Pair<Int, Int>>, move: String): Pair<Pair<Int, Int>, Pair<Int, Int>> {
        val command=parse(move)

        return when(command.first) {
            'N' -> Pair(ship.first, Pair(ship.second.first, ship.second.second+command.second))
            'S' -> Pair(ship.first, Pair(ship.second.first, ship.second.second-command.second))
            'E' -> Pair(ship.first, Pair(ship.second.first+command.second, ship.second.second))
            'W' -> Pair(ship.first, Pair(ship.second.first-command.second, ship.second.second))
            'L' -> Pair(rotate(ship.first, command.second), ship.second)
            'R' -> Pair(rotate(ship.first, -command.second), ship.second)
            'F' -> Pair(ship.first, Pair(ship.second.first+command.second*ship.first.first, ship.second.second+command.second*ship.first.second))
            else -> throw IllegalArgumentException("unknown action $move")
        }
    }

    private fun doMove2(ship: Pair<Pair<Int, Int>, Pair<Int, Int>>, move: String): Pair<Pair<Int, Int>, Pair<Int, Int>> {
        val command=parse(move)

        return when(command.first) {
            'N' -> Pair(Pair(ship.first.first, ship.first.second+command.second), ship.second)
            'S' -> Pair(Pair(ship.first.first, ship.first.second-command.second), ship.second)
            'E' -> Pair(Pair(ship.first.first+command.second, ship.first.second), ship.second)
            'W' -> Pair(Pair(ship.first.first-command.second, ship.first.second), ship.second)
            'L' -> Pair(rotate(ship.first, command.second), ship.second)
            'R' -> Pair(rotate(ship.first, -command.second), ship.second)
            'F' -> Pair(ship.first, Pair(ship.second.first+command.second*ship.first.first, ship.second.second+command.second*ship.first.second))
            else -> throw IllegalArgumentException("unknown action $move")
        }
    }

    fun rotate(vector: Pair<Int, Int>, angle: Int): Pair<Int, Int> {
        val angleD=angle.toDouble()*Math.PI/180.0
        val sinD=sin(angleD)
        val cosD=cos(angleD)
        val x=round(vector.first*cosD-vector.second*sinD).toInt()
        val y=round(vector.first*sinD+vector.second*cosD).toInt()

        return Pair(x, y)
    }

    fun compute(data: List<String>): Int {
        return data.fold(Pair(Pair(1, 0), Pair(0, 0))) {
            ship, move -> doMove(ship, move)
        }.transform {
            manhattan(it.second)
        }
    }

    fun compute2(data: List<String>): Int {
        return data.fold(Pair(Pair(10, 1), Pair(0, 0))) {
            ship, move -> doMove2(ship, move)
        }.transform {
            manhattan(it.second)
        }
    }

}
