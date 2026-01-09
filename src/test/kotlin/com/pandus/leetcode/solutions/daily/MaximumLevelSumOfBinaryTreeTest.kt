package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MaximumLevelSumOfBinaryTreeTest {
    private val solution = MaximumLevelSumOfBinaryTree()

    @Test
    @DisplayName("Example 1: root = [1,7,0,7,-8,null,null]")
    fun testExample1() {
        // Build tree: [1,7,0,7,-8,null,null]
        //       1
        //      / \
        //     7   0
        //    / \
        //   7  -8
        val root = TreeNode(1).apply {
            left = TreeNode(7).apply {
                left = TreeNode(7)
                right = TreeNode(-8)
            }
            right = TreeNode(0)
        }
        val result = solution.maxLevelSum(root)
        assertEquals(2, result, "Level 2 has sum 7 + 0 = 7, which is the maximum")
    }

    @Test
    @DisplayName("Example 2: root = [989,null,10250,98693,-89388,null,null,null,-32127]")
    fun testExample2() {
        // Build tree: [989,null,10250,98693,-89388,null,null,null,-32127]
        //           989
        //              \
        //             10250
        //             /    \
        //         98693   -89388
        //                      \
        //                    -32127
        val root = TreeNode(989).apply {
            right = TreeNode(10250).apply {
                left = TreeNode(98693)
                right = TreeNode(-89388).apply {
                    right = TreeNode(-32127)
                }
            }
        }
        val result = solution.maxLevelSum(root)
        assertEquals(2, result, "Level 2 has the maximum sum")
    }

    @Test
    @DisplayName("Single node tree: root = [1]")
    fun testSingleNode() {
        val root = TreeNode(1)
        val result = solution.maxLevelSum(root)
        assertEquals(1, result, "Single node tree should return level 1")
    }

    @Test
    @DisplayName("Two levels with negative values: root = [-100,50,50]")
    fun testNegativeValues() {
        val root = TreeNode(-100).apply {
            left = TreeNode(50)
            right = TreeNode(50)
        }
        val result = solution.maxLevelSum(root)
        assertEquals(2, result, "Level 2 has sum 100, which is greater than level 1 (-100)")
    }

    @Test
    @DisplayName("All negative values: root = [-1,-2,-3,-4,-5]")
    fun testAllNegative() {
        // Build tree:
        //       -1
        //      /  \
        //    -2    -3
        //   /  \
        //  -4  -5
        val root = TreeNode(-1).apply {
            left = TreeNode(-2).apply {
                left = TreeNode(-4)
                right = TreeNode(-5)
            }
            right = TreeNode(-3)
        }
        val result = solution.maxLevelSum(root)
        assertEquals(1, result, "Level 1 has sum -1, which is the maximum among all negative values")
    }

    @Test
    @DisplayName("Linear tree (right only): root = [1,null,2,null,3]")
    fun testLinearTreeRight() {
        val root = TreeNode(1).apply {
            right = TreeNode(2).apply {
                right = TreeNode(3)
            }
        }
        val result = solution.maxLevelSum(root)
        assertEquals(3, result, "Level 3 has sum 3, which is the maximum")
    }

    @Test
    @DisplayName("Linear tree (left only): root = [1,2,null,3]")
    fun testLinearTreeLeft() {
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(3)
            }
        }
        val result = solution.maxLevelSum(root)
        assertEquals(3, result, "Level 3 has sum 3, which is the maximum")
    }

    @Test
    @DisplayName("Multiple levels with same max sum: root = [5,2,3,1,4]")
    fun testSameMaxSum() {
        // Build tree:
        //       5
        //      / \
        //     2   3
        //    / \
        //   1   4
        // Level 1: sum = 5
        // Level 2: sum = 2 + 3 = 5
        // Level 3: sum = 1 + 4 = 5
        val root = TreeNode(5).apply {
            left = TreeNode(2).apply {
                left = TreeNode(1)
                right = TreeNode(4)
            }
            right = TreeNode(3)
        }
        val result = solution.maxLevelSum(root)
        assertEquals(1, result, "When multiple levels have same max sum, return the smallest level")
    }

    @Test
    @DisplayName("Balanced tree with positive values: root = [10,5,15,3,7,12,20]")
    fun testBalancedTree() {
        // Build tree:
        //          10
        //        /    \
        //       5      15
        //      / \    /  \
        //     3   7  12  20
        // Level 1: 10
        // Level 2: 5 + 15 = 20
        // Level 3: 3 + 7 + 12 + 20 = 42
        val root = TreeNode(10).apply {
            left = TreeNode(5).apply {
                left = TreeNode(3)
                right = TreeNode(7)
            }
            right = TreeNode(15).apply {
                left = TreeNode(12)
                right = TreeNode(20)
            }
        }
        val result = solution.maxLevelSum(root)
        assertEquals(3, result, "Level 3 has sum 42, which is the maximum")
    }

    @Test
    @DisplayName("Deep tree with max at middle level")
    fun testDeepTree() {
        // Build tree:
        //       1
        //      / \
        //     2   3
        //    /
        //   100
        //  /
        // 1
        // Level 1: 1
        // Level 2: 2 + 3 = 5
        // Level 3: 100
        // Level 4: 1
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(100).apply {
                    left = TreeNode(1)
                }
            }
            right = TreeNode(3)
        }
        val result = solution.maxLevelSum(root)
        assertEquals(3, result, "Level 3 has sum 100, which is the maximum")
    }
}
