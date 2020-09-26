package com.zxl.datastructure.tree;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 使用递归对称遍历，不对成枝剪
 */
public class Offer28 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirrorTree(root.left, root.right);
    }

    private boolean isMirrorTree(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null || left.val != right.val) return false;

        return isMirrorTree(left.left,right.right) && isMirrorTree(left.right,right.left);
    }
}
