package LeetCode.Array.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayiwei on 2017/4/25.
 */
//https://leetcode.com/problems/combination-sum/#/description
public class CombinationSum {

    public static void main(String[] args){
        combinationSum(new int[]{2,3,6,7},7);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        DFS(candidates,0,target,res,cur);
        return res;
    }

    public static void DFS(int[] candidates,int start,int remain,List<List<Integer>> res,List<Integer> cur){
        if (remain==0){
            res.add(new ArrayList<>(cur));
        }else if (remain<0){
            return;
        }else {
            for (int i=start;i<candidates.length;i++){
                cur.add(candidates[i]);
                DFS(candidates,i,remain-candidates[i],res,cur);
                cur.remove(cur.size()-1);
            }
        }

    }


}
