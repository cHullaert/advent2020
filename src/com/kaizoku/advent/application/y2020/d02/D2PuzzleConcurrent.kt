package com.kaizoku.advent.application.y2020.d02

import com.kaizoku.advent.application.core.Puzzle
import com.kaizoku.advent.application.extensions.pmap

class D2PuzzleConcurrent: Puzzle("2020","02",
    {
        it.fileData.pmap { line -> line }.filter { password -> Computer().compute(password) }.count()
    },
    {
        it.fileData.pmap { line -> line }.filter { password -> Computer().compute2(password) }.count()
    }
)