package com.pandus.advent.of.code.twenty.five

import java.util.*

// Reference: https://adventofcode.com/2025/day/10
class Day10 {

    data class Machine(
        val lightDiagram: List<Int>,
        val buttonSchematics: List<List<Int>>,
        val joltageRequirements: List<Int>
    )

    data class Button(
        val idxs: IntArray,
        val size: Int
    )

    fun star1(input: List<String>): Int {
        // Parse the input
        val machines = parseInputLines(input)

        // fewest total presses
        var ans = 0
        for (machine in machines) {
            val presses = minPresses1(machine)
            if (presses != null) {
                ans += presses
            }
        }
        return ans
    }

    private fun minPresses1(machine: Machine): Int? {
        val target = machine.lightDiagram
        val buttons = machine.buttonSchematics
        val n = target.size
        val m = buttons.size

        var best: Int? = null

        val totalMasks = 1 shl m
        for (mask in 0 until totalMasks) {
            val state = IntArray(n) { 0 }
            var presses = 0

            var bitMask = mask
            var buttonIndex = 0
            while (bitMask != 0) {
                if ((bitMask and 1) == 1) {
                    presses++
                    val button = buttons[buttonIndex]
                    for (idx in button) {
                        state[idx] = state[idx] xor 1
                    }
                }
                bitMask = bitMask shr 1
                buttonIndex++
            }

            var ok = true
            for (i in 0 until n) {
                if (state[i] != target[i]) {
                    ok = false
                    break
                }
            }

            if (ok) {
                if (best == null || presses < best) {
                    best = presses
                }
            }
        }
        return best
    }

    fun star2(input: List<String>): Int {
        // Parse the input
        val machines = parseInputLines(input)

        // sum of joltage requirements
        var ans = 0
        for ((index, machine) in machines.withIndex()) {
            println("Machine ${index + 1}/${machines.size}: target=${machine.joltageRequirements}")
            val presses = minPresses2(machine)
            if (presses != null) {
                println("  → $presses presses")
                ans += presses
            } else {
                println("  → No solution")
            }
        }
        return ans
    }

