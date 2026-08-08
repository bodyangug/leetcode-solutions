package com.pandus.leetcode.solutions.google;

import com.pandus.leetcode.solutions.model.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return new ArrayList<>();
        ArrayDeque<TreeNode> averageByLevel = new ArrayDeque<>();
        averageByLevel.add(root);

        List<Double> averages = new ArrayList<>();
        while (!averageByLevel.isEmpty()) {
            int size = averageByLevel.size();
            double sum = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode node = averageByLevel.poll();
                sum += node.getVal();
                if (node.getLeft() != null) averageByLevel.add(node.getLeft());
                if (node.getRight() != null) averageByLevel.add(node.getRight());
            }
            averages.add(sum / size);
        }
        return averages;
    }
}
