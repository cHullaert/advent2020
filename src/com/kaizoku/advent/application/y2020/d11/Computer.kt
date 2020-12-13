package com.kaizoku.advent.application.y2020.d11

class Computer {

    fun compute(data: List<String>): Int {
        return countSeats(doRound(data, 0, 0, 4, false).second)
    }

    private fun countSeats(data: List<String>): Int {
        return data.flatMap {
            it.asIterable()
        }.filter { it == '#' }.count()

    }

    private fun doRound(data: List<String>, maxIteration: Int, iteration: Int, tolerance: Int, recursive: Boolean): Pair<Int, List<String>> {
        if((maxIteration!=0) && (iteration<0))
            return Pair(iteration, data)

        val result=data.mapIndexed {
            index, value ->  Pair(index, value)
        }.flatMap {
            it.second.mapIndexed() {
                index, c -> Triple(it.first, index, c)
            }
        }.map {
            transform(it, data, tolerance, recursive)
        }.groupBy {
            it.first
        }.map {
            Pair(it.value.map { v -> v.third.first }.fold(0) {
                acc, value ->  if(value) acc+1 else acc
            }, it.value.map { v -> v.third.second }.joinToString("") )
        }.fold(Pair<Int, List<String>>(0, emptyList())) {
            acc, value -> Pair(acc.first+value.first, acc.second+value.second)
        }

        if (result.first>0) {
            return doRound(result.second, maxIteration, iteration+1, tolerance, recursive)
        }

        return result
    }

    private fun transform(c: Triple<Int, Int, Char>, data: List<String>, tolerance: Int, recursive: Boolean): Triple<Int, Int, Pair<Boolean, Char>> {
        return when(c.third) {
            'L'-> {
                if(count(c, data, '#', recursive)==0) {
                    Triple(c.first, c.second, Pair(true, '#'))
                } else
                    Triple(c.first, c.second, Pair(false, 'L'))
            }
            '#'-> {
                if(count(c, data, '#', recursive)>=tolerance) {
                    Triple(c.first, c.second, Pair(true, 'L'))
                } else
                    Triple(c.first, c.second, Pair(false, '#'))
            }
            else -> Triple(c.first, c.second, Pair(false, '.'))
        }
    }

    private fun count(c: Triple<Int, Int, Char>, data: List<String>, value: Char, recursive: Boolean): Int {
        val position=Pair(c.first, c.second)

        return listOf(getChar(data, position, Pair(-1, -1), recursive),
                getChar(data, position, Pair(-1, 0), recursive),
                getChar(data, position, Pair(-1, 1), recursive),
                getChar(data, position, Pair(0, -1), recursive),
                getChar(data, position, Pair(0, 1), recursive),
                getChar(data, position, Pair(1, -1), recursive),
                getChar(data, position, Pair(1, 0), recursive),
                getChar(data, position, Pair(1, 1), recursive)).filter {it == value}.count()
    }

    private fun getChar(data: List<String>, position: Pair<Int, Int>, offset: Pair<Int, Int>, recursive: Boolean): Char {
        val p = Pair(position.first+offset.first, position.second+offset.second)

        if((p.first>=0) && (p.first<data.size)) {
            if((p.second>=0) && (p.second<data[p.first].length)) {
                val c =data[p.first][p.second]
                return if((c=='.') && (recursive)) {
                    getChar(data, p, offset, recursive)
                } else
                    c
            }
        }

        return '.'
    }

    fun compute2(data: List<String>): Int {
        return countSeats(doRound(data, 0, 0, 5, true).second)
    }
}
