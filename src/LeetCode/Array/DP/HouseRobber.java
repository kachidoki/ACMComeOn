package LeetCode.Array.DP;

/**
 * Created by mayiwei on 2017/5/12.
 */
//https://leetcode.com/problems/house-robber/#/description
public class HouseRobber {

    //dp
    public int rob(int[] num) {
        int[][] dp = new int[num.length + 1][2];
        for (int i = 1; i <= num.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = num[i - 1] + dp[i - 1][0];
        }
        return Math.max(dp[num.length][0], dp[num.length][1]);
    }

    //优化
    public int rob2(int[] nums) {
        int rob = 0;
        int notrob = 0;
        for(int i=0; i<nums.length; i++) {
            int currob = notrob + nums[i];
            notrob = Math.max(notrob, rob);
            rob = currob;
        }
        return Math.max(rob, notrob);
    }

}
