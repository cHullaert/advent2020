package com.kaizoku.advent.application.y2015.d05

import com.kaizoku.advent.application.core.Puzzle

class D05Puzzle: Puzzle(
        "2015","05",
    {
        Computer().compute(it.fileData)
    },
    {
        Computer().compute2(it.fileData)
    }
)