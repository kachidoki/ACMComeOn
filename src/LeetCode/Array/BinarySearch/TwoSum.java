package LeetCode.Array.BinarySearch;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mayiwei on 2017/4/8.
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums==null) return new int[2];
        int n = nums.length;
        int[] res = new int[2];
        int last=Integer.MAX_VALUE;
        for (int i=0;i<n-1;i++){
            if(nums[i]==last) continue;
            last=nums[i];
            for (int j=i+1;j<n;j++){
                if (nums[i]+nums[j]==target){
                    res[0]=i+1;
                    res[1]=j+1;
                    return res;
                }
            }
        }
        return res;
    }
    //map记忆
    public int[] twoSum3(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i + 1;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i + 1);
        }
        return result;
    }

    //有序两分
    public int[] twoSum2(int[] nums, int target) {
        if (nums==null) return new int[]{};
        int last=Integer.MAX_VALUE;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==last) continue;
            last=nums[i];
            int start=i+1,end=nums.length-1,gap=target-nums[i];
            while (start<=end){
                int mid=start+(end-start)/2;
                if (nums[mid]==gap) return new int[]{i+1,mid+1};
                else if (nums[mid]>gap) end=mid-1;
                else start=mid+1;
            }
        }
        return new int[]{};
    }


}
