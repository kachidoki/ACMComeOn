package LeetCode.Array.HashTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayiwei on 2017/5/14.
 */
//https://leetcode.com/problems/find-all-anagrams-in-a-string/#/description
public class FindAllAnagramsinaString {

    //Sliding window
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        if (s==null||p==null||s.length()==0||p.length()==0) return res;
        int[] busket=new int[26];
        for (char c:p.toCharArray()){
            busket[c-'a']++;
        }
        int start=0,end=0,count=p.length();
        while (end<s.length()){
            if (end-start==p.length()&&busket[s.charAt(start++)-'a']++>=0) count++;
            if (--busket[s.charAt(end++)-'a']>=0) count--;
            if (count==0) res.add(start);
        }
        return res;
    }

}
