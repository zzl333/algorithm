package com.zxl.datastructure.tree.trie.com.zxl.others;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
    	List<Integer> list = new ArrayList<>();
    	int[] re = new int[n];
    	re[rounds[0]-1] ++;
    	for(int i = 0; i < rounds.length-1; i++) {
    		if(rounds[i+1] > rounds[i]) {
    			for(int j = rounds[i] + 1; j <= rounds[i+1] ; j ++) {
    				re[j-1]++;
    			}
    		}else {
    			for(int j = rounds[i] + 1; j <= n ; j ++) {
    				re[j-1]++;
    			}
    			for(int j = 0; j < rounds[i+1] ; j++) {
    				re[j]++;
    			}
    		}
    	}
    	int max = Integer.MIN_VALUE;
    	for(int num : re) {
    		max = Math.max(max, num);
    	}
    	for(int i = 0; i < n; i++) {
    		if(re[i] == max) list.add(i+1);
    	}
    	return list;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().mostVisited(4, new int[] {1,3,1,2}));
	}
}