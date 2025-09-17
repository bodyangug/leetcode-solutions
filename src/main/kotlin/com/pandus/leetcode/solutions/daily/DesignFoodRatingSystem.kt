package com.pandus.leetcode.solutions.daily

import java.util.PriorityQueue

// Reference: https://leetcode.com/problems/design-a-food-rating-system
class DesignFoodRatingSystem(foods: Array<String>, cuisines: Array<String>, ratings: IntArray) {

    private val foodToRating = mutableMapOf<String, Int>()
    private val foodToCuisine = mutableMapOf<String, String>()
    private val cuisineToHeap = mutableMapOf<String, PriorityQueue<Pair<String, Int>>>()

    init {
        for (i in foods.indices) {
            val food = foods[i]
            val cuisine = cuisines[i]
            val rating = ratings[i]

            foodToRating[food] = rating
            foodToCuisine[food] = cuisine

            val heap = cuisineToHeap.getOrPut(cuisine) {
                PriorityQueue { a, b ->
                    if (a.second != b.second) {
                        b.second.compareTo(a.second)
                    } else {
                        a.first.compareTo(b.first)
                    }
                }
            }
            heap.offer(food to rating)
        }
    }

    fun changeRating(food: String, newRating: Int) {
        foodToRating[food] = newRating

        val cuisine = foodToCuisine[food] ?: return
        cuisineToHeap[cuisine]?.offer(food to newRating)
    }

    fun highestRated(cuisine: String): String {
        val heap = cuisineToHeap[cuisine] ?: return ""

        while (heap.isNotEmpty()) {
            val (food, rating) = heap.peek()

            if (foodToRating[food] == rating) {
                return food
            }
            heap.poll()
        }
        return ""
    }
}
