package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/simple-bank-system
class SimpleBankSystem(val balance: LongArray) {
    private fun isValidAccount(account: Int): Boolean = account in 1..balance.size
    private fun idx(account: Int): Int = account - 1
    private fun hasEnoughFunds(account: Int, money: Long): Boolean = balance[idx(account)] >= money

    fun transfer(account1: Int, account2: Int, money: Long): Boolean {
        if (money < 0) return false
        if (!isValidAccount(account1) || !isValidAccount(account2)) return false
        if (!hasEnoughFunds(account1, money)) return false

        val fromIdx = idx(account1)
        val toIdx = idx(account2)
        balance[fromIdx] -= money
        balance[toIdx] += money
        return true
    }

    fun deposit(account: Int, money: Long): Boolean {
        if (money < 0) return false
        if (!isValidAccount(account)) return false
        balance[idx(account)] += money
        return true
    }

    fun withdraw(account: Int, money: Long): Boolean {
        if (money < 0) return false
        if (!isValidAccount(account)) return false
        if (!hasEnoughFunds(account, money)) return false
        balance[idx(account)] -= money
        return true
    }
}
