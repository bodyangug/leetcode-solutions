package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class BalancedBinaryTreeTest {
    private val solution = BalancedBinaryTree()

    @Test
    fun `test example 1 - balanced tree with three levels`() {
        // Input: root = [3,9,20,null,null,15,7]
        // Output: true
        val root = TreeNode(3).apply {
            left = TreeNode(9)
            right = TreeNode(20).apply {
                left = TreeNode(15)
                right = TreeNode(7)
            }
        }

        val result = solution.isBalanced(root)
        assertTrue(result)
    }

    @Test
    fun `test example 2 - unbalanced tree with left skew`() {
        // Input: root = [1,2,2,3,3,null,null,4,4]
        // Output: false
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(3).apply {
                    left = TreeNode(4)
                    right = TreeNode(4)
                }
                right = TreeNode(3)
            }
            right = TreeNode(2)
        }

        val result = solution.isBalanced(root)
        assertFalse(result)
    }

    @Test
    fun `test example 3 - empty tree`() {
        // Input: root = []
        // Output: true
        val root: TreeNode? = null

        val result = solution.isBalanced(root)
        assertTrue(result)
    }

    @Test
    fun `test single node tree`() {
        // A single node is always balanced
        val root = TreeNode(1)

        val result = solution.isBalanced(root)
        assertTrue(result)
    }

    @Test
    fun `test two nodes balanced - left child only`() {
        val root = TreeNode(1).apply {
            left = TreeNode(2)
        }

        val result = solution.isBalanced(root)
        assertTrue(result)
    }

    @Test
    fun `test two nodes balanced - right child only`() {
        val root = TreeNode(1).apply {
            right = TreeNode(2)
        }

        val result = solution.isBalanced(root)
        assertTrue(result)
    }

    @Test
    fun `test unbalanced tree - left skewed chain`() {
        // Tree: 1 -> 2 -> 3 (all left children)
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(3)
            }
        }

        val result = solution.isBalanced(root)
        assertFalse(result)
    }

    @Test
    fun `test unbalanced tree - right skewed chain`() {
        // Tree: 1 -> 2 -> 3 (all right children)
        val root = TreeNode(1).apply {
            right = TreeNode(2).apply {
                right = TreeNode(3)
            }
        }

        val result = solution.isBalanced(root)
        assertFalse(result)
    }

    @Test
    fun `test perfectly balanced tree - three levels`() {
        // Tree: Perfect binary tree with 7 nodes
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

        val result = solution.isBalanced(root)
        assertTrue(result)
    }

    @Test
    fun `test balanced tree - height difference of 1`() {
        // Tree with height difference of exactly 1 (still balanced)
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(3)
            }
            right = TreeNode(4)
        }

        val result = solution.isBalanced(root)
        assertTrue(result)
    }

    @Test
    fun `test unbalanced tree - height difference greater than 1 at root`() {
        // Left subtree has height 3, right subtree has height 0
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(3).apply {
                    left = TreeNode(4)
                }
            }
        }

        val result = solution.isBalanced(root)
        assertFalse(result)
    }

    @Test
    fun `test unbalanced tree - imbalance in subtree not root`() {
        // Root appears balanced but left subtree is not
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(3).apply {
                    left = TreeNode(4)
                }
            }
            right = TreeNode(5)
        }

        val result = solution.isBalanced(root)
        assertFalse(result)
    }

    @Test
    fun `test balanced tree with missing nodes at bottom level`() {
        // Not a perfect tree but still balanced
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4)
            }
            right = TreeNode(3).apply {
                right = TreeNode(5)
            }
        }

        val result = solution.isBalanced(root)
        assertTrue(result)
    }

    @Test
    fun `test large balanced tree with five levels`() {
        // Building a larger balanced tree
        val root = TreeNode(10).apply {
            left = TreeNode(5).apply {
                left = TreeNode(3).apply {
                    left = TreeNode(1)
                    right = TreeNode(4)
                }
                right = TreeNode(7).apply {
                    left = TreeNode(6)
                    right = TreeNode(8)
                }
            }
            right = TreeNode(15).apply {
                left = TreeNode(12).apply {
                    left = TreeNode(11)
                    right = TreeNode(13)
                }
                right = TreeNode(17).apply {
                    left = TreeNode(16)
                    right = TreeNode(18)
                }
            }
        }

        val result = solution.isBalanced(root)
        assertTrue(result)
    }

    @Test
    fun `test unbalanced tree with deep left branch`() {
        // Right side is 2 levels, left side is 4+ levels
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(3).apply {
                    left = TreeNode(4).apply {
                        left = TreeNode(5)
                    }
                }
            }
            right = TreeNode(6).apply {
                left = TreeNode(7)
            }
        }

        val result = solution.isBalanced(root)
        assertFalse(result)
    }
}
