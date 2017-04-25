package LeetCode.Array.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mayiwei on 2017/4/25.
 */
//https://leetcode.com/problems/permutations-ii/#/description
public class PermutationsII {


    public static void main(String[] args){
        permuteUnique(new int[]{1,1,0,0,1,-1,-1,1});
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        Arrays.sort(nums);
        DFS(res,cur,nums,used);
        return res;
    }

    public static void DFS(List<List<Integer>> res,List<Integer> cur,int[] nums,boolean[] used){
        if (cur.size()==nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (used[i]||i>0&&nums[i]==nums[i-1]&&!used[i-1]) continue;
            cur.add(nums[i]);
            used[i]=true;
            DFS(res,cur,nums,used);
            cur.remove(cur.size()-1);
            used[i]=false;
        }
    }
}
