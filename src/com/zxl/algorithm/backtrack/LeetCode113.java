package com.zxl.algorithm.backtrack;

import com.zxl.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 */
public class LeetCode113 {
    private int sum;
    private List<List<Integer>> lists = null;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        lists = new ArrayList<>();
        if(root == null) return lists;
        List<Integer> list = new ArrayList<>();
        this.sum = sum;
        backTrack(root, list, 0);
        return lists;
    }

    //回溯
    private void backTrack(TreeNode root, List<Integer> list , int count){
        list.add(root.val);
        count = count + root.val;
        //边界判断
        if(root.left == null && root.right == null){
            if(count == sum)
                lists.add(new ArrayList<>(list));
            return;
        }
        if(root.left != null) {
            backTrack(root.left,list,count);
            list.remove(list.size()-1);
        }
        if(root.right != null) {
            backTrack(root.right,list,count);
            list.remove(list.size()-1);
        }

    }
}
