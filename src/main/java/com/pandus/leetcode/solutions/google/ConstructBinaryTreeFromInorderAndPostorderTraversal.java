package com.pandus.leetcode.solutions.google;

import com.pandus.leetcode.solutions.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    private Map<Integer, Integer> idx;   // значение -> его позиция в inorder

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // inorder: LEFT, MIDDLE, RIGHT
        // postOrder: LEFT, RIGHT, MIDDLE
        idx = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) idx.put(inorder[i], i);
        return build(postorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int postStart, int postEnd, int inStart, int inEnd) {
        if (postStart > postEnd) return null;

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int rootIdx = idx.get(rootVal);
        int leftSize = rootIdx - inStart;            // сколько узлов в левом поддереве

        root.setLeft(build(postorder, postStart, postStart + leftSize - 1, inStart, rootIdx - 1));
        root.setRight(build(postorder, postStart + leftSize, postEnd - 1, rootIdx + 1, inEnd));
        return root;
    }
}
