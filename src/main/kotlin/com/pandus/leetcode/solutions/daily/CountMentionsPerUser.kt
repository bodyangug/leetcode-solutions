package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/count-mentions-per-user
class CountMentionsPerUser {
    data class E(val type: String, val t: Long, val a: String, val idx: Int)
    data class ComeBack(val time: Long, val id: Int)

    fun countMentions(numberOfUsers: Int, events: List<List<String>>): IntArray {
        // Parse + stable sort by (timestamp asc, OFFLINE before MESSAGE, original order)
        val parsed = events.mapIndexed { idx, e ->
            E(e[0], e[1].toLong(), e[2], idx)
        }.sortedWith(compareBy<E>({ it.t }, { if (it.type == "OFFLINE") 0 else 1 }, { it.idx }))

        val offlineUntil = LongArray(numberOfUsers) { 0L }
        val isOnline = BooleanArray(numberOfUsers) { true }

        var allTotal = 0L
        var hereTotal = 0L

        val hereStart = LongArray(numberOfUsers) { 0L }
        val hereMentions = LongArray(numberOfUsers) { 0L }
        val idMentions = LongArray(numberOfUsers) { 0L }

        val pq = PriorityQueue(compareBy<ComeBack> { it.time })

        fun processComeBacks(upToTime: Long) {
            while (pq.isNotEmpty() && pq.peek().time <= upToTime) {
                val (time, id) = pq.poll()
                // Ignore outdated heap entries
                if (!isOnline[id] && offlineUntil[id] == time) {
                    isOnline[id] = true
                    hereStart[id] = hereTotal
                }
            }
        }

        for (ev in parsed) {
            processComeBacks(ev.t)

            when (ev.type) {
                "OFFLINE" -> {
                    val id = ev.a.toInt()
                    val newUntil = ev.t + 60L

                    if (isOnline[id]) {
                        // Settle HERE mentions accrued while online up to now
                        hereMentions[id] += (hereTotal - hereStart[id])
                        isOnline[id] = false
                    }

                    // Extend offline window if needed
                    if (newUntil > offlineUntil[id]) {
                        offlineUntil[id] = newUntil
                        pq.add(ComeBack(newUntil, id))
                    } else {
                        // Still push is optional; we can skip. Keeping it simple:
                        pq.add(ComeBack(offlineUntil[id], id))
                    }
                }

                "MESSAGE" -> {
                    val s = ev.a.trim()
                    if (s.isEmpty()) continue

                    val tokens = s.split(Regex("\\s+"))
                    for (tok in tokens) {
                        when {
                            tok == "ALL" -> allTotal++
                            tok == "HERE" -> hereTotal++
                            tok.startsWith("id") -> {
                                val id = tok.substring(2).toInt()
                                idMentions[id]++
                            }

                            else -> {
                                // If input is guaranteed valid, this won't happen.
                                // Ignoring unknown tokens safely.
                            }
                        }
                    }
                }

                else -> {
                    // Ignore unknown event types safely
                }
            }
        }

        // Finalize: settle HERE mentions for users still online
        for (i in 0 until numberOfUsers) {
            if (isOnline[i]) {
                hereMentions[i] += (hereTotal - hereStart[i])
            }
        }

        // Build answer
        val ans = IntArray(numberOfUsers)
        for (i in 0 until numberOfUsers) {
            val total = idMentions[i] + hereMentions[i] + allTotal
            ans[i] = total.toInt()
        }
        return ans
    }
}
