package com.pandus.leetcode.solutions.daily

import kotlin.math.max

//Reference: https://leetcode.com/problems/crawler-log-folder
class CrawlerLogFolder {
    fun minOperations(logs: Array<String>): Int {
        var folderDepth = 0
        logs.forEach {
            when (it) {
                "../" -> folderDepth = max(0, (folderDepth - 1))
                "./" -> {}
                else -> folderDepth++
            }
        }
        return folderDepth
    }
}