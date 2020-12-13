package com.kaizoku.advent.application.y2015.d03

import com.kaizoku.advent.application.core.Puzzle

class D03Puzzle: Puzzle(
        "2015","03",
    {
        Computer().compute(it.fileData)
    },
    {
        Computer().compute2(it.fileData)
    }
)