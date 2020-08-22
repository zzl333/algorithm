package com.zxl.datastructure.tree.trie;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ����Ϊʹ���ֵ�����Ϊkey������Map<String,Integer> ����
 * ����val�ձ�ʾ�ýڵ�ֻ�������ַ���ǰ׺��!=null��ʾ��ǰ׺ӳ�������
 * �������������չ��������ӳ��ֻҪ�й̶���ǰ׺�ռ�
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
     * ���Ը��ַ�����Ϊǰ׺���ַ�����value�ĺ�
     * @param prefix
     * @return
     */
    public int sum(String prefix) {
        //�ҳ�ǰ׺ĩβ��ĸ�������;Ϊ����ֱ�ӷ���0
        char[] array = prefix.toCharArray();
        MapSum node = this;
        for(char c : array){
            if(node.mapSum[c - 'a'] == null) return 0;
            node = node.mapSum[c - 'a'];
        }
        int ans = 0;
        //������nodeΪ���ڵ��N�����������е�val������
        //�˴�������ʹ�õ�����bfs����ȡֵ
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