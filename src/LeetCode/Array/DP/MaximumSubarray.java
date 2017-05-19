package LeetCode.Array.DP;

/**
 * Created by mayiwei on 2017/4/21.
 */
//https://leetcode.com/problems/maximum-subarray/#/description
public class MaximumSubarray {

    //dp
    public int maxSubArray(int[] nums) {
        if (nums==null||nums.length==0) return 0;
        int last=nums[0],max=nums[0];
        for (int i=1;i<nums.length;i++){
            last=Math.max(last+nums[i],nums[i]);
            if (last>max) max=last;
        }
        return max;
    }

    //greedy
    public int maxSubArray2(int[] nums) {
        int sum=0,min=0,res=nums[0];
        for (int a:nums){
            sum+=a;
            if (sum-min>res) res=sum-min;
            if (sum<min) min=sum;
        }
        return res;
    }

}
