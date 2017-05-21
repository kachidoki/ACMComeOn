package LeetCode.Array.Bit;

/**
 * Created by mayiwei on 2017/5/21.
 */
//https://leetcode.com/problems/single-number/#/description
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int res=0;
        for (int i=0;i<nums.length;i++){
            res^=nums[i];
        }
        return res;
    }

}
