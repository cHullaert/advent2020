package com.kaizoku.advent.application.d01

import com.kaizoku.advent.application.core.Puzzle
import com.kaizoku.advent.application.extensions.numbers


class D1Puzzle: Puzzle("01",
    {
        Computer().compute(it.numbers)
    },
    {
        Computer().compute3(it.numbers)
    })