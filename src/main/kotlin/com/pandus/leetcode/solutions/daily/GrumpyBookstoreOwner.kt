package com.pandus.leetcode.solutions.daily

import kotlin.math.max

//Reference: https://leetcode.com/problems/grumpy-bookstore-owner
class GrumpyBookstoreOwner {
    fun maxSatisfied(customers: IntArray, grumpy: IntArray, minutes: Int): Int {
        val n = customers.size
        var unrealizedCustomers = 0

        // Calculate initial number of unrealized customers in first 'minutes' window
        for (i in 0 until minutes) {
            unrealizedCustomers += customers[i] * grumpy[i]
        }

        var maxUnrealizedCustomers = unrealizedCustomers

        // Slide the 'minutes' window across the rest of the customers array
        for (i in minutes until n) {
            // Add the current minute's unsatisfied customers if the owner is grumpy
            // and remove the customers that are out of the current window
            unrealizedCustomers += customers[i] * grumpy[i]
            unrealizedCustomers -= customers[i - minutes] * grumpy[i - minutes]

            // Update the maximum unrealized customers
            maxUnrealizedCustomers = max(
                maxUnrealizedCustomers.toDouble(),
                unrealizedCustomers.toDouble()
            ).toInt()
        }

        // Start with maximum possible satisfied customers due to secret technique
        var totalCustomers = maxUnrealizedCustomers

        // Add the satisfied customers during non-grumpy minutes
        for (i in customers.indices) {
            totalCustomers += customers[i] * (1 - grumpy[i])
        }

        // Return the maximum number of satisfied customers
        return totalCustomers
    }
}