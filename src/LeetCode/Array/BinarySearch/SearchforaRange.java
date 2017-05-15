package LeetCode.Array.BinarySearch;

/**
 * Created by mayiwei on 2017/5/15.
 */
//https://leetcode.com/problems/search-for-a-range/#/description
public class SearchforaRange {

    public int[] searchRange(int[] nums, int target) {
        if (nums==null||nums.length==0) return new int[]{-1,-1};
        int[] res=new int[2];
        res[0]=findStart(nums,target);
        res[1]=findEnd(nums,target);
        return res;
    }

    private int findStart(int[] nums,int tartget){
        int res=-1,start=0,end=nums.length-1;
        while (start<=end){
            int mid=start+((end-start)>>1);
            if (nums[mid]>=tartget){
                end=mid-1;
            }else {
                start=mid+1;
            }
            if (nums[mid]==tartget) res=mid;
        }
        return res;
    }

    private int findEnd(int[] nums,int tartget){
        int res=-1,start=0,end=nums.length-1;
        while (start<=end){
            int mid=start+((end-start)>>1);
            if (nums[mid]>tartget){
                end=mid-1;
            }else {
                start=mid+1;
            }
            if (nums[mid]==tartget) res=mid;
        }
        return res;
    }


}
