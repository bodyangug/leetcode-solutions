package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/lexicographically-smallest-generated-string
class LexicographicallySmallestGeneratedString {

    fun generateString(str1: String, str2: String): String {
        val n = str1.length
        val m = str2.length
        val s = CharArray(n + m - 1) { 'a' }
        val fixed = IntArray(n + m - 1)

        for (i in 0 until n) {
            if (str1[i] == 'T') {
                for (j in i until i + m) {
                    if (fixed[j] == 1 && s[j] != str2[j - i]) {
                        return ""
                    } else {
                        s[j] = str2[j - i]
                        fixed[j] = 1
                    }
                }
            }
        }

        for (i in 0 until n) {
            if (str1[i] == 'F') {
                var flag = false
                var idx = -1
                for (j in i + m - 1 downTo i) {
                    if (str2[j - i] != s[j]) {
                        flag = true
                    }
                    if (idx == -1 && fixed[j] == 0) {
                        idx = j
                    }
                }
                if (flag) {
                    continue
                } else if (idx != -1) {
                    s[idx] = 'b'
                } else {
                    return ""
                }
            }
        }

        return String(s)
    }
}
