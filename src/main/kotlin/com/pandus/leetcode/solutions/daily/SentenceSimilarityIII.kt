package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/sentence-similarity-iii
class SentenceSimilarityIII {
    fun areSentencesSimilar(sentence1: String, sentence2: String): Boolean {
        // splits the sentence by delimeter and store in List
        var words1 = sentence1.split(" ")
        var words2 = sentence2.split(" ")

        if (words1.size > words2.size) {
            val temp = words2
            words2 = words1
            words1 = temp
        }
        val m = words1.size
        val n = words2.size

        var i = 0
        var j = m - 1
        var k = 0
        var l = n - 1
        while (i < m && k < n && words1[i] == words2[k]) {
            i++
            k++
        }
        while (j >= 0 && l >= 0 && words1[j] == words2[l]) {
            j--
            l--
        }
        return i > j
    }
}
