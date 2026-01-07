package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MaximumProductOfSplittedBinaryTreeTest {
    private val solver = MaximumProductOfSplittedBinaryTree()

    @Test
    @DisplayName("Example 1: [1,2,3,4,5,6] -> 110")
    fun maxProduct_example1() {
        // Tree structure:
        //       1
        //      / \
        //     2   3
        //    / \ /
        //   4  5 6
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4)
                right = TreeNode(5)
            }
            right = TreeNode(3).apply {
                left = TreeNode(6)
            }
        }
        val expected = 110
        assertEquals(expected, solver.maxProduct(root))
    }

    @Test
    @DisplayName("Edge case: Single node -> 0")
    fun maxProduct_singleNode() {
        val root = TreeNode(1)
        val expected = 0
        assertEquals(expected, solver.maxProduct(root))
    }

    @Test
    @DisplayName("Edge case: Two nodes (left child) -> 0")
    fun maxProduct_twoNodesLeft() {
        // Tree: 1 -> 1 (left)
        val root = TreeNode(1).apply {
            left = TreeNode(1)
        }
        val expected = 1 // (1) * (1) = 1
        assertEquals(expected, solver.maxProduct(root))
    }

    @Test
    @DisplayName("Edge case: Two nodes (right child) -> 0")
    fun maxProduct_twoNodesRight() {
        // Tree: 1 -> 1 (right)
        val root = TreeNode(1).apply {
            right = TreeNode(1)
        }
        val expected = 1 // (1) * (1) = 1
        assertEquals(expected, solver.maxProduct(root))
    }

    @Test
    @DisplayName("Skewed tree (right)")
    fun maxProduct_skewedRight() {
        // Tree structure:
        // 1
        //  \
        //   2
        //    \
        //     3
        val root = TreeNode(1).apply {
            right = TreeNode(2).apply {
                right = TreeNode(3)
            }
        }
        // Total sum = 6
        // Possible splits: (5, 1), (3, 3)
        // Maximum product: 3 * 3 = 9
        val expected = 9
        assertEquals(expected, solver.maxProduct(root))
    }

    @Test
    @DisplayName("Large values requiring modulo")
    fun maxProduct_largeValues() {
        // Tree structure:
        //       1
        //      / \
        //     2   2
        //    /     \
        //   2       2
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(2)
            }
            right = TreeNode(2).apply {
                right = TreeNode(2)
            }
        }
        // Total sum = 9
        // Possible splits give various products
        val expected = 20 // (5 * 4 = 20)
        assertEquals(expected, solver.maxProduct(root))
    }

    @Test
    @DisplayName("Complex tree with multiple levels")
    fun maxProduct_complexTree() {
        // Tree structure:
        //         10
        //        /  \
        //       5    15
        //      / \   /
        //     3   7 12
        val root = TreeNode(10).apply {
            left = TreeNode(5).apply {
                left = TreeNode(3)
                right = TreeNode(7)
            }
            right = TreeNode(15).apply {
                left = TreeNode(12)
            }
        }
        // Total sum = 52
        // Split at left subtree: 15 * 37 = 555
        // Split at right subtree: 27 * 25 = 675
        // Various other splits possible
        val expected = 675
        assertEquals(expected, solver.maxProduct(root))
    }

    @Test
    @DisplayName("Tree with all same values")
    fun maxProduct_allSameValues() {
        // Tree structure:
        //       1
        //      / \
        //     1   1
        //    / \
        //   1   1
        val root = TreeNode(1).apply {
            left = TreeNode(1).apply {
                left = TreeNode(1)
                right = TreeNode(1)
            }
            right = TreeNode(1)
        }
        // Total sum = 5
        // Best split: 2 * 3 = 6 or 3 * 2 = 6
        val expected = 6
        assertEquals(expected, solver.maxProduct(root))
    }

    @Test
    @DisplayName("Asymmetric tree")
    fun maxProduct_asymmetricTree() {
        // Tree structure:
        //       6
        //      / \
        //     3   5
        //    /   / \
        //   2   7   4
        val root = TreeNode(6).apply {
            left = TreeNode(3).apply {
                left = TreeNode(2)
            }
            right = TreeNode(5).apply {
                left = TreeNode(7)
                right = TreeNode(4)
            }
        }
        // Total sum = 27
        // Various splits: (16, 11), (5, 22), etc.
        val expected = 176 // 16 * 11 = 176
        assertEquals(expected, solver.maxProduct(root))
    }
}
