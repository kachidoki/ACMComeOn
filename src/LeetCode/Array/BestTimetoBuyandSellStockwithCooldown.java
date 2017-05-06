package LeetCode.Array;

/**
 * Created by mayiwei on 2017/5/5.
 */
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/#/solutions
public class BestTimetoBuyandSellStockwithCooldown {

    public static void main(String[] args){
        maxProfit(new int[]{1, 2, 3, 0, 2});
    }

    //完整的dp
    public static int maxProfit(int[] prices){
        int lastBuy,buy=Integer.MIN_VALUE,lastRest,rest=0,lastSell=0,sell=0;
        for (int i:prices){
            lastBuy=buy;
            lastRest=rest;
            lastSell=sell;
            buy=Math.max(lastRest-i,lastBuy);
            sell=Math.max(lastBuy+i,lastSell);
            rest=Math.max(lastRest,lastSell);
        }
        return sell;
    }

    //另外，由于冷冻期的存在，我们可以得出rest[i] = sell[i-1]，这样，我们可以将上面三个递推式精简到两个：
    //buy[i]  = max(sell[i-2] - price, buy[i-1])
    //sell[i] = max(buy[i-1] + price, sell[i-1])

    //优化的dp
    public static int maxProfit2(int[] prices) {
        int sell = 0, pre_sell = 0, buy = Integer.MIN_VALUE, pre_buy;
        for (int price : prices) {
            pre_buy = buy;
            buy = Math.max(pre_sell - price, pre_buy);
            pre_sell = sell;
            sell = Math.max(pre_buy + price, pre_sell);
        }
        return sell;
    }

}
