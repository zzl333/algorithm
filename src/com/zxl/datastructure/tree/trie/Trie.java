package com.zxl.datastructure.tree.trie;

/**
 * ����Ϊǰ׺���㷨������
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
    
    //�����ַ���
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
     * @return ���ڸ�ǰ׺���ַ����򷵻ظ�ǰ׺�����һ���ַ����ڽڵ㣬����������򷵻�null
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
     * 	����ǰ׺�����Ƿ���ڸ��ַ���
     * @param word
     * @return	ǰ׺�����Ƿ���ڸ��ַ���
     */
    public boolean search(String word) {
        Trie node = searchPre(word);
        return node != null && node.isEnd == true;
    }
    
    /**
     * 	�Ƿ�����Ը��ַ���Ϊǰ׺���ַ���
     * @param prefix
     * @return
     */
    public boolean startsWith(String prefix) {
        Trie node = searchPre(prefix);
        return node != null;
    }
}