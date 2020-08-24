package com.zxl.others;

/**
 * 459. 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000
 *
 * //思路，暴力加枝剪策略
 * 如果父串可以由n倍的字串构成，那么长度可以整除，且不会超过一半
 * 遍历方式也是如果不匹配直接枝剪
 */
public class Soution459 {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for(int i = 1; i <= len/2; i ++){
            if(len % i == 0) if(repeated(i,s) == true) return true;
        }
        return false;
    }

    private boolean repeated(int i, String s){
        for(int m = 0; m < i; m ++){
            for(int n = m + i; n < s.length(); n += i){
                if(s.charAt(n) != s.charAt(m)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Soution459().repeatedSubstringPattern("abcdabcd"));
    }
}
