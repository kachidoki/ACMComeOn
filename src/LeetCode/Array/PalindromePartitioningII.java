package LeetCode.Array;

/**
 * Created by mayiwei on 2017/4/24.
 */
//https://leetcode.com/problems/palindrome-partitioning-ii/#/solutions
public class PalindromePartitioningII {

    public int minCut(String s) {
        char[] c=s.toCharArray();
        int n=c.length;
        int[] cut=new int[n];
        boolean[][] dp=new boolean[n][n];
        for (int i=0;i<n;i++){
            int min=i;
            for (int j=0;j<=i;j++){
                if (c[j]==c[i]&&(j+1>i-1||dp[j+1][i-1])){
                    dp[j][i]=true;
                    min=j==0?0:Math.min(min,cut[j-1]+1);
                }
            }
            cut[i]=min;
        }
        return cut[n-1];
    }

}
