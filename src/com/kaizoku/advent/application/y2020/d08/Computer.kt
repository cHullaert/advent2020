package com.kaizoku.advent.application.y2020.d08

class Computer {
    fun compute(data: List<String>): Int {
        return nextInstruction(data, emptyList(), 0, 0) {_,expression -> expression } .second
    }

    private fun nextInstruction(data: List<String>, stack: List<Int>, ip: Int, acc: Int, hack: (Int, String)->String): Pair<Int, Int> {
        if(ip>=data.size)
            return Pair(1, acc)

        val regex=Regex("(nop|jmp|acc)\\s((\\+|\\-)[0-9]+)")
        val match=regex.find(data[ip])
        val (expression, value, sign)=match!!.destructured

        if(stack.contains(ip))
            return Pair(0, acc)

        return when(hack(ip, expression)) {
            "nop" -> nextInstruction(data, stack+ip, ip+1, acc, hack)
            "jmp" -> nextInstruction(data, stack+ip, ip+value.toInt(), acc, hack)
            "acc" -> nextInstruction(data, stack+ip, ip+1, acc+value.toInt(), hack)
            else -> Pair(0, 0)
        }
      }

    fun compute2(data: List<String>): Int {

        var current=-1
        var pair=Pair(0, 0)
        do {
            current++
            pair=nextInstruction(data, emptyList(), 0, 0) {
                ip, expression -> if(ip==current) {
                    when(expression) {
                        "jmp" -> "nop"
                        "nop" -> "jmp"
                        else -> expression
                    }
                }
                else expression
            }
        }
        while (pair.first==0)
        return pair.second
    }
}
