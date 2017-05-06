package LeetCode.Array.DP;

/**
 * Created by mayiwei on 2017/5/5.
 */
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/#/description
public class BestTimetoBuyandSellStockIV {


    public static void main(String[] args){
        maxProfit(2,new int[]{3,1,2,4,2,1,4});
    }

    public static int maxProfit(int k, int[] prices) {
        if (prices==null||prices.length==0||k==0) return 0;
        if (k >= prices.length/2) {
            int maxPro = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i-1])
                    maxPro += prices[i] - prices[i-1];
            }
            return maxPro;
        }
        int[][] dp=new int[k][2];
        for (int i=0;i<k;i++){
            dp[i][0]=Integer.MIN_VALUE;
        }
        for (int i:prices) {
            for (int j=0;j<k;j++){
                if (j==0) dp[j][0]=Math.max(dp[j][0], -i);
                else dp[j][0]=Math.max(dp[j][0],dp[j-1][1]-i);
                dp[j][1]=Math.max(dp[j][1], dp[j][0]+i);
            }
        }
        return dp[k-1][1];
    }

}
