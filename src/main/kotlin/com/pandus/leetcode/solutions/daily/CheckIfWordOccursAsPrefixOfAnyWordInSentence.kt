package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence
class CheckIfWordOccursAsPrefixOfAnyWordInSentence {
    fun isPrefixOfWord(sentence: String, searchWord: String): Int {
        val lenW = searchWord.length
        var pos = 0
        var numb = 1
        var ind = true
        for (ch in sentence)
            if (ch == ' ') {
                numb++
                ind = true
                pos = 0
            } else {
                if (ind) {
                    if (ch == searchWord[pos])
                        if (pos == lenW - 1) return numb
                        else if (pos < lenW - 1) pos++
                        else ind = false
                    else ind = false
                }
            }
        return -1
    }
}
