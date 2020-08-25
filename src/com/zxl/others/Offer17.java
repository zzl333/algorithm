package com.zxl.others;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 */
public class Offer17 {
    public int[] printNumbers(int n) {
        int x = 0;
        for(int i = 0; i < n; i++){
            x = x * 10 + 9;
        }
        int[] ans = new int[x];
        for(int i = 1; i <= x; i++){
            ans[i-1] = i;
        }
        return ans;
    }
}
