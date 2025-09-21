package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/implement-router
class ImplementRouter(
    private val memoryLimit: Int
) {
    data class Packet(val source: Int, val destination: Int, val timestamp: Int)

    private val packetQueue = ArrayDeque<Packet>()
    private val packetSet = HashSet<Packet>()

    // destination -> sorted timestamps (ascending)
    private val byDestination = HashMap<Int, MutableList<Int>>()

    // ----- helpers: lower/upper bound -----
    private fun lowerBound(a: List<Int>, x: Int): Int {
        var l = 0
        var r = a.size
        while (l < r) {
            val m = (l + r) ushr 1
            if (a[m] < x) l = m + 1 else r = m
        }
        return l
    }

    private fun upperBound(a: List<Int>, x: Int): Int {
        var l = 0
        var r = a.size
        while (l < r) {
            val m = (l + r) ushr 1
            if (a[m] <= x) l = m + 1 else r = m
        }
        return l
    }

    private fun insertTimestamp(dest: Int, ts: Int) {
        val list = byDestination.getOrPut(dest) { mutableListOf() }
        val i = lowerBound(list, ts)
        list.add(i, ts) // keeps list sorted
    }

    private fun removeTimestamp(dest: Int, ts: Int) {
        val list = byDestination[dest] ?: return
        val i = lowerBound(list, ts)
        if (i < list.size && list[i] == ts) {
            list.removeAt(i)
            if (list.isEmpty()) byDestination.remove(dest)
        }
    }

    fun addPacket(source: Int, destination: Int, timestamp: Int): Boolean {
        val packet = Packet(source, destination, timestamp)
        if (!packetSet.add(packet)) return false

        // Evict until there is room
        while (packetQueue.size >= memoryLimit) {
            val removed = packetQueue.removeFirst()
            packetSet.remove(removed)
            removeTimestamp(removed.destination, removed.timestamp)
        }

        packetQueue.addLast(packet)
        insertTimestamp(destination, timestamp)
        return true
    }

    fun forwardPacket(): IntArray {
        val packet = packetQueue.removeFirstOrNull() ?: return intArrayOf()
        packetSet.remove(packet)
        removeTimestamp(packet.destination, packet.timestamp)
        return intArrayOf(packet.source, packet.destination, packet.timestamp)
    }

    fun getCount(destination: Int, startTime: Int, endTime: Int): Int {
        if (startTime > endTime) return 0
        val list = byDestination[destination] ?: return 0
        val left = lowerBound(list, startTime)
        val right = upperBound(list, endTime)
        return (right - left).coerceAtLeast(0)
    }
}
