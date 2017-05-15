package LeetCode.Array.HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mayiwei on 2017/5/15.
 */
//https://leetcode.com/problems/isomorphic-strings/#/description
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (s==null||t==null||s.length()!=t.length()) return false;
        int[] map=new int[512];
        int n=s.length();
        for (int i=0;i<n;i++){
            if (map[s.charAt(i)]!=map[t.charAt(i)+256]) return false;
            map[s.charAt(i)]=map[t.charAt(i)+256]=i+1;
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        if(s == null || s.length() <= 1) return true;
        Map<Character,Character> map = new HashMap<>();
        for(int i = 0 ; i< s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(map.containsKey(a)){
                if(map.get(a).equals(b)) continue;
                else return false;
            }else{
                if(!map.containsValue(b)) map.put(a,b);
                else return false;
            }
        }
        return true;
    }

}
