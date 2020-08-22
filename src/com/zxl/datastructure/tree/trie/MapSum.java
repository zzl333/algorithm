package com.zxl.datastructure.tree.trie;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 该类为使用字典树作为key的类似Map<String,Integer> 集合
 * 其中val空表示该节点只是其他字符的前缀，!=null表示该前缀映射的数字
 * 这里可以随意扩展成是其他映射只要有固定的前缀空间
 * @author zxl
 *
 */
class MapSum {

    private int K = 26;
    private MapSum[] mapSum = null;
    private Integer val;
    
    public MapSum() {
        mapSum = new MapSum[K];
    }
    
    public void insert(String key, int val) {
        char[] array = key.toCharArray();
        MapSum node = this;
        for(char c : array){
            if(node.mapSum[c - 'a'] == null) node.mapSum[c - 'a'] = new MapSum();
            node = node.mapSum[c - 'a'] ;
        }
        node.val = val;
    }
    
    /**
     * 求以该字符串作为前缀的字符串的value的和
     * @param prefix
     * @return
     */
    public int sum(String prefix) {
        //找出前缀末尾字母，如果中途为空则直接返回0
        char[] array = prefix.toCharArray();
        MapSum node = this;
        for(char c : array){
            if(node.mapSum[c - 'a'] == null) return 0;
            node = node.mapSum[c - 'a'];
        }
        int ans = 0;
        //遍历以node为根节点的N叉树，将所有的val加起来
        //此处适宜于使用迭代的bfs来获取值
        Queue<MapSum> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                MapSum temp = queue.poll();
                if(temp.val != null) ans += temp.val;
                for(int j = 0; j < K; j++){
                    if(temp.mapSum[j] != null) queue.offer(temp.mapSum[j]);
                }
            }
        }
        return ans;
    }
}