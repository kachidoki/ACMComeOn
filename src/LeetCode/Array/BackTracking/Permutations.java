package LeetCode.Array.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayiwei on 2017/4/25.
 */
//https://leetcode.com/problems/permutations/#/description
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        DFS(res,cur,nums);
        return res;
    }

    public void DFS(List<List<Integer>> res,List<Integer> cur,int[] nums){
        if (cur.size()==nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (cur.contains(nums[i])) continue;
            cur.add(nums[i]);
            DFS(res,cur,nums);
            cur.remove(cur.size()-1);
        }
    }

}
