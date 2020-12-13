package com.kaizoku.advent.application.y2020.d11

import com.kaizoku.advent.application.core.Puzzle

class D11Puzzle: Puzzle("2020","11",
    {
        Computer().compute(it.fileData)
    },
    {
        Computer().compute2(it.fileData)
    }
)