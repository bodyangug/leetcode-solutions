package com.pandus.leetcode.solutions.daily

import kotlin.math.max

class TrionicArrayII {
    fun maxSumTrionic(nums: IntArray): Long {
        val arraySize = nums.size
        var maxTrionicSum = Long.MIN_VALUE
        var startIndex = 0

        while (startIndex < arraySize) {
            var currentIndex = startIndex + 1
            var currentSegmentSum: Long = 0

            // Phase 1: Find the first strictly increasing segment [startIndex...peakIndex]
            while (currentIndex < arraySize && nums[currentIndex - 1] < nums[currentIndex]) {
                currentIndex++
            }
            val peakIndex = currentIndex - 1

            val noIncreasingSegmentFound = (peakIndex == startIndex)
            if (noIncreasingSegmentFound) {
                startIndex++
                continue
            }

            // Phase 2: Process the strictly decreasing segment [peakIndex...valleyIndex]
            currentSegmentSum += (nums[peakIndex] + nums[peakIndex - 1]).toLong()
            while (currentIndex < arraySize && nums[currentIndex - 1] > nums[currentIndex]) {
                currentSegmentSum += nums[currentIndex].toLong()
                currentIndex++
            }
            val valleyIndex = currentIndex - 1

            val isInvalidTrionicPattern = valleyIndex == peakIndex ||
                    valleyIndex == arraySize - 1 ||
                    (currentIndex < arraySize && nums[currentIndex] <= nums[valleyIndex])

            if (isInvalidTrionicPattern) {
                startIndex = valleyIndex + 1
                continue
            }

            // Phase 3: Process the final strictly increasing segment starting at [valleyIndex+1...]
            currentSegmentSum += nums[valleyIndex + 1].toLong()

            val maxSumFromThirdSegment = calculateMaxExtensionSum(
                nums = nums,
                startPosition = valleyIndex + 2,
                isForward = true
            )
            currentSegmentSum += maxSumFromThirdSegment

            // Phase 4: Optionally extend the first segment backwards for maximum sum
            val maxSumFromFirstSegment = calculateMaxExtensionSum(
                nums = nums,
                startPosition = peakIndex - 2,
                isForward = false,
                endBound = startIndex
            )
            currentSegmentSum += maxSumFromFirstSegment

            maxTrionicSum = max(maxTrionicSum, currentSegmentSum)
            startIndex = valleyIndex
        }

        return maxTrionicSum
    }

    private fun calculateMaxExtensionSum(
        nums: IntArray,
        startPosition: Int,
        isForward: Boolean,
        endBound: Int = 0
    ): Long {
        var maxSum: Long = 0
        var runningSum: Long = 0
        if (isForward) {
            var position = startPosition
            while (position < nums.size && nums[position] > nums[position - 1]) {
                runningSum += nums[position].toLong()
                maxSum = max(maxSum, runningSum)
                position++
            }
        } else {
            for (position in startPosition downTo endBound) {
                runningSum += nums[position].toLong()
                maxSum = max(maxSum, runningSum)
            }
        }
        return maxSum
    }
}
