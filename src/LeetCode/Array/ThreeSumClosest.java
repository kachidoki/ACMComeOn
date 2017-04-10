package LeetCode.Array;

import java.util.Arrays;

/**
 * Created by mayiwei on 2017/4/9.
 */
//https://leetcode.com/problems/3sum-closest/#/solutions
public class ThreeSumClosest {


    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        int left,right,sum;
        for (int i=0;i<nums.length-2;i++){
            left=i+1;
            right=nums.length-1;
            while (left<right){
                sum = nums[i]+nums[left]+nums[right];
                if (sum<target){
                    left++;
                }else {
                    right--;
                }
                if (Math.abs(sum-target)<Math.abs(res-target)){
                    res=sum;
                }
                if (res-target==0) return res;

            }
        }
        return res;
    }


}
