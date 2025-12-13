package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/coupon-code-validator
class CouponCodeValidator {
    data class Coupon(val code: String, val blRank: Int)

    fun validateCoupons(
        code: Array<String>,
        businessLine: Array<String>,
        isActive: BooleanArray
    ): List<String> {
        val rank = mapOf(
            "electronics" to 0,
            "grocery" to 1,
            "pharmacy" to 2,
            "restaurant" to 3
        )
        val codeRegex = Regex("^[A-Za-z0-9_]+$")

        val n = minOf(code.size, businessLine.size, isActive.size)
        val valid = ArrayList<Coupon>(n)
        for (i in 0 until n) {
            if (!isActive[i]) continue

            val r = rank[businessLine[i]] ?: continue

            val c = code[i]
            if (c.isEmpty()) continue
            if (!codeRegex.matches(c)) continue

            valid.add(Coupon(c, r))
        }
        valid.sortWith(compareBy<Coupon> { it.blRank }.thenBy { it.code })
        return valid.map { it.code }
    }
}
