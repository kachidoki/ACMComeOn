package LeetCode.Array.DP;

/**
 * Created by mayiwei on 2017/5/13.
 */
//https://leetcode.com/problems/dungeon-game/#/description
public class DungeonGame {

    public static void main(String[] args){
        calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}});
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        if (dungeon==null||dungeon.length==0) return 0;
        int row=dungeon.length,col=dungeon[0].length;
        int[][] dp=new int[col][2];//[0]leftHP [1]min
        for (int j=0;j<col;j++){
            if (j==0) dp[j][0]=dungeon[0][j];
            else dp[j][0]=dp[j-1][0]+dungeon[0][j];
            if (dp[j][0]<=0){
                if (j==0) dp[j][1]+=1-dp[j][0];
                else dp[j][1]=dp[j-1][1]+1-dp[j][0];
                dp[j][0]=1;
            }else {
                if (j!=0) dp[j][1]=dp[j-1][1];
            }
        }
        for (int i=1;i<row;i++){
            for (int j=0;j<col;j++){
                if (j==0) dp[j][0]+=dungeon[i][j];
                else dp[j][0]=Math.max(dp[j-1][0],dp[j][0])+dungeon[i][j];
                if (dp[j][0]<=0) {
                    dp[j][1]+=1-dp[j][0];
                    dp[j][0]=1;
                }
            }
        }
        return dp[col-1][1];
    }

    public int calculateMinimumHP2(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] health = new int[m][n];
        health[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);
        for (int i = m - 2; i >= 0; i--) {
            health[i][n - 1] = Math.max(health[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }
        for (int j = n - 2; j >= 0; j--) {
            health[m - 1][j] = Math.max(health[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(health[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(health[i][j + 1] - dungeon[i][j], 1);
                health[i][j] = Math.min(right, down);
            }
        }
        return health[0][0];
    }

}
