package com.kaizoku.advent.application.y2020.d07

import com.kaizoku.advent.application.core.Puzzle

class D7Puzzle: Puzzle("2020","07",
    {
        Computer().compute(it.fileData)
    },
    {
        Computer().compute2(it.fileData)
    }
)