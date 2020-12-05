package com.kaizoku.advent.application.d05

import com.kaizoku.advent.application.core.Puzzle

class D5Puzzle: Puzzle("05",
    {
        Computer().compute(it.fileData)
    },
    {
        Computer().compute2(it.fileData)
    }
)