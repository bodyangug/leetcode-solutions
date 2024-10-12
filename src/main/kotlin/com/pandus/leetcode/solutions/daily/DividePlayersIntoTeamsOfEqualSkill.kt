package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/divide-players-into-teams-of-equal-skill
class DividePlayersIntoTeamsOfEqualSkill {
    fun dividePlayers(skill: IntArray): Long {
        skill.sort()
        val n = skill.size
        var totalChemistry: Long = 0

        val targetTeamSkill = skill[0] + skill[n - 1]
        for (i in 0 until n / 2) {
            val currentTeamSkill = skill[i] + skill[n - i - 1]
            if (currentTeamSkill != targetTeamSkill) {
                return -1
            }
            totalChemistry += skill[i] * skill[n - i - 1]
        }
        return totalChemistry
    }
}
