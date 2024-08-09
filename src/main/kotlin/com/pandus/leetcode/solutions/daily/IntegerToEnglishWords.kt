package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/integer-to-english-words
class IntegerToEnglishWords {
    private val belowTen = arrayOf("", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine")
    private val belowTwenty = arrayOf(
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    )
    private val belowHundred =
        arrayOf("", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")

    fun numberToWords(num: Int): String {
        return if (num == 0) "Zero" else convertToWords(num)
    }

    private fun convertToWords(num: Int): String {
        return when {
            num < 10 -> belowTen[num]
            num < 20 -> belowTwenty[num - 10]
            num < 100 -> belowHundred[num / 10] + if (num % 10 != 0) " ${convertToWords(num % 10)}" else ""
            num < 1000 -> "${convertToWords(num / 100)} Hundred" + if (num % 100 != 0) " ${convertToWords(num % 100)}" else ""
            num < 1000000 -> "${convertToWords(num / 1000)} Thousand" + if (num % 1000 != 0) " ${convertToWords(num % 1000)}" else ""
            num < 1000000000 -> "${convertToWords(num / 1000000)} Million" + if (num % 1000000 != 0) " ${
                convertToWords(
                    num % 1000000
                )
            }" else ""

            else -> "${convertToWords(num / 1000000000)} Billion" + if (num % 1000000000 != 0) " ${convertToWords(num % 1000000000)}" else ""
        }
    }
}