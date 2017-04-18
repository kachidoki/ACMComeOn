package LeetCode.Array;

import java.util.Arrays;

/**
 * Created by mayiwei on 2017/4/17.
 */
//https://leetcode.com/problems/longest-consecutive-sequence/#/description
public class LongestConsecutiveSequence {

    public static void main(String[] args){
        longestConsecutive(new int[]{1,2,0,1});
    }

    public static int longestConsecutive(int[] nums) {
        if (nums==null||nums.length==0) return 0;
        Arrays.sort(nums);
        int max=1,last=1;
        for (int i=1;i<nums.length;i++){
            if (nums[i]==nums[i-1]) continue;
            if (nums[i]==nums[i-1]+1)
                last=last+1;
            else
                last=1;
            if (max<last) max=last;
        }
        return max;
    }

}
