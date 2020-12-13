package com.kaizoku.advent.application.y2020.d07

import com.kaizoku.advent.application.extensions.mergeReduce

class Computer {
    private val bagRegex: Regex by lazy {
        Regex("([0-9])+\\s([a-z\\s]+)\\sbags?")
    }
    private val lineRegex: Regex by lazy {
        Regex("([a-z\\s]+)\\sbags\\scontain(((\\s(([0-9]+\\s[a-z\\s]+)|(no other)))\\sbags?[,\\.])+)")
    }

    private fun parse(line: String): Pair<String, Map<String, Int>> {
        val matchResult = lineRegex.find(line)
        return matchResult!!.groupValues[1] to parseBags(matchResult.groupValues[2])
    }

    private fun parseBags(bags: String): Map<String, Int> {
        return bags.split(",", ".").map {
                                                it.trim()
                                            }
                .filter { it.isNotBlank() }
                .map {
                    if(it=="no other bags")
                        "empty" to 0
                    else {
                        val matchResult = bagRegex.find(it)
                        matchResult!!.groupValues[2] to matchResult.groupValues[1].toInt()
                    }
                }.filter {
                    it.first != "empty"
                }.toMap()
    }

    private fun getUsefulBags(bags: Map<String, Map<String, Int>>, color: String): Map<String, Map<String, Int>> {

        val availableBags=bags.filter { it.value.containsKey(color) }

        val subBags=availableBags.map {
            getUsefulBags(bags, it.key)
        }

        return subBags.fold(availableBags) {
            acc, bag -> acc.mergeReduce(bag) { _, value, value2 -> value ?: value2!! }
        }
    }

    fun compute(data: List<String>): Int {
        val bags=data.map {
            parse(it)
        }.toMap()

        return getUsefulBags(bags, "shiny gold").count()
    }

    fun compute2(data: List<String>): Int {
        val bags=data.map {
            parse(it)
        }.toMap()

        return getInsideBags(bags, bags["shiny gold"] ?: error("should have a shiny gold bag :-)"))-1
    }

    private fun getInsideBags(bags: Map<String, Map<String, Int>>, bag: Map<String, Int>): Int {
        return bag.map {
            getInsideBags(bags, bags[it.key] ?: error("should have a ${it.key} bag :-)"))*it.value
        }.sum()+1
    }
}

