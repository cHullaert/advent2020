package com.kaizoku.advent.application.y2015.d01

import com.kaizoku.advent.application.core.Puzzle

class D01Puzzle: Puzzle("2015","01",
    {
        Computer().compute(it.fileData)
    },
    {
        Computer().compute2(it.fileData)
    }
)