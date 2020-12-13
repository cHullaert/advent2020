package com.kaizoku.advent.application.y2020.d06

import com.kaizoku.advent.application.core.Puzzle

class D6Puzzle: Puzzle("2020","06",
    {
        Computer().compute(it.fileData)
    },
    {
        Computer().compute2(it.fileData)
    }
)