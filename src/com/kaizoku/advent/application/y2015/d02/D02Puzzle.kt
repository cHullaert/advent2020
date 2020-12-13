package com.kaizoku.advent.application.y2015.d02

import com.kaizoku.advent.application.core.Puzzle

class D02Puzzle: Puzzle(
        "2015","02",
    {
        Computer().compute(it.fileData)
    },
    {
        Computer().compute2(it.fileData)
    }
)