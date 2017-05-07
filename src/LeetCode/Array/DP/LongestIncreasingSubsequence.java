package LeetCode.Array.DP;

import java.util.Arrays;

/**
 * Created by mayiwei on 2017/5/7.
 */
//https://leetcode.com/problems/longest-increasing-subsequence/#/description
public class LongestIncreasingSubsequence {

    //dp n2
    public int lengthOfLIS(int[] nums) {
        if (nums==null||nums.length==0) return 0;
        int n=nums.length,max=1;
        int[] dp=new int[n];
        dp[0]=1;
        for (int i=1;i<n;i++){
            int tmp=0;
            for (int j=0;j<i;j++){
                if (nums[i]>nums[j]&&dp[j]>tmp) tmp=dp[j];
            }
            dp[i]=tmp+1;
            if (max<dp[i]) max=dp[i];
        }
        return max;
    }

    //dp and Binary search
    //https://discuss.leetcode.com/topic/28738/java-python-binary-search-o-nlogn-time-with-explanation
    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }
        return len;
    }

    //同上
    public int lengthOfLIS3(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i=0, j=size;
            while (i!=j) {
                int m=(i+j)/2;
                if (tails[m]<x)
                    i=m+1;
                else
                    j=m;
            }
            tails[i]=x;
            if (i==size) size++;
        }
        return size;
    }

}
