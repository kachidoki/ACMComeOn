package LeetCode.Array.BinarySearch;

/**
 * Created by mayiwei on 2017/4/24.
 */
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/#/description
public class FindMinimuminRotatedSortedArray {

    public int findMin(int[] nums) {
        for (int i=0;i<nums.length-1;i++){
            if (nums[i]>nums[i+1]) return nums[i+1];
        }
        return nums[0];
    }


    public int findMin2(int[] num) {
        int left=0,right=num.length-1,mid;
        while (left<right){
            if (num[left]<num[right]) return num[left];
            mid=left+(right-left)/2;
            if (num[left]<=num[mid]){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return num[left];
    }

}
