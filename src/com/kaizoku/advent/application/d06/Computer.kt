package com.kaizoku.advent.application.d06

import com.kaizoku.advent.application.extensions.splitBy

class Computer {
    fun compute(data: List<String>): Int {
        val groups=data.splitBy { it.isBlank() }
        return groups.map {
            computeGroup(it)
        }.sum()
    }

    private fun computeGroup(group: List<String>): Int {
        return group.flatMap {
            it.asSequence().toList()
        }.groupBy { it }.count()
    }

    private fun computeGroup2(group: List<String>): Int {
        return group.flatMap {
            it.asSequence().toList()
        }.groupBy { it }.filter { it.value.count()==group.count() }.count()
    }

    fun compute2(data: List<String>): Int {
        val groups=data.splitBy { it.isBlank() }
        return groups.map {
            computeGroup2(it)
        }.sum()
    }
}
