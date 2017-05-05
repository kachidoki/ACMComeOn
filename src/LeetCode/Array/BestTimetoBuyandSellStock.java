package LeetCode.Array;

/**
 * Created by mayiwei on 2017/4/26.
 */
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/#/solutions
public class BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {
        if (prices==null||prices.length==0) return 0;
        int max=0,min=prices[0];
        for (int i=1;i<prices.length;i++){
            if (prices[i]>min){
                max=Math.max(max,prices[i]-min);
            }else {
                min=prices[i];
            }
        }
        return max;
    }

}
