package com.kaizoku.advent.application.y2020.d13

import com.kaizoku.advent.application.core.Puzzle

class D13Puzzle: Puzzle(
        "2020","13",
    {
        Computer().compute(it.fileData)
    },
    {
        Computer().compute2(it.fileData)
    }
)