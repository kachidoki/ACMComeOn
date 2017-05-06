package LeetCode.Array.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayiwei on 2017/5/6.
 */
//https://leetcode.com/problems/combinations/#/description
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        DFS(res,cur,1,n,k);
        return res;
    }

    public void DFS(List<List<Integer>> res,List<Integer> cur,int start,int n,int k){
        if (k==0){
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i=start;i<=n;i++){
            cur.add(i);
            DFS(res,cur,i+1,n,k-1);
            cur.remove(cur.size()-1);
        }
    }

}
