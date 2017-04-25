package LeetCode.Array;

/**
 * Created by mayiwei on 2017/4/24.
 */
//https://leetcode.com/problems/find-peak-element/#/description
public class FindPeakElement {

    public static void main(String[] args){
        findPeakElement(new int[]{1,2,3,4,2,1});
    }


    public static int findPeakElement(int[] nums) {
        if (nums==null||nums.length==0) return -1;
        if (nums.length==1) return 0;
        int n=nums.length;
        int left=0,right=n-1,mid;
        while (left<right){
            if (nums[left]>nums[left+1]) return left;
            if (nums[right]>nums[right-1]) return right;
            mid=left+(right-left)/2;
            if (nums[mid-1]<nums[mid]&&nums[mid]>nums[mid+1]){
                return mid;
            }else if (nums[mid-1]<nums[mid]&&nums[mid]<nums[mid+1]){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return nums[left];
    }


}
