package com.kaizoku.advent.application.y2015.d04

import java.math.BigInteger
import java.security.MessageDigest

class Computer {

    fun compute(data: List<String>): Int {
        return computeNumber(data, "00000")
    }

    private fun computeNumber(data: List<String>, leading: String): Int {

        var current = 0
        do {
            val md = MessageDigest.getInstance("MD5")
            val md5 = BigInteger(1, md.digest("${data[0]}$current".toByteArray())).toString(16).padStart(32, '0').toString()
            if (md5.startsWith(leading)) {
                return current
            }
            current++
        } while (true)
    }

    fun compute2(data: List<String>): Int {
        return computeNumber(data, "000000")
    }

}
