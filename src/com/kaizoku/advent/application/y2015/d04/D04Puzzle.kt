package com.kaizoku.advent.application.y2015.d04

import com.kaizoku.advent.application.core.Puzzle

class D04Puzzle: Puzzle(
        "2015","04",
    {
        Computer().compute(it.fileData)
    },
    {
        Computer().compute2(it.fileData)
    }
)