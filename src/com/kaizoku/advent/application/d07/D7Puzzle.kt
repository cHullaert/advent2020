package com.kaizoku.advent.application.d07

import com.kaizoku.advent.application.core.Puzzle

class D7Puzzle: Puzzle("07",
    {
        Computer().compute(it.fileData)
    },
    {
        Computer().compute2(it.fileData)
    }
)