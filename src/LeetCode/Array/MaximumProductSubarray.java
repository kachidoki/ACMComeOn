package LeetCode.Array;

/**
 * Created by mayiwei on 2017/4/21.
 */
//https://leetcode.com/problems/maximum-product-subarray/#/description
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums==null||nums.length==0) return 0;
        int max=nums[0],min=nums[0],res=nums[0];
        for (int i=1;i<nums.length;i++){
            int tmp=max;
            max=Math.max(Math.max(tmp*nums[i],min*nums[i]),nums[i]);
            min=Math.min(Math.min(tmp*nums[i],min*nums[i]),nums[i]);
            if(max>res) res=max;
        }
        return res;
    }

}
