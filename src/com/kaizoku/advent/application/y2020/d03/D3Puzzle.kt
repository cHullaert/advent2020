package com.kaizoku.advent.application.y2020.d03

import com.kaizoku.advent.application.core.Puzzle

class D3Puzzle: Puzzle(
        "2020","03",
    {
        Computer().compute(it.fileData)
    },
    {
        listOf(Pair(1, 1), Pair(3, 1), Pair(5, 1), Pair(7, 1), Pair(1, 2))
            .map {
                    pair -> Computer().compute(it.fileData, pair.first, pair.second)
            }.reduce { acc, i ->  acc * i }
    }
)