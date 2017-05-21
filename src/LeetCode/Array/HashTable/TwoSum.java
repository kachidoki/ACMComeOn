package LeetCode.Array.HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mayiwei on 2017/5/21.
 */
//https://leetcode.com/problems/two-sum/#/solutions
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums==null) return new int[2];
        int n = nums.length;
        int[] res = new int[2];
        for (int i=0;i<n-1;i++){
            for (int j=i+1;j<n;j++){
                if (nums[i]+nums[j]==target){
                    res[0]=i;
                    res[1]=j;
                    return res;
                }
            }
        }
        return res;
    }

    //hashmap
    public int[] twoSum2(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
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

    //two pointer
    public int[] twoSum3(int[] numbers, int target) {
        if (numbers==null||numbers.length<2) return new int[2];
        Arrays.sort(numbers);
        int left=0,right=numbers.length-1;
        while (left<right){
            if (numbers[left]+numbers[right]>target){
                right--;
            }else if (numbers[left]+numbers[right]<target){
                left++;
            }else {
                return new int[]{numbers[left],numbers[right]};
            }
        }
        return new int[2];
    }

}
