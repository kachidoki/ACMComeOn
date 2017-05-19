package LeetCode.Array.DP;

/**
 * Created by mayiwei on 2017/5/18.
 */
//https://leetcode.com/problems/minimum-path-sum/#/description
public class MinimumPathSum {

    public static int minPathSum(int[][] grid) {
        if (grid==null||grid.length==0||grid[0].length==0) return 0;
        int row=grid.length,col=grid[0].length;
        int[] dp=new int[col];
        for (int j=0;j<col;j++){
            if (j==0) dp[j]=grid[0][0];
            else dp[j]=dp[j-1]+grid[0][j];
        }
        for (int i=1;i<row;i++){
            for (int j=0;j<col;j++){
                if (j==0) dp[j]+=grid[i][j];
                else dp[j]=Math.min(dp[j-1],dp[j])+grid[i][j];
            }
        }
        return dp[col-1];
    }

}
