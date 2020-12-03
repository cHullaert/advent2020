package com.kaizoku.advent.application.d02

import com.kaizoku.advent.application.core.Puzzle

class D2Puzzle: Puzzle("02",
    {
        it.fileData.filter { password -> Computer().compute(password) }.count()
    },
    {
        it.fileData.filter { password -> Computer().compute2(password) }.count()
    }
)