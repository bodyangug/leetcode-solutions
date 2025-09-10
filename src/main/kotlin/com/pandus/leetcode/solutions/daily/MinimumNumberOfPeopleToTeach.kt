package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-number-of-people-to-teach
class MinimumNumberOfPeopleToTeach {
    fun minimumTeachings(n: Int, languages: Array<IntArray>, friendships: Array<IntArray>): Int {
        // Pre-compute language sets for each user
        val userLanguageSets = languages.map { it.toSet() }

        // Filter friendships that need help and collect users into a set
        val usersNeedingHelp = friendships.asSequence()
            .filter { (u1, u2) ->
                userLanguageSets[u1 - 1].intersect(userLanguageSets[u2 - 1]).isEmpty()
            }
            .flatMap { (u1, u2) -> sequenceOf(u1 - 1, u2 - 1) }
            .toSet()

        if (usersNeedingHelp.isEmpty()) return 0

        // Count users knowing each language and find minimum teaching count
        return (1..n).minOf { lang ->
            usersNeedingHelp.count { user ->
                lang !in userLanguageSets[user]
            }
        }
    }
}
