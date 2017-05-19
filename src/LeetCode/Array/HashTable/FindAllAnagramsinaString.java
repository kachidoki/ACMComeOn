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
        int[] map=new int[26];
        for (char c:p.toCharArray()){
            map[c-'a']++;
        }
        int begin=0,end=0,counter=p.length();
        while (end<s.length()){
            if (map[s.charAt(end++)-'a']-->0) counter--;
            while (counter==0){
                if (end-begin==p.length()) res.add(begin);
                if (map[s.charAt(begin++)-'a']++==0) counter++;
            }
        }
        return res;
    }

}
