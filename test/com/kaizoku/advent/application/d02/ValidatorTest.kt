package com.kaizoku.advent.application.d02

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ValidatorTest {

    @Test
    fun isValid() {
        val validator = Validator()
        assertTrue(validator.isValid("1-3 a: abcde"))
        assertFalse(validator.isValid("1-3 b: cdefg"))
        assertTrue(validator.isValid("2-9 c: ccccccccc"))
    }

    @Test
    fun isValid2() {
        val validator = Validator()
        assertTrue(validator.isValid2("1-3 a: abcde"))
        assertFalse(validator.isValid2("1-3 b: cdefg"))
        assertFalse(validator.isValid2("2-9 c: ccccccccc"))
    }
}