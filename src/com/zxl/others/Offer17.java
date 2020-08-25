package com.zxl.others;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 */
public class Offer17 {
    /**
     * 不考虑大数
     * @param n
     * @return
     */
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
    /**
     * 考虑大数
     * 难点：大数超界限，且难遍历问题，且每次都必须检测是否完成
     * 思路：String加一加法器，配置加法器返回枝剪
     */
    public void printNumbers1(int n) {
        StringBuffer sb = new StringBuffer("1");
        String tem = "1" ;
        while(true){
            tem = addOne(tem,n);
            if(tem == null) break;
            sb.append(" " + tem);
        }
        System.out.println(sb.toString());
    }

    //如果不行就返回空
    private String addOne(String tem, int n) {
        StringBuffer sb = new StringBuffer();
        int x = 0;
        int i = 0;
        while(i < tem.length() || x !=0){
            if(i == 0) {
                int z = tem.charAt(i) - '0' + 1;
                x = z /10;
                sb.append(z % 10);
            }else{
                if(x == 1){
                    x = (tem.charAt(i) - '0' + x) / 10;
                    sb.append((tem.charAt(i) - '0' + x) % 10);
                }else{
                    sb.append(tem.substring(0,i+1));
                    break;
                }
            }
        }
        if(sb.length() > n) return null;
        return sb.toString();
    }

}
