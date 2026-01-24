package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/minimum-pair-removal-to-sort-array-ii
class MinimumPairRemovalToSortArrayII {
    private data class Node(
        var value: Long,
        val left: Int,
        var prev: Node? = null,
        var next: Node? = null
    )

    private data class PQItem(
        val first: Node,
        val second: Node,
        val cost: Long
    ) : Comparable<PQItem> {
        override fun compareTo(other: PQItem): Int {
            if (this.cost == other.cost) {
                return this.first.left - other.first.left
            }
            return if (this.cost < other.cost) -1 else 1
        }
    }

    fun minimumPairRemoval(nums: IntArray): Int {
        if (nums.size <= 1) return 0

        val pq = PriorityQueue<PQItem>()
        val merged = BooleanArray(nums.size)

        var decreaseCount = 0
        var count = 0

        val head = Node(nums[0].toLong(), 0)
        var current = head

        for (i in 1 until nums.size) {
            val newNode = Node(nums[i].toLong(), i)
            current.next = newNode
            newNode.prev = current
            pq.offer(PQItem(current, newNode, current.value + newNode.value))

            if (nums[i - 1] > nums[i]) {
                decreaseCount++
            }
            current = newNode
        }

        while (decreaseCount > 0) {
            val item = pq.poll() ?: break
            val first = item.first
            val second = item.second
            val cost = item.cost

            if (merged[first.left] || merged[second.left] || first.value + second.value != cost) {
                continue
            }

            count++
            if (first.value > second.value) {
                decreaseCount--
            }

            val prevNode = first.prev
            val nextNode = second.next
            first.next = nextNode
            if (nextNode != null) {
                nextNode.prev = first
            }

            if (prevNode != null) {
                if (prevNode.value > first.value && prevNode.value <= cost) {
                    decreaseCount--
                } else if (prevNode.value <= first.value && prevNode.value > cost) {
                    decreaseCount++
                }

                pq.offer(PQItem(prevNode, first, prevNode.value + cost))
            }

            if (nextNode != null) {
                if (second.value > nextNode.value && cost <= nextNode.value) {
                    decreaseCount--
                } else if (second.value <= nextNode.value && cost > nextNode.value) {
                    decreaseCount++
                }

                pq.offer(PQItem(first, nextNode, cost + nextNode.value))
            }

            first.value = cost
            merged[second.left] = true
        }

        return count
    }
}
