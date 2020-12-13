package com.kaizoku.advent.application.y2020.d08

import com.kaizoku.advent.application.core.Puzzle

class D8Puzzle: Puzzle("2020","08",
    {
        Computer().compute(it.fileData)
    },
    {
        Computer().compute2(it.fileData)
    }
)