package com.zxl.algorithm.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * //思路：暴力递归回溯
 *      解空间为深度为digits.length的X叉树，通过递归回溯的方式穷举所有解空间的值，这里没有枝剪条件
 */
public class LeetCode17 {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) return list;
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backTrack(list,map,digits,0,new StringBuffer());
        return list;
    }

    //解空间大小限定，递归先判断边界
    private void backTrack(List<String> list, Map<Character,String> map, String digits, int index, StringBuffer sb) {
        if(index == digits.length()){
            //到达边界
            list.add(sb.toString());
        }else{
            char c = digits.charAt(index);
            String s = map.get(c);
            for (char a : s.toCharArray()){
                sb.append(a);
                backTrack(list,map,digits,index + 1,sb);
                //第index位回溯
                sb.deleteCharAt(index);
            }
        }
    }
}
