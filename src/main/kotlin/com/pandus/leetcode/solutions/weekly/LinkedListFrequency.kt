package com.pandus.leetcode.solutions.weekly

import com.pandus.leetcode.solutions.model.ListNode


//Reference: https://leetcode.com/problems/linked-list-frequency
class LinkedListFrequency {
    fun frequenciesOfElements(head: ListNode?): ListNode? {
        val maxValue = 100000 // Maximum element value
        val frequencies = IntArray(maxValue)
        var current = head

        while (current != null) {
            frequencies[current.`val` - 1]++
            current = current.next
        }

        val freqHead = ListNode(0)
        current = freqHead
        for (i in 0 until maxValue) {
            if (frequencies[i] > 0) {
                current!!.next = ListNode(frequencies[i])
                current = current.next
            }
        }
        return freqHead.next
    }
}