    private fun minPresses2(machine: Machine): Int? {
        val target = machine.joltageRequirements.toIntArray()
        val n = target.size

        // Edge case: already satisfied
        if (target.all { it == 0 }) return 0

        // Normalize buttons: remove duplicates and empty ones
        val unique = LinkedHashMap<String, IntArray>()
        for (raw in machine.buttonSchematics) {
            val arr = raw.distinct().sorted().toIntArray()
            if (arr.isNotEmpty()) {
                unique.putIfAbsent(arr.joinToString(","), arr)
            }
        }
        if (unique.isEmpty()) return null

        // Quick impossibility: every counter with target>0 must be touched by at least one button
        val touched = BooleanArray(n)
        for (b in unique.values) for (i in b) touched[i] = true
        for (i in 0 until n) if (target[i] > 0 && !touched[i]) return null

        // Convert to Button objects

        val buttonsRaw = unique.values.map { Button(it, it.size) }

        // Heuristic sort: larger buttons first, and prefer buttons that touch "rarer" counters
        val counterDegree = IntArray(n)
        for (b in buttonsRaw) for (i in b.idxs) counterDegree[i]++

        val buttons = buttonsRaw.sortedWith(
            compareByDescending<Button> { it.size }
                .thenBy { b -> b.idxs.sumOf { counterDegree[it] } } // smaller sum => rarer counters
        ).toTypedArray()

        val m = buttons.size

        // Precompute suffix info for pruning
        val suffixMaxSize = IntArray(m + 1)
        suffixMaxSize[m] = 0
        for (i in m - 1 downTo 0) {
            suffixMaxSize[i] = maxOf(suffixMaxSize[i + 1], buttons[i].size)
        }

        // coverFrom[idx][c] == true if any button in [idx..end) touches counter c
        val coverFrom = Array(m + 1) { BooleanArray(n) }
        for (i in m - 1 downTo 0) {
            val next = coverFrom[i + 1].clone()
            for (c in buttons[i].idxs) next[c] = true
            coverFrom[i] = next
        }

        // Universal safe upper bound: presses <= sum(target)
        val sumTarget = target.fold(0L) { acc, v -> acc + v }
        var best = if (sumTarget > Int.MAX_VALUE) Int.MAX_VALUE else sumTarget.toInt()

        fun lowerBound(rem: IntArray, idx: Int, sumRem: Long, maxRem: Int): Int {
            val maxSize = suffixMaxSize[idx]
            if (maxSize == 0) return Int.MAX_VALUE / 4
            val lb1 = ((sumRem + maxSize - 1L) / maxSize).toInt()
            return maxOf(maxRem, lb1)
        }

        fun dfs(idx: Int, used: Int, rem: IntArray) {
            if (used >= best) return

            var sumRem = 0L
            var maxRem = 0
            for (v in rem) {
                sumRem += v.toLong()
                if (v > maxRem) maxRem = v
            }

            // Success
            if (sumRem == 0L) {
                best = used
                return
            }
            if (idx == m) return

            // Coverability prune
            val cover = coverFrom[idx]
            for (i in 0 until n) {
                if (rem[i] > 0 && !cover[i]) return
            }

            // Lower-bound prune
            val lb = lowerBound(rem, idx, sumRem, maxRem)
            if (used + lb >= best) return

            val b = buttons[idx]

            // Upper bound for presses of this button (can't overshoot any affected counter)
            var ub = Int.MAX_VALUE
            for (c in b.idxs) ub = minOf(ub, rem[c])
            if (ub == Int.MAX_VALUE) ub = 0

            // Also don't bother trying x that would already exceed current best
            ub = minOf(ub, best - 1 - used)
            if (ub < 0) return

            // Try larger x first to find good solutions early (improves pruning)
            for (x in ub downTo 0) {
                if (x > 0) {
                    for (c in b.idxs) rem[c] -= x
                }
                dfs(idx + 1, used + x, rem)
                if (x > 0) {
                    for (c in b.idxs) rem[c] += x
                }
            }
        }

        dfs(0, 0, target.clone())
        return if (best == (if (sumTarget > Int.MAX_VALUE) Int.MAX_VALUE else sumTarget.toInt()) && best != 0) {
            // If we never improved from the initial UB, it still might be a valid optimum,
            // but only if it was actually reached. Safer approach: accept it only if found.
            // We detect "found" by re-running with forced cap = best and checking feasibility.
            val cap = best
            var found = false
            fun check(idx: Int, used: Int, rem: IntArray) {
                if (found) return
                if (used > cap) return

                var sumRem = 0L
                for (v in rem) sumRem += v.toLong()
                if (sumRem == 0L) {
                    found = true
                    return
                }
                if (idx == m) return
                val cover = coverFrom[idx]
                for (i in 0 until n) if (rem[i] > 0 && !cover[i]) return

                val b = buttons[idx]
                var ub = Int.MAX_VALUE
                for (c in b.idxs) ub = minOf(ub, rem[c])
                ub = minOf(ub, cap - used)
                for (x in ub downTo 0) {
                    if (x > 0) for (c in b.idxs) rem[c] -= x
                    check(idx + 1, used + x, rem)
                    if (x > 0) for (c in b.idxs) rem[c] += x
                }
            }
            check(0, 0, target.clone())
            if (found) best else null
        } else {
            best
        }
    }

    private fun parseInputLines(input: List<String>): List<Machine> {
        return input.map { line ->
            // light diagram in [square brackets]
            val lightDiagram = line.substringAfter("[").substringBefore("]").map { if (it == '#') 1 else 0 }
            // one or more button wiring schematics in (parentheses)
            val buttonSchematics =
                Regex("""\((.*?)\)""").findAll(line)
                    .map { it.groupValues[1].split(",").map { el -> el.toInt() } }
                    .toList()
            // joltage requirements in {curly braces}
            val joltageRequirements = line.substringAfter("{").substringBefore("}").split(",").map { it.toInt() }
            Machine(lightDiagram, buttonSchematics, joltageRequirements)
        }
    }
}
