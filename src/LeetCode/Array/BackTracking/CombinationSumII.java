package LeetCode.Array.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mayiwei on 2017/4/25.
 */
//https://leetcode.com/problems/combination-sum-ii/#/description
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        DFS(candidates,0,target,res,cur);
        return res;
    }

    public void DFS(int[] candidates,int start,int remain,List<List<Integer>> res,List<Integer> cur){
        if (remain==0){
            res.add(new ArrayList<>(cur));
        }else if (remain<0){
            return;
        }else {
            for (int i=start;i<candidates.length;i++){
                if (i>start&&candidates[i-1]==candidates[i]) continue;
                cur.add(candidates[i]);
                DFS(candidates,i+1,remain-candidates[i],res,cur);
                cur.remove(cur.size()-1);
            }
        }

    }

}
