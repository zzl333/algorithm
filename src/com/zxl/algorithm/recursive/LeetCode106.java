package com.zxl.algorithm.recursive;


/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 */

import com.zxl.datastructure.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路：二叉树的后续遍历和先序遍历，一个为后面是根节点，一个是前面是根节点，对生成二叉树都有帮助，具体为从
 * 后续遍历中从右往左遍历，获取元素将中序遍历从该数组划分为左右两个部分，即为其左右子树的元素，本生就为根节点
 * 使用递归思想，边界为当中序遍历的左边索引>右边索引 返回null.
 *
 * 此题使用递归思想，注意点为先右子树后左子树，因为后序遍历的反过来，是先右子树后左子树的
 *
 * 使用map保存中序遍历的值和index的映射，为了更好的获取相关分界索引，将检索复杂度降为O(1);
 */
public class LeetCode106 {

    //后续遍历索引
    private int index;
    //map
    private Map<Integer, Integer> map = new HashMap<>();


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //非法输入判断
        if(inorder == null ||
                postorder == null ||
                postorder.length != inorder.length ||
                inorder.length == 0 ||
                postorder.length ==0)
            return null;
        index = postorder.length;
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(inorder, postorder, 0, inorder.length);

    }

    private TreeNode build(int[] inorder, int[] postorder, int left, int rigth) {
        //边界条件判断
        if(left > rigth) return null;

        TreeNode node = new TreeNode(postorder[index]);
        Integer temp = map.get(postorder[index]);
        index--;
        node.right = build(inorder, postorder, temp + 1, rigth);
        node.left = build(inorder, postorder, left, temp - 1);
        return node;
    }
}
