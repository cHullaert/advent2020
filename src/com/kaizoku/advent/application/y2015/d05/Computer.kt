package com.kaizoku.advent.application.y2015.d05

class Computer {

    fun compute(data: List<String>): Int {
        return data.filter { isNice1(it) }.count()
    }

    private fun isNice1(value: String): Boolean {
        return (value.asIterable().fold(0) {
                    acc, c -> if(c in listOf('a', 'u', 'e', 'i', 'o' )) acc+1 else acc
                } >= 3 )
                && (value.asIterable().zipWithNext().any { it.first==it.second })
                && (!(value.contains("ab")
                || value.contains("cd")
                || value.contains("pq")
                || value.contains("xy")))
    }

    fun compute2(data: List<String>): Int {
        return data.filter { isNice2(it) }.count()
    }

    private fun isNice2(value: String): Boolean {
        val rule1=value.asIterable()
                    .zipWithNext()
                    .withIndex()
                    .groupBy {
                        "${it.value.first}_${it.value.second}"
                    }
                    .any { g -> g.value.map { it.index }
                                       .zipWithNext()
                                       .filter {
                                           v ->
                                               v.first+1 != v.second
                                       }.size > 0 }
        val rule2=value.asIterable()
                        .withIndex()
                        .any { c -> ((c.index+2)<value.length) && (value[c.index+2]==c.value) }

        return rule1 && rule2
    }

}
