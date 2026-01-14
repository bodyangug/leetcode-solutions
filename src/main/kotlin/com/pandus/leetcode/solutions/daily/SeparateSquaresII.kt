package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/separate-squares-ii
class SeparateSquaresII {
    private data class Event(
        val y: Int,
        val type: EventType,
        val xStart: Int,
        val xEnd: Int
    )

    private enum class EventType(val value: Int) {
        SQUARE_START(1),
        SQUARE_END(-1)
    }

    private data class AreaSegment(
        val yStart: Int,
        val height: Int,
        val width: Int
    ) {
        val area: Long get() = height.toLong() * width
    }

    fun separateSquares(squares: Array<IntArray>): Double {
        val events = buildEvents(squares)
        val areaSegments = calculateAreaSegments(events)

        val totalArea = areaSegments.sumOf { it.area }
        val halfArea = totalArea / 2.0

        return findSeparationLine(areaSegments, halfArea)
    }

    private fun buildEvents(squares: Array<IntArray>): List<Event> {
        val events = mutableListOf<Event>()

        for ((x, y, sideLength) in squares) {
            events.add(Event(y, EventType.SQUARE_START, x, x + sideLength))
            events.add(Event(y + sideLength, EventType.SQUARE_END, x, x + sideLength))
        }

        return events.sortedBy { it.y }
    }

    private fun calculateAreaSegments(events: List<Event>): List<AreaSegment> {
        val areaSegments = mutableListOf<AreaSegment>()
        val activeIntervals = mutableListOf<Pair<Int, Int>>()
        var previousY = events.first().y

        for (event in events) {
            if (event.y > previousY && activeIntervals.isNotEmpty()) {
                val height = event.y - previousY
                val width = calculateUnionLength(activeIntervals)
                areaSegments.add(AreaSegment(previousY, height, width))
            }

            when (event.type) {
                EventType.SQUARE_START -> activeIntervals.add(event.xStart to event.xEnd)
                EventType.SQUARE_END -> activeIntervals.remove(event.xStart to event.xEnd)
            }

            previousY = event.y
        }

        return areaSegments
    }

    private fun calculateUnionLength(intervals: List<Pair<Int, Int>>): Int {
        if (intervals.isEmpty()) return 0

        val sortedIntervals = intervals.sortedBy { it.first }
        var totalLength = 0
        var currentEnd = Int.MIN_VALUE

        for ((start, end) in sortedIntervals) {
            when {
                start > currentEnd -> {
                    totalLength += end - start
                    currentEnd = end
                }

                end > currentEnd -> {
                    totalLength += end - currentEnd
                    currentEnd = end
                }
            }
        }

        return totalLength
    }

    private fun findSeparationLine(areaSegments: List<AreaSegment>, targetArea: Double): Double {
        var accumulatedArea = 0.0

        for (segment in areaSegments) {
            val segmentArea = segment.area.toDouble()

            if (accumulatedArea + segmentArea >= targetArea) {
                val remainingArea = targetArea - accumulatedArea
                return segment.yStart + (remainingArea / segment.width)
            }

            accumulatedArea += segmentArea
        }
        return 0.0
    }
}
