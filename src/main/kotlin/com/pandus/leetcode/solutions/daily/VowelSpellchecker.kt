package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/vowel-spellchecker
class VowelSpellchecker {
    private val wordsPerfect: MutableSet<String> = HashSet()
    private val wordsCap: MutableMap<String, String> = HashMap()
    private val wordsVow: MutableMap<String, String> = HashMap()

    fun spellchecker(wordlist: Array<String>, queries: Array<String>): Array<String> {
        for (word in wordlist) {
            wordsPerfect.add(word)

            val wordLow = word.lowercase()
            wordsCap.putIfAbsent(wordLow, word)

            val wordLowDV = devowel(wordLow)
            wordsVow.putIfAbsent(wordLowDV, word)
        }

        return queries.mapNotNull { solve(it) }.toTypedArray()
    }

    private fun solve(query: String): String? {
        if (wordsPerfect.contains(query)) return query

        val queryL = query.lowercase()
        if (wordsCap.containsKey(queryL)) return wordsCap[queryL]

        val queryLV = devowel(queryL)
        if (wordsVow.containsKey(queryLV)) return wordsVow[queryLV]

        return ""
    }

    private fun devowel(word: String): String {
        val ans = StringBuilder()
        for (c in word.toCharArray()) ans.append(if (isVowel(c)) '*' else c)
        return ans.toString()
    }

    private fun isVowel(c: Char): Boolean {
        return c in arrayOf('a', 'e', 'i', 'o', 'u')
    }
}
