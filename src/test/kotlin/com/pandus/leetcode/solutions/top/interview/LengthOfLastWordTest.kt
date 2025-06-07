package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LengthOfLastWordTest {
    @Test
    fun lengthOfLastWord_returnsCorrectLength_positiveCase() {
        val solution = LengthOfLastWord()
        assertEquals(5, solution.lengthOfLastWord("Hello World"))
    }
}
