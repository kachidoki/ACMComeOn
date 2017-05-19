package LeetCode.Array.DP;

/**
 * Created by mayiwei on 2017/5/19.
 */
//https://leetcode.com/problems/unique-paths-ii/#/description
public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid==null||obstacleGrid.length==0||obstacleGrid[0].length==0) return 0;
        int row=obstacleGrid.length,col=obstacleGrid[0].length;
        int[] dp=new int[col];
        for (int j=0;j<col;j++){
            if (obstacleGrid[0][j]==1) break;
            else dp[j]=1;
        }
        for (int i=1;i<row;i++){
            if (obstacleGrid[i][0]==1) dp[0]=0;
            for (int j=1;j<col;j++){
                if (obstacleGrid[i][j]==1) dp[j]=0;
                else dp[j]+=dp[j-1];
            }
        }
        return dp[col-1];
    }

}
