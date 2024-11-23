package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/rotating-the-box
class RotatingTheBox {
    fun rotateTheBox(box: Array<CharArray>): Array<CharArray> {
        val ans = Array(box[0].size) { CharArray(box.size) { '.' } }
        for (row in box.indices) {
            var free = box[0].lastIndex
            for (col in box[0].lastIndex downTo 0) {
                if (box[row][col] != '.') {
                    if (box[row][col] == '*') free = col
                    ans[free--][box.lastIndex - row] = box[row][col]
                }
            }
        }
        return ans
    }
}
