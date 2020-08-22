package com.zxl.datastructure.tree.trie;

/**
 * 该类为前缀树算法工具类
 * @author zxl
 *
 */
public class Trie {

    private Trie[] trie = null;
    private int K = 26;
    private boolean isEnd;

    public Trie() {
        trie = new Trie[K];
    }
    
    //插入字符串
    public void insert(String word) {
        Trie root = this;
        char[] array = word.toCharArray();
        for(int i = 0; i < array.length; i++){
            if(root.trie[array[i] - 'a'] == null){
                root.trie[array[i] - 'a'] = new Trie();
            }
            root = root.trie[array[i] - 'a'];
        }
        root.isEnd = true;
    }

    /**
     * 
     * @param word
     * @return 存在该前缀的字符串则返回该前缀的最后一个字符所在节点，如果不存在则返回null
     */
    private Trie searchPre(String word){
        Trie root = this;
        char[] array = word.toCharArray();
        for(char c : array){
            if(root.trie[c - 'a'] == null) return null;
            root = root.trie[c - 'a'];
        }
        return root;
    }
    
    /**
     * 	查找前缀树中是否存在该字符串
     * @param word
     * @return	前缀树中是否存在该字符串
     */
    public boolean search(String word) {
        Trie node = searchPre(word);
        return node != null && node.isEnd == true;
    }
    
    /**
     * 	是否存在以该字符串为前缀的字符串
     * @param prefix
     * @return
     */
    public boolean startsWith(String prefix) {
        Trie node = searchPre(prefix);
        return node != null;
    }
}