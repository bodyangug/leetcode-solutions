package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class SmallestSubtreeWithAllDeepestNodesTest {
    private val solution = SmallestSubtreeWithAllDeepestNodes()

    @Test
    fun `test example 1 - complex tree with multiple deepest nodes`() {
        // Input: root = [3,5,1,6,2,0,8,null,null,7,4]
        val root = TreeNode(3).apply {
            left = TreeNode(5).apply {
                left = TreeNode(6)
                right = TreeNode(2).apply {
                    left = TreeNode(7)
                    right = TreeNode(4)
                }
            }
            right = TreeNode(1).apply {
                left = TreeNode(0)
                right = TreeNode(8)
            }
        }

        val result = solution.subtreeWithAllDeepest(root)
        assertEquals(2, result?.`val`)
    }

    @Test
    fun `test example 2 - single node tree`() {
        // Input: root = [1]
        val root = TreeNode(1)

        val result = solution.subtreeWithAllDeepest(root)
        assertEquals(1, result?.`val`)
    }

    @Test
    fun `test example 3 - linear tree structure`() {
        // Input: root = [0,1,3,null,2]
        val root = TreeNode(0).apply {
            left = TreeNode(1).apply {
                right = TreeNode(2)
            }
            right = TreeNode(3)
        }

        val result = solution.subtreeWithAllDeepest(root)
        assertEquals(2, result?.`val`)
    }

    @Test
    fun `test null root`() {
        val result = solution.subtreeWithAllDeepest(null)
        assertNull(result)
    }

    @Test
    fun `test two node tree - left child only`() {
        val root = TreeNode(1).apply {
            left = TreeNode(2)
        }

        val result = solution.subtreeWithAllDeepest(root)
        assertEquals(2, result?.`val`)
    }

    @Test
    fun `test two node tree - right child only`() {
        val root = TreeNode(1).apply {
            right = TreeNode(2)
        }

        val result = solution.subtreeWithAllDeepest(root)
        assertEquals(2, result?.`val`)
    }

    @Test
    fun `test balanced tree with equal depths`() {
        // Input: root = [1,2,3]
        val root = TreeNode(1).apply {
            left = TreeNode(2)
            right = TreeNode(3)
        }

        val result = solution.subtreeWithAllDeepest(root)
        assertEquals(1, result?.`val`)
    }

    @Test
    fun `test deeper left subtree`() {
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(3)
            }
            right = TreeNode(4)
        }

        val result = solution.subtreeWithAllDeepest(root)
        assertEquals(3, result?.`val`)
    }

    @Test
    fun `test deeper right subtree`() {
        val root = TreeNode(1).apply {
            left = TreeNode(2)
            right = TreeNode(3).apply {
                right = TreeNode(4)
            }
        }

        val result = solution.subtreeWithAllDeepest(root)
        assertEquals(4, result?.`val`)
    }

    @Test
    fun `test multiple deepest nodes at same level on both sides`() {
        // Tree: [1,2,3,4,5,6,7]
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4)
                right = TreeNode(5)
            }
            right = TreeNode(3).apply {
                left = TreeNode(6)
                right = TreeNode(7)
            }
        }

        val result = solution.subtreeWithAllDeepest(root)
        assertEquals(1, result?.`val`)
    }

    @Test
    fun `test deepest nodes on left side only`() {
        // Tree with deeper left subtree having multiple deepest nodes
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4)
                right = TreeNode(5)
            }
            right = TreeNode(3)
        }

        val result = solution.subtreeWithAllDeepest(root)
        assertEquals(2, result?.`val`)
    }

    @Test
    fun `test deepest nodes on right side only`() {
        // Tree with deeper right subtree having multiple deepest nodes
        val root = TreeNode(1).apply {
            left = TreeNode(2)
            right = TreeNode(3).apply {
                left = TreeNode(6)
                right = TreeNode(7)
            }
        }

        val result = solution.subtreeWithAllDeepest(root)
        assertEquals(3, result?.`val`)
    }
}
