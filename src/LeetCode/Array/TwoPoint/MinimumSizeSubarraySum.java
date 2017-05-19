package LeetCode.Array.TwoPoint;

/**
 * Created by mayiwei on 2017/5/16.
 */
//https://leetcode.com/problems/minimum-size-subarray-sum/#/description
public class MinimumSizeSubarraySum {

    public static void main(String[] args){
        minSubArrayLen2(7,new int[]{2,3,1,2,4,3});
    }

    //O(N)
    public static int minSubArrayLen(int s,int[] nums) {
        if (nums==null||nums.length==0) return 0;
        int target=s,begin=0,end=0,min=Integer.MAX_VALUE;
        while (end<nums.length){
            if (target>0) target-=nums[end++];
            while (target<=0){
                if (end-begin<min) min=end-begin;
                target+=nums[begin++];
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }

    //O(NLogN) 对窗口值进行两分
    public static int minSubArrayLen2(int s,int[] nums){
        int l=1,r=nums.length,min=0;
        while (l<=r){
            int mid=(l+r)/2;
            if (windowExist(mid,nums,s)){
                r=mid-1;
                min=mid;
            }else {
                l=mid+1;
            }
        }
        return min;
    }

    private static boolean windowExist(int size,int[] nums,int target){
        int sum=0;
        for (int i=0;i<nums.length;i++){
            if (i>=size) sum-=nums[i-size];
            sum+=nums[i];
            if (sum>=target) return true;
        }
        return false;
    }

}
