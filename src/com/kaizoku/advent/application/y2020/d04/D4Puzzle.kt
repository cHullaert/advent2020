package com.kaizoku.advent.application.y2020.d04

import com.kaizoku.advent.application.core.Puzzle

class D4Puzzle: Puzzle("2020","04",
    {
        Computer().compute(it.fileData)
    },
    {
        Computer().compute2(it.fileData)
    })
