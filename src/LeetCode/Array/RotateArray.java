package LeetCode.Array;

/**
 * Created by mayiwei on 2017/4/3.
 */
//https://leetcode.com/problems/rotate-array/#/description
public class RotateArray {


    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6,7};
        rotate(a,3);
    }

    public static void rotate(int[] nums, int k) {
        if (nums==null) return;
        int len = nums.length;
        k%=len;
        if (k<=0) return;
        reserve(nums,0,len-1);
        reserve(nums,0,k-1);
        reserve(nums,k,len-1);
    }

    public static void reserve(int[] nums,int start,int end){
        int tmp;
        while (start<end){
            tmp=nums[start];
            nums[start--]=nums[end];
            nums[end--]=tmp;
        }

    }
}
