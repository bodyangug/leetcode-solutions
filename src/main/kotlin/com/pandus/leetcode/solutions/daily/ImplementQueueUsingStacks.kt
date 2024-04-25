package com.pandus.leetcode.solutions.daily

import java.util.Stack


//Reference: https://leetcode.com/problems/implement-queue-using-stacks
class ImplementQueueUsingStacks {

    private val s1 = Stack<Int>()
    private val s2 = Stack<Int>()
    private var front: Int = -1

    fun push(x: Int) {
        if (s1.empty()) {
            front = x
        }
        s1.push(x)
    }

    fun pop(): Int {
        if (s2.empty()) {
            while (!s1.empty())
                s2.push(s1.pop())
        }
        return s2.pop()
    }

    fun peek(): Int {
        if (!s2.empty()) {
            return s2.peek()
        }
        return front
    }

    fun empty(): Boolean {
        return s1.empty() && s2.empty()
    }

}
