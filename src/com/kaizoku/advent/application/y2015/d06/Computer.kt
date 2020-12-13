package com.kaizoku.advent.application.y2015.d06

class Computer {
    private val rowCount = 1000
    private val colCount = 1000

    fun compute(data: List<String>): Int {
        return data.fold(BooleanArray(this.rowCount*this.colCount ) { false }) {
            acc, rule -> applyRule(acc, rule)
        }.count { it }
    }

    private fun applyRule(acc: BooleanArray, rule: String): BooleanArray {
        val ruleRegex=Regex("(turn on|toggle|turn off) ([0-9]+),([0-9]+) through ([0-9]+),([0-9]+)")
        val match=ruleRegex.find(rule)
        val (verb, startX, startY, endX, endY) = match!!.destructured

        val start=Pair(startX.toInt(), startY.toInt())
        val end=Pair(endX.toInt(), endY.toInt())

        return acc.mapIndexed { index: Int, v: Boolean -> when(verb) {
            "turn on" ->  this.set1(v, index, start, end)
            "turn off" -> this.set0(v, index, start, end)
            else ->  this.toggle(v, index, start, end)
        }}.toBooleanArray()
    }

    private fun toggle(v: Boolean, index: Int, start: Pair<Int, Int>, end: Pair<Int, Int>): Boolean {
        return if(isTarget(index, start, end)) {
            !v
        }
        else
            v
    }

    private fun set0(v: Boolean, index: Int, start: Pair<Int, Int>, end: Pair<Int, Int>): Boolean {
        return if(isTarget(index, start, end)) {
            false
        }
        else
            v
    }

    private fun isTarget(index: Int, start: Pair<Int, Int>, end: Pair<Int, Int>): Boolean {
        val position=Pair(index / 1000, index % 1000)
        return (((position.first>=start.first) && (position.first<=end.first)) && ((position.second>=start.second) && (position.second<=end.second)))
    }

    private fun set1(v: Boolean, index: Int, start: Pair<Int, Int>, end: Pair<Int, Int>): Boolean {
        return if(isTarget(index, start, end)) {
            true
        }
        else
            v
    }

    private fun applyRule2(acc: LongArray, rule: String): LongArray {
        val ruleRegex=Regex("(turn on|toggle|turn off) ([0-9]+),([0-9]+) through ([0-9]+),([0-9]+)")
        val match=ruleRegex.find(rule)
        val (verb, startX, startY, endX, endY) = match!!.destructured

        val start=Pair(startX.toInt(), startY.toInt())
        val end=Pair(endX.toInt(), endY.toInt())

        return acc.mapIndexed { index: Int, v: Long -> when(verb) {
            "turn on" ->  this.add1(v, index, start, end)
            "turn off" -> this.remove1(v, index, start, end)
            else ->  this.add2(v, index, start, end)
        }}.toLongArray()
    }

    private fun remove1(v: Long, index: Int, start: Pair<Int, Int>, end: Pair<Int, Int>): Long {
        return if(isTarget(index, start, end)) {
            val new=v-1
            if(new<0)
                0
            else new
        }
        else
            v
    }

    private fun add1(v: Long, index: Int, start: Pair<Int, Int>, end: Pair<Int, Int>): Long {
        return if(isTarget(index, start, end)) {
            v+1
        }
        else
            v
    }

    private fun add2(v: Long, index: Int, start: Pair<Int, Int>, end: Pair<Int, Int>): Long {
        return if(isTarget(index, start, end)) {
            v+2
        }
        else
            v
    }

    private fun countLights(start: Pair<Int, Int>, end: Pair<Int, Int>): Long {
        return (end.first-start.first+1L)*(end.second-start.second+1L)
    }

    fun compute2(data: List<String>): Long {
        return data.fold(LongArray(this.rowCount*this.colCount) {0L}) { acc, rule ->
            this.applyRule2(acc, rule)
        }.sum()
    }

}
