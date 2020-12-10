package com.kaizoku.advent.application.d09

import com.kaizoku.advent.application.core.Puzzle

class D9Puzzle: Puzzle("09",
    {
        Computer().compute(it.fileData)
    },
    {
        Computer().compute2(it.fileData)
    }
)