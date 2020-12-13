package com.kaizoku.advent.application.y2020.d10

import com.kaizoku.advent.application.core.Puzzle

class D10Puzzle: Puzzle("2020","10",
    {
        Computer().compute(it.fileData)
    },
    {
        Computer().compute2(it.fileData)
    }
)