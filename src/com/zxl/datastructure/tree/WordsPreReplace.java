package com.zxl.datastructure.tree;

import java.util.List;

/**
 * ���룺dict(�ʵ�) = ["cat", "bat", "rat"] sentence(����) = "the cattle was rattled by the battery"
 *�����"the cat was rat by the bat"
 *�ʸ��滻
 *�˴����ֵ�����ʽ��Map<�ֵ���, String> String Ϊ���ַ���
 *���sentence��ǰ׺ƥ�䵽��ǰ׺����Ҷ�ӽڵ㣬��ô����ǰ׺����Ҷ�ӽڵ��滻sentence�е��ַ���
 * @author zxl
 *
 */
public class WordsPreReplace {
    public String replaceWords(List<String> roots, String sentence) {
    	//�ֶ��ֵ���
        TrieNode trie = new TrieNode();
        //�����ֵ��� wordΪ�ַ���
        for (String root: roots) {
            TrieNode cur = trie;
            for (char letter: root.toCharArray()) {
                if (cur.children[letter - 'a'] == null)
                    cur.children[letter - 'a'] = new TrieNode();
                cur = cur.children[letter - 'a'];
            }
            cur.word = root;
        }

        StringBuilder ans = new StringBuilder();

        for (String word: sentence.split("\\s+")) {
            if (ans.length() > 0)
                ans.append(" ");

            TrieNode cur = trie;
            for (char letter: word.toCharArray()) {
                if (cur.children[letter - 'a'] == null || cur.word != null)
                    break;
                cur = cur.children[letter - 'a'];
            }
            ans.append(cur.word != null ? cur.word : word);
        }
        return ans.toString();
    }
}

//�ֶ��ֵ���
class TrieNode {
    TrieNode[] children;
    String word;
    TrieNode() {
        children = new TrieNode[26];
    }
}