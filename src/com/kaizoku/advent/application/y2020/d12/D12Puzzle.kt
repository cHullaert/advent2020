package com.kaizoku.advent.application.y2020.d12

import com.kaizoku.advent.application.core.Puzzle

class D12Puzzle: Puzzle(
        "2020","12",
    {
        Computer().compute(it.fileData)
    },
    {
        Computer().compute2(it.fileData)
    }
)