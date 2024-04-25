package com.pandus.leetcode.solutions.daily

import java.util.LinkedList
import java.util.Queue


//Reference:https://leetcode.com/problems/reveal-cards-in-increasing-order
class RevealCardsInIncreasingOrder {
    fun deckRevealedIncreasing(deck: IntArray): IntArray {
        val queue: Queue<Int> = LinkedList()
        deck.indices.forEach { queue.add(it) }
        deck.sort()

        return IntArray(deck.size).apply {
            for (i in deck.indices) {
                this[queue.poll()] = deck[i]
                queue.add(queue.poll())
            }
        }
    }
}
