package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LexicographicallySmallestGeneratedStringTest {
    private val solution = LexicographicallySmallestGeneratedString()

    @Test
    @DisplayName("Example 1: str1=TFTF, str2=ab -> ababa")
    fun testExample1() {
        assertEquals("ababa", solution.generateString("TFTF", "ab"))
    }

    @Test
    @DisplayName("Example 2: str1=TFTF, str2=abc -> empty (conflict)")
    fun testExample2() {
        assertEquals("", solution.generateString("TFTF", "abc"))
    }

    @Test
    @DisplayName("Example 3: str1=F, str2=d -> a")
    fun testExample3() {
        assertEquals("a", solution.generateString("F", "d"))
    }

    @Test
    @DisplayName("Single T: str1=T, str2=abc -> abc")
    fun testSingleT() {
        assertEquals("abc", solution.generateString("T", "abc"))
    }

    @Test
    @DisplayName("All T: str1=TT, str2=aa -> aaa")
    fun testAllTOverlapConsistent() {
        assertEquals("aaa", solution.generateString("TT", "aa"))
    }

    @Test
    @DisplayName("All T with conflict: str1=TT, str2=ab -> empty")
    fun testAllTOverlapConflict() {
        assertEquals("", solution.generateString("TT", "ab"))
    }

    @Test
    @DisplayName("Single F with str2=a: str1=F, str2=a -> b")
    fun testSingleFWithA() {
        assertEquals("b", solution.generateString("F", "a"))
    }

    @Test
    @DisplayName("All F: str1=FF, str2=aa -> result avoids aa at both positions")
    fun testAllF() {
        val result = solution.generateString("FF", "aa")
        assertEquals(3, result.length)
        // word[0..1] != "aa" and word[1..2] != "aa"
        assert(result.substring(0, 2) != "aa")
        assert(result.substring(1, 3) != "aa")
    }

    @Test
    @DisplayName("T then F: str1=TF, str2=ab -> result starts with ab and second window differs")
    fun testTF() {
        val result = solution.generateString("TF", "ab")
        assertEquals(3, result.length)
        assertEquals("ab", result.substring(0, 2))
        assert(result.substring(1, 3) != "ab")
    }

    @Test
    @DisplayName("F then T: str1=FT, str2=ab -> result ends with ab and first window differs")
    fun testFT() {
        val result = solution.generateString("FT", "ab")
        assertEquals(3, result.length)
        assertEquals("ab", result.substring(1, 3))
        assert(result.substring(0, 2) != "ab")
    }

    @Test
    @DisplayName("F with str2=a repeated: str1=FFF, str2=a -> bbb")
    fun testAllFSingleChar() {
        assertEquals("bbb", solution.generateString("FFF", "a"))
    }

    @Test
    @DisplayName("T at non-overlapping positions: str1=TFT, str2=ab -> ababab (len=4), check manually")
    fun testTNonOverlapping() {
        val result = solution.generateString("TFT", "ab")
        assertEquals(4, result.length)
        assertEquals("ab", result.substring(0, 2))
        assertEquals("ab", result.substring(2, 4))
        assert(result.substring(1, 3) != "ab")
    }

    @Test
    @DisplayName("str1=F, str2=b -> a (smallest non-matching)")
    fun testFWithB() {
        assertEquals("a", solution.generateString("F", "b"))
    }

    @Test
    @DisplayName("str1=TT, str2=aba -> overlap consistent, aba prefix matches")
    fun testOverlapConsistentABA() {
        // str2=aba, T at 0 and 1
        // T at 0: word[0..2] = "aba"
        // T at 1: word[1..3] = "aba" -> word[1]='a', word[2]='b', word[3]='a'
        // But from T at 0: word[1]='b', word[2]='a'
        // Conflict: word[1] should be 'b' (from T0) and 'a' (from T1) -> impossible
        assertEquals("", solution.generateString("TT", "aba"))
    }

    @Test
    @DisplayName("str1=TTT, str2=aaa -> aaaaa")
    fun testAllTAllA() {
        assertEquals("aaaaa", solution.generateString("TTT", "aaa"))
    }

    @Test
    @DisplayName("Impossible F: all positions fixed by T and F window matches")
    fun testImpossibleF() {
        // str1=TFT, str2=aa -> len=4
        // T at 0: word[0..1] = "aa"
        // T at 2: word[2..3] = "aa"
        // word = "aaaa"
        // F at 1: word[1..2] = "aa" == "aa" -> must differ, but both positions fixed
        assertEquals("", solution.generateString("TFT", "aa"))
    }

    @Test
    @DisplayName("Long str2 with single F: str1=F, str2=aaaa -> aaab")
    fun testLongStr2SingleF() {
        assertEquals("aaab", solution.generateString("F", "aaaa"))
    }

    @Test
    @DisplayName("str1=FT, str2=a -> word length 2, word[1]='a' fixed, word[0] must make word[0..0]!=a")
    fun testFTSingleChar() {
        val result = solution.generateString("FT", "a")
        assertEquals(2, result.length)
        assertEquals('a', result[1])
        assert(result[0] != 'a')
        assertEquals("ba", result)
    }

    @Test
    @DisplayName("str1=TF, str2=a -> word length 2, word[0]='a' fixed, word[1] must != 'a'")
    fun testTFSingleChar() {
        val result = solution.generateString("TF", "a")
        assertEquals(2, result.length)
        assertEquals('a', result[0])
        assert(result[1] != 'a')
        assertEquals("ab", result)
    }
}
