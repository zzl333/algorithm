package com.zxl.algorithm.recursive;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 */
public class LeetCode117 {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root == null) return root;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Node pre = queue.peek();
            Node node1 = null;
            for(int i = 0; i < size ; i++){
                if(node1 == null) {
                    node1 = queue.poll();
                }else{
                    node1 = queue.poll();
                    pre.next = node1;
                    pre = node1;
                }
                if(node1.left != null)  queue.offer(node1.left);
                if(node1.right != null) queue.offer(node1.right);
            }
            node1.next = null;
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
