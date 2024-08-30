package com.pandus.leetcode.solutions.google

// Reference: https://leetcode.com/problems/unique-email-addresses
class UniqueEmailAddresses {
    fun numUniqueEmails(emails: Array<String>): Int {
        val ans = HashSet<String>()
        for (email in emails) {
            ans.add(email.cleanUp())
        }
        return ans.size
    }

    private fun String.cleanUp(): String {
        val charArray = this.toCharArray()
        val sb = StringBuilder()
        var plusSign = false
        // Clean-up local name
        for (char in charArray) {
            if (char == '@') {
                sb.append(char)
                break
            }
            if (plusSign) continue
            if (char == '+') {
                plusSign = true
                continue
            }
            if (char == '.') continue
            sb.append(char)
        }
        // Get domain name
        for (idx in charArray.indices.reversed()) {
            if (charArray[idx] == '@') break
            sb.append(charArray[idx])
        }
        return sb.toString()
    }
}
