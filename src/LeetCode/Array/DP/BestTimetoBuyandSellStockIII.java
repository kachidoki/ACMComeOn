package LeetCode.Array.DP;

/**
 * Created by mayiwei on 2017/5/5.
 */
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/#/description
public class BestTimetoBuyandSellStockIII {

    public static void main(String[] args){
        maxProfit(new int[]{3,1,2,3,2,0,4});
    }

    //dp
    public static int maxProfit(int[] prices) {
        int sell1 = 0, buy1 = Integer.MIN_VALUE;
        int sell2 = 0, buy2 = Integer.MIN_VALUE;
        for (int i:prices) {
            buy1 = Math.max(buy1, -i);
            sell1 = Math.max(sell1, buy1 + i);
            buy2 = Math.max(buy2, sell1 - i);
            sell2 = Math.max(sell2, buy2 + i);
        }
        return sell2;
    }

}
