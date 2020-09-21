package com.zxl.datastructure.tree;

/**
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 */

//解决方法：反向中序遍历
public class LeetCode538 {
    private int temp;

    public TreeNode convertBST(TreeNode root) {
        if(root == null) return root;
        reverseRootOrder(root);
        return root;
    }

    private void reverseRootOrder(TreeNode root) {
        if(root.right != null) reverseRootOrder(root.right);
        temp = root.val + temp;
        root.val = temp;
        if(root.left != null) reverseRootOrder(root.left);
    }
}
