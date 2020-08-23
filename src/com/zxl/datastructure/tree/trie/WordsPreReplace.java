package com.zxl.datastructure.tree.trie;

import java.util.List;

/**
 * 输入：dict(词典) = ["cat", "bat", "rat"] sentence(句子) = "the cattle was rattled by the battery"
 *输出："the cat was rat by the bat"
 *词根替换
 *此处的字典树形式是Map<字典树, String> String 为该字符串
 *如果sentence的前缀匹配到了前缀树的叶子节点，那么就用前缀树的叶子节点替换sentence中的字符串
 * @author zxl
 *
 */
public class WordsPreReplace {
    public String replaceWords(List<String> roots, String sentence) {
    	//手动字典树
        TrieNode trie = new TrieNode();
        //构造字典树 word为字符串
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

//手动字典树
class TrieNode {
    TrieNode[] children;
    String word;
    TrieNode() {
        children = new TrieNode[26];
    }
}