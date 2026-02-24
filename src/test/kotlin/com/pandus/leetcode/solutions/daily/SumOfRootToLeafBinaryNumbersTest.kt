package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SumOfRootToLeafBinaryNumbersTest {
    private val solution = SumOfRootToLeafBinaryNumbers()

    @Test
    fun `test example 1 - tree with multiple paths`() {
        // Input: root = [1,0,1,0,1,0,1]
        // Output: 22
        // Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
        val root = TreeNode(1).apply {
            left = TreeNode(0).apply {
                left = TreeNode(0)
                right = TreeNode(1)
            }
            right = TreeNode(1).apply {
                left = TreeNode(0)
                right = TreeNode(1)
            }
        }

        val result = solution.sumRootToLeaf(root)
        assertEquals(22, result)
    }

    @Test
    fun `test example 2 - single node tree`() {
        // Input: root = [0]
        // Output: 0
        val root = TreeNode(0)

        val result = solution.sumRootToLeaf(root)
        assertEquals(0, result)
    }

    @Test
    fun `test single node tree with value 1`() {
        // Input: root = [1]
        // Output: 1
        val root = TreeNode(1)

        val result = solution.sumRootToLeaf(root)
        assertEquals(1, result)
    }

    @Test
    fun `test left skewed tree`() {
        // Input: root = [1,1,null,1,null,null,null]
        // Output: 7 (binary 111 = 7)
        val root = TreeNode(1).apply {
            left = TreeNode(1).apply {
                left = TreeNode(1)
            }
        }

        val result = solution.sumRootToLeaf(root)
        assertEquals(7, result)
    }

    @Test
    fun `test right skewed tree`() {
        // Input: root = [1,null,0,null,1]
        // Output: 5 (binary 101 = 5)
        val root = TreeNode(1).apply {
            right = TreeNode(0).apply {
                right = TreeNode(1)
            }
        }

        val result = solution.sumRootToLeaf(root)
        assertEquals(5, result)
    }

    @Test
    fun `test tree with all zeros except root`() {
        // Input: root = [1,0,0,0,0,0,0]
        // Output: 8 (100 + 100 + 100 + 100 = 4 + 4 + 4 + 4 = 16, but actual is 1000 + 1000 = 4 + 4 = 8)
        // Corrected: (100) + (100) + (100) + (100) = 4 + 4 + 4 + 4 = 16
        val root = TreeNode(1).apply {
            left = TreeNode(0).apply {
                left = TreeNode(0)
                right = TreeNode(0)
            }
            right = TreeNode(0).apply {
                left = TreeNode(0)
                right = TreeNode(0)
            }
        }

        val result = solution.sumRootToLeaf(root)
        assertEquals(16, result)
    }

    @Test
    fun `test tree with all ones`() {
        // Input: root = [1,1,1,1,1,1,1]
        // Output: (111) + (111) + (111) + (111) = 7 + 7 + 7 + 7 = 28
        val root = TreeNode(1).apply {
            left = TreeNode(1).apply {
                left = TreeNode(1)
                right = TreeNode(1)
            }
            right = TreeNode(1).apply {
                left = TreeNode(1)
                right = TreeNode(1)
            }
        }

        val result = solution.sumRootToLeaf(root)
        assertEquals(28, result)
    }

    @Test
    fun `test simple two-node tree - left child`() {
        // Input: root = [1,0]
        // Output: 2 (binary 10 = 2)
        val root = TreeNode(1).apply {
            left = TreeNode(0)
        }

        val result = solution.sumRootToLeaf(root)
        assertEquals(2, result)
    }

    @Test
    fun `test simple two-node tree - right child`() {
        // Input: root = [1,null,1]
        // Output: 3 (binary 11 = 3)
        val root = TreeNode(1).apply {
            right = TreeNode(1)
        }

        val result = solution.sumRootToLeaf(root)
        assertEquals(3, result)
    }

    @Test
    fun `test balanced tree with different paths`() {
        // Input: root = [1,0,1]
        // Output: 5 (binary 10 + 11 = 2 + 3 = 5)
        val root = TreeNode(1).apply {
            left = TreeNode(0)
            right = TreeNode(1)
        }

        val result = solution.sumRootToLeaf(root)
        assertEquals(5, result)
    }

    @Test
    fun `test tree with longer paths`() {
        // Input: root = [1,0,1,0,1,0,1,0,0,1,1,0,0,1,1]
        // This creates a complete binary tree with 4 levels
        val root = TreeNode(1).apply {
            left = TreeNode(0).apply {
                left = TreeNode(0).apply {
                    left = TreeNode(0) // path: 1000 = 8
                    right = TreeNode(0) // path: 1000 = 8
                }
                right = TreeNode(1).apply {
                    left = TreeNode(1) // path: 1011 = 11
                    right = TreeNode(1) // path: 1011 = 11
                }
            }
            right = TreeNode(1).apply {
                left = TreeNode(0).apply {
                    left = TreeNode(0) // path: 1100 = 12
                    right = TreeNode(0) // path: 1100 = 12
                }
                right = TreeNode(1).apply {
                    left = TreeNode(1) // path: 1111 = 15
                    right = TreeNode(1) // path: 1111 = 15
                }
            }
        }

        val result = solution.sumRootToLeaf(root)
        // 8 + 8 + 11 + 11 + 12 + 12 + 15 + 15 = 92
        assertEquals(92, result)
    }

    @Test
    fun `test tree with only left children`() {
        // Input: root = [1,0,null,1,null,null,null,0]
        // Path: 1010 = 10
        val root = TreeNode(1).apply {
            left = TreeNode(0).apply {
                left = TreeNode(1).apply {
                    left = TreeNode(0)
                }
            }
        }

        val result = solution.sumRootToLeaf(root)
        assertEquals(10, result)
    }

    @Test
    fun `test tree with only right children`() {
        // Input: root = [1,null,1,null,1,null,1]
        // Path: 1111 = 15
        val root = TreeNode(1).apply {
            right = TreeNode(1).apply {
                right = TreeNode(1).apply {
                    right = TreeNode(1)
                }
            }
        }

        val result = solution.sumRootToLeaf(root)
        assertEquals(15, result)
    }
}
