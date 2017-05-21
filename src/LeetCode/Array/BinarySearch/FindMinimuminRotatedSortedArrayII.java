package LeetCode.Array.BinarySearch;

/**
 * Created by mayiwei on 2017/4/24.
 */
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/#/solutions
public class FindMinimuminRotatedSortedArrayII {

    public int findMin(int[] nums) {
        int left=0,right=nums.length-1,mid;
        while (left<right){
            mid=left+(right-left)/2;
            if (nums[mid]>nums[right]){
                left=mid+1;
            }else if (nums[mid]<nums[right]){
                right=mid;
            }else {
                right--;
            }
        }
        return nums[left];
    }


}
