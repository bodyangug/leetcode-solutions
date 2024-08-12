package com.pandus.leetcode.solutions.daily

import java.util.PriorityQueue

//Reference: https://leetcode.com/problems/kth-largest-element-in-a-stream
class KthLargestElementInStream(k: Int, nums: IntArray) {

    private val k = k
    private val minHeap: PriorityQueue<Int> = PriorityQueue(nums.toList())

    init {
        if (minHeap.size > k) {
            for (i in 0 until minHeap.size - k) {
                minHeap.poll()
            }
        }
    }

    fun add(`val`: Int): Int {
        minHeap.add(`val`)
        if (minHeap.size > k) {
            minHeap.poll()
        }
        return minHeap.peek()
    }


}