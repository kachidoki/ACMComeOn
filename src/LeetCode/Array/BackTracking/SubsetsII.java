package LeetCode.Array.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mayiwei on 2017/4/25.
 */
//https://leetcode.com/problems/subsets-ii/#/description
public class SubsetsII {


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        DFS(res,cur,nums,0);
        return res;
    }

    public void DFS(List<List<Integer>> res,List<Integer> cur,int[] nums,int start){
        res.add(new ArrayList<>(cur));
        for (int i=start;i<nums.length;i++){
            if (i>start&&nums[i-1]==nums[i]) continue;
            cur.add(nums[i]);
            DFS(res,cur,nums,i+1);
            cur.remove(cur.size()-1);
        }
    }

}
