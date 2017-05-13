package LeetCode.Array.DP;

/**
 * Created by mayiwei on 2017/5/13.
 */
//https://leetcode.com/problems/house-robber-ii/#/description
public class HouseRobberII {

    public int rob(int[] nums) {
        if (nums==null||nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        return Math.max(rob(nums,1,nums.length-1),rob(nums,0,nums.length-2));
    }

    public int rob(int[] nums,int s,int e) {
        int rob = 0;
        int notrob = 0;
        for(int i=s; i<=e; i++) {
            int currob = notrob + nums[i];
            notrob = Math.max(notrob, rob);
            rob = currob;
        }
        return Math.max(rob, notrob);
    }

}
