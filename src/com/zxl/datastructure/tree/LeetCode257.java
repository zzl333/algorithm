package com.zxl.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。 EASY
 */
public class LeetCode257 {
    //解法一 ： dfs 隐式栈递归实现
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null) return list;
        recurse("",list,root);
        return list;
    }
    private void recurse(String s, List<String> list, TreeNode root){
        //第一个节点
        s = "".equals(s) ? s + String.valueOf(root.val) : s + "->" + String.valueOf(root.val);
        //叶子节点
        if(root.left == null && root.right == null){
            list.add(s);
            return;
        }
        //非叶子节点
        if(root.left != null) recurse(s, list, root.left);
        if(root.right != null) recurse(s,list,root.right);
    }

    //解法二：BFS迭代实现
        public List<String> binaryTreePaths2(TreeNode root) {
            List<String> paths = new ArrayList<String>();
            if (root == null) {
                return paths;
            }
            Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
            Queue<String> pathQueue = new LinkedList<String>();

            nodeQueue.offer(root);
            pathQueue.offer(Integer.toString(root.val));

            while (!nodeQueue.isEmpty()) {
                TreeNode node = nodeQueue.poll();
                String path = pathQueue.poll();

                if (node.left == null && node.right == null) {
                    paths.add(path);
                } else {
                    if (node.left != null) {
                        nodeQueue.offer(node.left);
                        pathQueue.offer(new StringBuffer(path).append("->").append(node.left.val).toString());
                    }

                    if (node.right != null) {
                        nodeQueue.offer(node.right);
                        pathQueue.offer(new StringBuffer(path).append("->").append(node.right.val).toString());
                    }
                }
            }
            return paths;
        }

}
