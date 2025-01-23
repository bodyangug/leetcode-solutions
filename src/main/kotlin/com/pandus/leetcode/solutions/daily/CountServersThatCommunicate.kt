package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-servers-that-communicate
class CountServersThatCommunicate {
    fun countServers(g: Array<IntArray>) = g
        .flatMap { r -> r.indices.map { r to it }}
        .count { (r, x) -> r[x] * g.sumOf { it[x] } * r.sum() > 1 }
}
