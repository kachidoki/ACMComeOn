package LeetCode.Array;


/**
 * Created by mayiwei on 2017/4/3.
 */
//https://leetcode.com/problems/longest-palindromic-substring/#/description
public class LongestPalindromicSubstring {


    public static void main(String[] args){
        longestPalindrome2("babad");
    }

    public static String longestPalindrome(String s) {
        char[] ss=s.toCharArray();
        char[] rs=reserve(ss,ss.length);
        if (ss.length==1) return s;
        int[][] dp = new int[ss.length][ss.length];
        for (int i=0;i<ss.length;i++){
            for (int j=0;j<ss.length;j++){
                if (ss[i]==rs[j]) dp[j][i]=1;
            }
        }
        int max=0,sx=0;
        for (int i=1;i<ss.length;i++){
            for (int j=1;j<ss.length;j++){
                if (dp[j-1][i-1]!=0&& dp[j][i]!=0) {
                    dp[j][i]=dp[j-1][i-1]+1;
                    if (dp[j][i]>max) {
                        max = dp[j][i];
                        sx=i;
                    }
                }
            }
        }
        if (max==0) return s.substring(0,1);
        return sx<ss.length-1?s.substring(sx-max+1,sx+1):s.substring(sx-max+1);
    }


    public static char[] reserve(char[] s,int n){
        char[] re = new char[n];
        for (int i=0;i<n;i++){
            re[i]=s[n-i-1];
        }
        return re;
    }


    public static String longestPalindrome2(String s) {
        if (s==null) return null;
        int n=s.length();
        boolean[][] dp = new boolean[n][n];//dp[i][j]表示s[i..j]是否是回文
        dp[0][0]=true;
        for (int i=1;i<n;i++){
            dp[i][i]=true;
            dp[i][i-1]=true;
        }
        int start=0,end=0;
        for (int i=1;i<n;i++){//枚举子串长度
            for (int j=0;j<n-i;j++){//枚举子串起始位置
                if (s.charAt(j)==s.charAt(j+i)&&dp[j+1][j+i-1]){
                    dp[j][j+i]=true;
                    if (end-start<i){
                        start=j;
                        end=j+i;
                    }
                }
            }
        }

        return end+1<n?s.substring(start,end+1):s.substring(start);
    }


}
