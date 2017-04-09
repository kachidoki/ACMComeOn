package LeetCode.Array;

import java.util.*;

/**
 * Created by mayiwei on 2017/4/9.
 */
//https://leetcode.com/problems/3sum/#/description
public class ThreeSum {


    public static void main(String[] args){
        threeSum2(new int[]{0,0,0});
    }


    //tle写法
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums==null||nums.length<3) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n=nums.length;
        for (int i=0;i<n-2;i++){
            for (int j=i+1;j<n-1;j++){
                for (int k=n-1;j<k;k--){
                    if (nums[i]+nums[j]+nums[k]==0){
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                    while(j<k&&nums[k] == nums[k-1]) k--;
                }
                while(j<n-1&&nums[j] == nums[j+1] ) j++;
            }
            while (i<n-2&&nums[i]==nums[i+1]) i++;
        }
        return res;
    }

    //简洁，基于两分
    public static List<List<Integer>> threeSum2(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

}
