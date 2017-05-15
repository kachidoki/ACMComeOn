package LeetCode.Array.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayiwei on 2017/5/14.
 */
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/#/description
public class LetterCombinationsofaPhoneNumber {

    private static final String[] KEYS={ "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if (digits==null||digits.length()==0) return res;
        StringBuilder sb=new StringBuilder();
        DFS(res,sb,digits,0,digits.length());
        return res;
    }

    public void DFS(List<String> res,StringBuilder cur,String key,int start,int left){
        if (left==0){
            res.add(cur.toString());
            return;
        }
        int k=key.charAt(start)-'0';
        for (int j=0;j<KEYS[k].length();j++){
            cur.append(KEYS[k].charAt(j));
            DFS(res,cur,key,start+1,left-1);
            cur.deleteCharAt(cur.length()-1);
        }
    }

}
