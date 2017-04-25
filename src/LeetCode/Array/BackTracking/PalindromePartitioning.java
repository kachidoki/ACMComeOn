package LeetCode.Array.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mayiwei on 2017/4/23.
 */
//https://leetcode.com/problems/palindrome-partitioning/#/solutions
public class PalindromePartitioning {


    public static List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> cur = new ArrayList<>();
        boolean[][] dp=new boolean[s.length()][s.length()];
        for (int i=0;i<s.length();i++){
            for (int j=0;j<=i;j++){
                if (isPalindrome(s,j,i,dp)) dp[j][i]=true;
            }
        }
        DFS(s,0,res,cur,dp);
        return res;
    }

    public static void DFS(String s,int start,List<List<String>> res,List<String> cur,boolean[][] dp){
        if (start==s.length()){
            res.add(new ArrayList<>(cur));
        }
        for (int i=start;i<s.length();i++){
            if (dp[start][i]){
                cur.add(s.substring(start,i+1));
                DFS(s,i+1,res,cur,dp);
                cur.remove(cur.size()-1);
            }
        }

    }

    public static boolean isPalindrome(String s,int start,int end,boolean[][] dp){
        return (s.charAt(start)==s.charAt(end))&&(end-start<=2||dp[start+1][end-1]);
    }


}
