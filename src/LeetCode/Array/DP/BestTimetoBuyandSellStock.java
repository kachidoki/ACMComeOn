package LeetCode.Array.DP;

/**
 * Created by mayiwei on 2017/4/26.
 */
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/#/solutions
public class BestTimetoBuyandSellStock {

    public static void main(String[] args){
        maxProfit2(new int[]{7,1,5,3,6,4});
    }

    public static int maxProfit(int[] prices) {
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

    //dp
    public static int maxProfit2(int[] prices) {
        if (prices==null||prices.length==0) return 0;
        int lastBuy,buy=Integer.MIN_VALUE,sell=0;
        for (int i:prices){
            lastBuy=buy;
            buy=Math.max(-i,lastBuy);
            sell=Math.max(lastBuy+i,sell);
        }
        return sell;
    }

}
