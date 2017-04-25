package LeetCode.Array.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayiwei on 2017/4/25.
 */
//https://leetcode.com/problems/subsets/#/description
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        DFS(res,cur,nums,0);
        return res;
    }

    public void DFS(List<List<Integer>> res,List<Integer> cur,int[] nums,int start){
        res.add(new ArrayList<>(cur));
        for (int i=start;i<nums.length;i++){
            cur.add(nums[i]);
            DFS(res,cur,nums,i+1);
            cur.remove(cur.size()-1);
        }
    }

}
