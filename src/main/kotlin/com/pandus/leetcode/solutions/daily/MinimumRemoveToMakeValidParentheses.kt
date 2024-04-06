package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses
class MinimumRemoveToMakeValidParentheses {

    fun minRemoveToMakeValid(s: String): String {
        // 1. find the indexes to remove
        val indexToRemove = HashSet<Int>()
        val stack = ArrayDeque<Int>()
        s.forEachIndexed { index, c ->
            if (c == '(') {
                stack.add(index)
            }
            if (c == ')') {
                if (stack.isEmpty()) {
                    indexToRemove.add(index)
                } else {
                    stack.removeFirst()
                }
            }
        }
        // 2. convert indexes from stack to remove
        while (!stack.isEmpty()) indexToRemove.add(stack.removeFirst());

        // 3. generate new string using info from indexToRemove
        val sb = StringBuilder()
        for (i in s.indices) {
            if (!indexToRemove.contains(i)) {
                sb.append(s[i])
            }
        }
        return sb.toString()
    }
}
