package com.pandus.leetcode.solutions.google;

import com.pandus.leetcode.solutions.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private Map<Integer, Integer> idx;   // значение -> его позиция в inorder

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        idx = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) idx.put(inorder[i], i);
        return build(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int rootIdx  = idx.get(rootVal);
        int leftSize = rootIdx - inStart;            // сколько узлов в левом поддереве

        root.setLeft(build(preorder, preStart + 1, preStart + leftSize, inStart, rootIdx - 1));
        root.setRight(build(preorder, preStart + leftSize + 1, preEnd, rootIdx + 1, inEnd));
        return root;
    }
}
