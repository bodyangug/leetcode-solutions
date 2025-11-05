package com.pandus.leetcode.solutions.daily

import java.util.TreeSet

// Reference: https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-ii
class FindXSumOfAllKLongSubarraysII {

    private data class FrequencyItem(val frequency: Int, val value: Int) : Comparable<FrequencyItem> {
        override fun compareTo(other: FrequencyItem): Int {
            return compareValuesBy(this, other, { it.frequency }, { it.value })
        }

        fun toSum(): Long = frequency * value.toLong()
    }

    fun findXSum(nums: IntArray, k: Int, x: Int): LongArray {
        val result = LongArray(nums.size - k + 1)
        val frequencyMap = HashMap<Int, Int>()
        val mostFrequent = TreeSet<FrequencyItem>()
        val lessFrequent = TreeSet<FrequencyItem>()

        var currentSum = 0L

        for (i in nums.indices) {
            currentSum = addElement(nums[i], frequencyMap, mostFrequent, lessFrequent, currentSum, x)

            val windowStart = i - k
            if (windowStart >= 0) {
                currentSum = removeElement(nums[windowStart], frequencyMap, mostFrequent, lessFrequent, currentSum)
            }

            if (windowStart + 1 >= 0) {
                result[windowStart + 1] = currentSum
            }
        }

        return result
    }

    private fun addElement(
        num: Int,
        frequencyMap: HashMap<Int, Int>,
        mostFrequent: TreeSet<FrequencyItem>,
        lessFrequent: TreeSet<FrequencyItem>,
        currentSum: Long,
        x: Int
    ): Long {
        var sum = currentSum
        val previousFrequency = frequencyMap[num] ?: 0
        val previousItem = FrequencyItem(previousFrequency, num)
        val newItem = FrequencyItem(previousFrequency + 1, num)

        if (mostFrequent.size < x || mostFrequent.contains(previousItem)) {
            mostFrequent.remove(previousItem)
            mostFrequent.add(newItem)
            sum += num
        } else {
            lessFrequent.remove(previousItem)
            val minInMostFrequent = mostFrequent.first()

            if (minInMostFrequent < newItem) {
                sum = swapToMostFrequent(newItem, minInMostFrequent, mostFrequent, lessFrequent, sum)
            } else {
                lessFrequent.add(newItem)
            }
        }

        frequencyMap[num] = previousFrequency + 1
        return sum
    }

    private fun removeElement(
        num: Int,
        frequencyMap: HashMap<Int, Int>,
        mostFrequent: TreeSet<FrequencyItem>,
        lessFrequent: TreeSet<FrequencyItem>,
        currentSum: Long
    ): Long {
        var sum = currentSum
        val currentFrequency = frequencyMap[num]!!
        val currentItem = FrequencyItem(currentFrequency, num)
        val newItem = FrequencyItem(currentFrequency - 1, num)

        if (lessFrequent.contains(currentItem)) {
            lessFrequent.remove(currentItem)
            if (currentFrequency > 1) {
                lessFrequent.add(newItem)
            }
        } else {
            if (lessFrequent.isEmpty()) {
                sum = removeFromMostFrequentWithoutSwap(currentItem, newItem, mostFrequent, sum)
            } else {
                val maxInLessFrequent = lessFrequent.last()
                if (maxInLessFrequent > newItem) {
                    sum = swapToLessFrequent(currentItem, newItem, maxInLessFrequent, mostFrequent, lessFrequent, sum)
                } else {
                    mostFrequent.remove(currentItem)
                    if (currentFrequency > 1) {
                        mostFrequent.add(newItem)
                    }
                    sum -= num
                }
            }
        }

        if (currentFrequency == 1) {
            frequencyMap.remove(num)
        } else {
            frequencyMap[num] = currentFrequency - 1
        }

        return sum
    }

    private fun swapToMostFrequent(
        newItem: FrequencyItem,
        minInMostFrequent: FrequencyItem,
        mostFrequent: TreeSet<FrequencyItem>,
        lessFrequent: TreeSet<FrequencyItem>,
        currentSum: Long
    ): Long {
        lessFrequent.add(minInMostFrequent)
        mostFrequent.remove(minInMostFrequent)
        mostFrequent.add(newItem)
        return currentSum - minInMostFrequent.toSum() + newItem.toSum()
    }

    private fun removeFromMostFrequentWithoutSwap(
        currentItem: FrequencyItem,
        newItem: FrequencyItem,
        mostFrequent: TreeSet<FrequencyItem>,
        currentSum: Long
    ): Long {
        mostFrequent.remove(currentItem)
        if (currentItem.frequency > 1) {
            mostFrequent.add(newItem)
        }
        return currentSum - currentItem.value
    }

    private fun swapToLessFrequent(
        currentItem: FrequencyItem,
        newItem: FrequencyItem,
        maxInLessFrequent: FrequencyItem,
        mostFrequent: TreeSet<FrequencyItem>,
        lessFrequent: TreeSet<FrequencyItem>,
        currentSum: Long
    ): Long {
        lessFrequent.remove(maxInLessFrequent)
        if (currentItem.frequency > 1) {
            lessFrequent.add(newItem)
        }
        mostFrequent.remove(currentItem)
        mostFrequent.add(maxInLessFrequent)
        return currentSum - currentItem.toSum() + maxInLessFrequent.toSum()
    }
}
