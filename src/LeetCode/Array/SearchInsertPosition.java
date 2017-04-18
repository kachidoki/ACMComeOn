package LeetCode.Array;

/**
 * Created by mayiwei on 2017/4/17.
 */
//https://leetcode.com/problems/search-insert-position/#/description
public class SearchInsertPosition {


    public static void main(String[] args){
        searchInsert(new int[]{1,3,5},4);
    }

    public static int searchInsert(int[] nums, int target) {
        int start=0,end=nums.length-1,mid;
        while (start<=end){
            mid = start+(end-start)/2;
            if (nums[mid]<target){
                start=mid+1;
            }else if (nums[mid]>target){
                end=mid-1;
            }else {
                return mid;
            }
        }
        if (start>=nums.length) return start;
        if (end<0) return 0;
        if (target>nums[start]) return start+1;
        else
        if (start-1<0) return 0;
        else return start;
    }

}
