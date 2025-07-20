package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/delete-duplicate-folders-in-system
class DeleteDuplicateFoldersInSystem {
    fun deleteDuplicateFolder(paths: List<List<String>>): List<List<String>> {
        data class Folder(
            val name: String,
            var deleted: Boolean = false,
            val subfolders: MutableMap<String, Folder> = mutableMapOf()
        )

        val root = Folder("/")

        // Build the folder tree
        fun insert(path: List<String>) {
            var curr = root
            for (folderName in path) {
                curr = curr.subfolders.getOrPut(folderName) { Folder(folderName) }
            }
        }

        for (path in paths) {
            insert(path)
        }

        val visited = mutableMapOf<String, Folder>()

        // Serialize tree and mark duplicates
        fun serializeAndMark(folder: Folder): String {
            if (folder.subfolders.isEmpty()) {
                return ""
            }

            val subSerialized = folder.subfolders.entries
                .sortedBy { it.key } // ensure deterministic serialization
                .joinToString("") { (name, child) ->
                    buildString {
                        append("(")
                        append(name)
                        append(serializeAndMark(child))
                        append(")")
                    }
                }

            visited[subSerialized]?.let {
                it.deleted = true
                folder.deleted = true
            } ?: run {
                visited[subSerialized] = folder
            }

            return subSerialized
        }

        serializeAndMark(root)

        val result = mutableListOf<List<String>>()

        // Collect non-deleted paths (with mutable backtracking)
        fun collect(folder: Folder, path: MutableList<String>) {
            if (folder.deleted) return

            path.add(folder.name)
            if (folder != root) result.add(path.toList())

            for (child in folder.subfolders.values) {
                collect(child, path)
            }

            path.removeAt(path.lastIndex)
        }

        for (child in root.subfolders.values) {
            collect(child, mutableListOf())
        }

        return result
    }
}
