package com.kaizoku.advent.application.y2020.d09

import com.kaizoku.advent.application.core.Puzzle

class D9Puzzle: Puzzle("2020","09",
    {
        Computer().compute(it.fileData)
    },
    {
        Computer().compute2(it.fileData)
    }
)