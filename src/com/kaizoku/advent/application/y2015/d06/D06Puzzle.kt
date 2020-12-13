package com.kaizoku.advent.application.y2015.d06

import com.kaizoku.advent.application.core.Puzzle

class D06Puzzle: Puzzle(
        "2015","06",
    {
        Computer().compute(it.fileData)
    },
    {
        Computer().compute2(it.fileData)
    }
)