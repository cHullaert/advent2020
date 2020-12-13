package com.kaizoku.advent.application.y2020.d03

import com.kaizoku.advent.application.core.Puzzle
import com.kaizoku.advent.application.extensions.pmap

class D3PuzzleConcurrent: Puzzle(
        "2020","03",
    {
        it.fileData.mapIndexed {
            index, value -> Pair(index*3, value)
        }.pmap { line -> line }.filter {
            pair -> Computer().compute(pair.second, pair.first)==1L
        }.count()
    },
    {
        listOf(Pair(1, 1), Pair(3, 1), Pair(5, 1), Pair(7, 1), Pair(1, 2))
            .pmap {
                    pair -> Computer().compute(it.fileData, pair.first, pair.second)
            }.reduce { acc, i ->  acc * i }
    }
)