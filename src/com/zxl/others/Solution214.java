package com.zxl.others;

import java.util.Arrays;

/**
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 */
class Solution214 {
    //方法一，思路：反转拼接；超时  O(n^2)
    public String shortestPalindrome(String s) {
        StringBuffer sb = new StringBuffer(s).reverse();
        String temp = "";
        char[] array = sb.toString().toCharArray();
        for(int i = 0; i < array.length; i++){
            if(sb.length()%2 == 0 && palindrome(sb.toString(),sb.length()/2-1, sb.length()/2))
                break;
            if(sb.length()%2 == 1 && palindrome(sb.toString(),sb.length()/2-1, sb.length()/2 + 1))
                break;
            temp = sb.substring(array.length,sb.length());
            sb = sb.delete(array.length,sb.length());
            sb.append(array[i]);
            sb.append(temp);
        }
        return sb.toString();
    }

    private boolean palindrome(String s , int left, int right) {
        while(left >=0){
            if(s.charAt(left) != s.charAt(right)) return false;
            --left;
            ++right;
        }
        return true;
    }

    //方法2：KMP，O(n)
    public String shortestPalindrome1(String s) {
        int n = s.length();
        int[] fail = new int[n];
        Arrays.fill(fail, -1);
        for (int i = 1; i < n; ++i) {
            int j = fail[i - 1];
            while (j != -1 && s.charAt(j + 1) != s.charAt(i)) {
                j = fail[j];
            }
            if (s.charAt(j + 1) == s.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        int best = -1;
        for (int i = n - 1; i >= 0; --i) {
            while (best != -1 && s.charAt(best + 1) != s.charAt(i)) {
                best = fail[best];
            }
            if (s.charAt(best + 1) == s.charAt(i)) {
                ++best;
            }
        }
        String add = (best == n - 1 ? "" : s.substring(best + 1));
        StringBuffer ans = new StringBuffer(add).reverse();
        ans.append(s);
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println("aacecaaa");
        System.out.println(new Solution214().shortestPalindrome("abcd"));
    }
}