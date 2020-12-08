package com.kaizoku.advent.application.d04

import com.kaizoku.advent.application.extensions.splitBy

class Computer {
    private fun getPassports(list: List<String>): List<Map<String, String>> {
        return list.splitBy { it.isBlank() }.map { getPassport(it) }
    }

    private fun getPassport(lines: List<String>): Map<String, String> {
        return lines.flatMap {
            it.split(" ")
        }.map {
            val array = it.split(":")
            array[0] to array[1]
        }.toMap()
    }

    fun compute(passports: List<String>): Int {
        return getPassports(passports).filter {
            isValidPassport(it)
        }.count()
    }

    fun compute2(passports: List<String>): Int {
        return getPassports(passports).filter {
            isValidPassport2(it)
        }.count()
    }

    private fun isValidPassport(it: Map<String, String>): Boolean {
        return (it.values.count()==8) || ((it.values.count()==7) && (!it.containsKey("cid")))
    }

    private fun isValidPassport2(it: Map<String, String>): Boolean {
        if(isValidPassport(it)) {
            return checkBetween(it["byr"], 1920, 2002)
                    && (checkBetweenRegex(it["hgt"], "([0-9]+)cm", 150, 193) || checkBetweenRegex(it["hgt"], "([0-9]+)in", 59, 76))
                    && checkBetween(it["iyr"], 2010, 2020)
                    && checkBetween(it["eyr"], 2020, 2030)
                    && checkRegex(it["hcl"], "#[0-9a-f]{6}")
                    && checkRegex(it["pid"], "[0-9]{9}")
                    && checkRegex(it["ecl"], "amb|blu|brn|gry|grn|hzl|oth")
        }

        return false
    }

    private fun checkBetweenRegex(value: String?, regex: String, min: Int, max: Int): Boolean {
        val insureValue=value!!
        val result=Regex(regex).find(insureValue)

        if(result!=null) {
            val (size)=result.destructured
            return checkBetween(size, min, max)
        }

        return false
    }

    private fun checkRegex(value: String?, regex: String): Boolean {
        val insureValue=value!!
        return Regex(regex).matches(insureValue)

    }

    private fun checkBetween(value: String?, min: Int, max: Int): Boolean {
        val insureValue=value!!
        return insureValue.toInt() in (min..max)
    }
}