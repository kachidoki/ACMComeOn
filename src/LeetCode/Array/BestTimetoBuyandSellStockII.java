package LeetCode.Array;

/**
 * Created by mayiwei on 2017/5/5.
 */
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/#/solutions
public class BestTimetoBuyandSellStockII {


    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0) return 0;
        int sum=0,buy=prices[0],sell=prices[0];
        for(int i=1;i<prices.length;i++){
            if(sell>=prices[i]){
                sum+=sell-buy;
                buy=prices[i];
                sell=prices[i];
            }else{
                sell=prices[i];
            }
        }
        sum+=sell-buy;
        return sum;
    }

    //简洁 寻找最近的最大最小值即可
    public int maxProfit2(int[] prices) {
        int profit = 0, i = 0;
        while (i < prices.length) {
            // find next local minimum
            while (i < prices.length-1 && prices[i+1] <= prices[i]) i++;
            int min = prices[i++]; // need increment to avoid infinite loop for "[1]"
            // find next local maximum
            while (i < prices.length-1 && prices[i+1] >= prices[i]) i++;
            profit += i < prices.length ? prices[i++] - min : 0;
        }
        return profit;
    }

    //Greedy
    public int maxProfit3(int[] prices) {
        int total = 0;
        for (int i=0; i< prices.length-1; i++) {
            if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
        }

        return total;
    }

}
