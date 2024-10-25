package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/remove-sub-folders-from-the-filesystem
class RemoveSubFoldersFromFilesystem {
    fun removeSubfolders(folder: Array<String>): List<String> {
        folder.sort()
        val result: MutableList<String> = ArrayList<String>().apply { this.add(folder[0]) }

        for (i in 1 until folder.size) {
            var lastFolder = result[result.size - 1]
            lastFolder += '/'
            if (!folder[i].startsWith(lastFolder)) {
                result.add(folder[i])
            }
        }
        return result
    }
}
