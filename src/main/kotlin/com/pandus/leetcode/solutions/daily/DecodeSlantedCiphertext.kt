package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/decode-the-slanted-ciphertext
class DecodeSlantedCiphertext {
    fun decodeCiphertext(encodedText: String, rows: Int): String {
        if (encodedText.isEmpty()) return ""
        val cols = encodedText.length / rows
        val result = StringBuilder()
        for (startCol in 0 until cols) {
            var row = 0
            var col = startCol
            while (row < rows && col < cols) {
                result.append(encodedText[row * cols + col])
                row++
                col++
            }
        }
        return result.toString().trimEnd()
    }
}
