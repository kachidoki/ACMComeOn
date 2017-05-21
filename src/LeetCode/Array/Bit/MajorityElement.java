package LeetCode.Array.Bit;

import java.util.Arrays;

/**
 * Created by mayiwei on 2017/4/25.
 */
//https://leetcode.com/problems/majority-element/#/description
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int num=nums[0],count=1;
        for (int i=1;i<nums.length;i++){
            if (count==0){
                num=nums[i];
                count++;
            }else if (num==nums[i]){
                count++;
            }else {
                count--;
            }
        }
        return num;
    }

    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    // Bit manipulation
    public int majorityElement2(int[] nums) {
        int[] bit = new int[32];
        for (int num: nums)
            for (int i=0; i<32; i++)
                if ((num>>(31-i) & 1) == 1)
                    bit[i]++;
        int ret=0;
        for (int i=0; i<32; i++) {
            bit[i]=bit[i]>nums.length/2?1:0;
            ret += bit[i]*(1<<(31-i));
        }
        return ret;
    }

}
