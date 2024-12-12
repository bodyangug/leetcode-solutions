package com.pandus.leetcode.solutions.daily

import java.util.PriorityQueue
import kotlin.math.floor
import kotlin.math.sqrt

// Reference: https://leetcode.com/problems/take-gifts-from-the-richest-pile
class TakeGiftsFromTheRichestPile {
    fun pickGifts(gifts: IntArray, k: Int): Long {
        val pq = PriorityQueue(gifts.map { -it.toDouble() })
        for (i in 1..k) pq += -floor(sqrt(-pq.poll()))
        return -pq.sum().toLong()
    }
}
