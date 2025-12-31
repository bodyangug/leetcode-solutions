package com.pandus.advent.of.code.twenty.five

// Reference: https://adventofcode.com/2025/day/11
class Day11 {

    fun star1(input: List<String>): Int {
        val graph = parseInput(input)
        val paths = findAllPaths(graph, start = "you", end = "out")
        for (p in paths) {
            println(p.joinToString(" -> "))
        }
        return paths.size
    }

    fun star2(input: List<String>): Long {
        val graph = parseInput(input)
        val paths = countPathsWithDacAndFftDP(graph)
        return paths
    }

    fun countPathsWithDacAndFftDP(graph: Map<String, List<String>>): Long {
        val start = "svr"
        val target = "out"

        // --- 1. Build reverse graph ---
        val rev = mutableMapOf<String, MutableList<String>>()
        for ((u, vs) in graph) {
            for (v in vs) {
                rev.computeIfAbsent(v) { mutableListOf() }.add(u)
            }
        }

        // --- 2. BFS from svr (which vertices are reachable forward) ---
        fun forwardReach(): Set<String> {
            val q = ArrayDeque<String>()
            val seen = mutableSetOf<String>()
            q.add(start)
            seen.add(start)
            while (q.isNotEmpty()) {
                val u = q.removeFirst()
                for (v in graph[u].orEmpty()) {
                    if (seen.add(v)) {
                        q.add(v)
                    }
                }
            }
            return seen
        }

        // --- 3. BFS from out on reverse graph (which can reach out) ---
        fun backwardReach(): Set<String> {
            val q = ArrayDeque<String>()
            val seen = mutableSetOf<String>()
            q.add(target)
            seen.add(target)
            while (q.isNotEmpty()) {
                val u = q.removeFirst()
                for (v in rev[u].orEmpty()) {
                    if (seen.add(v)) {
                        q.add(v)
                    }
                }
            }
            return seen
        }

        val fromStart = forwardReach()
        val toTarget = backwardReach()
        val relevantNodes = fromStart intersect toTarget

        if (start !in relevantNodes || target !in relevantNodes) return 0L

        // --- 4. Number vertices and build subgraph ---
        val nodesList = relevantNodes.toList()
        val index = nodesList.withIndex().associate { it.value to it.index }
        val n = nodesList.size

        val adj = Array(n) { IntArray(0) }
        val indeg = IntArray(n)

        for ((u, vs) in graph) {
            val ui = index[u] ?: continue
            val list = mutableListOf<Int>()
            for (v in vs) {
                val vi = index[v] ?: continue
                list.add(vi)
                indeg[vi]++
            }
            adj[ui] = list.toIntArray()
        }

        // --- 5. Topological sort (Kahn's algorithm) ---
        val queue: ArrayDeque<Int> = ArrayDeque()
        for (i in 0 until n) {
            if (indeg[i] == 0) queue.add(i)
        }

        val topo = IntArray(n)
        var tSize = 0
        while (queue.isNotEmpty()) {
            val u = queue.removeFirst()
            topo[tSize++] = u
            for (v in adj[u]) {
                indeg[v]--
                if (indeg[v] == 0) queue.add(v)
            }
        }

        // If tSize < n — there's a cycle, but in your input from svr to out it's a DAG.
        if (tSize != n) {
            // Can throw an exception or handle it differently
            error("Graph between svr and out is not a DAG")
        }

        val startIdx = index[start]!!
        val targetIdx = index[target]!!

        fun maskFor(name: String): Int {
            var m = 0
            if (name == "dac") m = m or 1
            if (name == "fft") m = m or 2
            return m
        }

        // --- 6. DP on topological order: dp[node][mask] ---
        val dp = Array(n) { LongArray(4) }
        dp[startIdx][maskFor(start)] = 1L

        for (k in 0 until tSize) {
            val u = topo[k]
            val nameU = nodesList[u]

            for (mask in 0..3) {
                val ways = dp[u][mask]
                if (ways == 0L) continue

                for (v in adj[u]) {
                    val nameV = nodesList[v]
                    var newMask = mask
                    if (nameV == "dac") newMask = newMask or 1
                    if (nameV == "fft") newMask = newMask or 2
                    dp[v][newMask] += ways
                }
            }
        }

        return dp[targetIdx][3]
    }

    private fun findAllPaths(
        graph: Map<String, List<String>>,
        start: String,
        end: String
    ): List<List<String>> {
        val result = mutableListOf<List<String>>()
        val path = mutableListOf<String>()
        val visitedOnPath = mutableSetOf<String>() // protection against cycles

        fun dfs(cur: String) {
            path.add(cur)
            visitedOnPath.add(cur)

            if (cur == end) {
                // found complete path
                result.add(path.toList()) // copy
            } else {
                val neighbors = graph[cur].orEmpty()
                for (next in neighbors) {
                    // if we fear cycles – don't go to already visited vertices on this path
                    if (next !in visitedOnPath) {
                        dfs(next)
                    }
                }
            }

            // backtrack
            path.removeAt(path.size - 1)
            visitedOnPath.remove(cur)
        }

        dfs(start)
        return result
    }

    private fun parseInput(lines: List<String>): Map<String, List<String>> {
        val graph = mutableMapOf<String, MutableList<String>>()
        for (line in lines) {
            if (line.isBlank()) continue
            val (fromPart, toPart) = line.split(":")
            val from = fromPart.trim()
            val toList = toPart.trim().split(" ").filter { it.isNotBlank() }
            graph.computeIfAbsent(from) { mutableListOf() }.addAll(toList)
        }
        return graph
    }
}
