package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/hand-of-straights
class HandOfStraights {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        if (hand.size % groupSize != 0) {
            return false
        }

        // HashMap to store the count of each card value
        val cardCount = mutableMapOf<Int, Int>()
        for (card in hand) {
            val count = cardCount.getOrDefault(card, 0)
            cardCount[card] = count + 1
        }

        for (card in hand) {
            var startCard = card
            // Find the start of the potential straight sequence
            while (cardCount.getOrDefault(startCard - 1, 0) > 0) {
                startCard--
            }

            // Process the sequence starting from startCard
            while (startCard <= card) {
                while (cardCount.getOrDefault(startCard, 0) > 0) {
                    // Check if we can form a consecutive sequence
                    // of groupSize cards
                    for (nextCard in startCard until startCard + groupSize) {
                        if (cardCount.getOrDefault(nextCard, 0) == 0) {
                            return false
                        }
                        cardCount[nextCard] = cardCount[nextCard]!! - 1
                    }
                }
                startCard++
            }
        }
        return true
    }
}