package com.zxl.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
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

    public int sum(String prefix) {
        char[] array = prefix.toCharArray();
        MapSum node = this;
        for(char c : array){
            if(node.mapSum[c - 'a'] == null) return 0;
            node = node.mapSum[c - 'a'];
        }
        int ans = 0;
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