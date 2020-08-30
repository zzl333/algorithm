package com.zxl.datastructure.string;


import java.util.Arrays;


/*
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
public class Solution557 {
    public String reverseWords(String s) {
        String[] strs  = new  StringBuffer(s).reverse().toString().split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = strs.length - 1; i > 0; i--){
            sb.append(strs[i] + " ");
        }
        sb.append(strs[0]);
        return sb.toString();
    }
}
