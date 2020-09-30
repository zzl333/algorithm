package com.zxl.datastructure.tree;

/**
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
 *
 * 思路：子顶向下递归，叶子节点扩展。
 */
public class LeetCode701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if(root == null) return node ;
        insert(root,node);
        return root;
    }
    //注意判断条件if else设计，回调的时候才不会破坏树的结构
    public void insert(TreeNode root, TreeNode node){
        if(node.val < root.val){
            if(root.left == null) root.left = node;
            else insert(root.left, node);
        }else{
            if(root.right == null) root.right = node;
            else insert(root.right,node);
        }
    }
}
