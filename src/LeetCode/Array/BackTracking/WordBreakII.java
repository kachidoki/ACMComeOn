package LeetCode.Array.BackTracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by mayiwei on 2017/4/4.
 */
//https://leetcode.com/problems/word-break-ii/#/description
public class WordBreakII {


    //just DFS
    public static List<String> wordBreak(String s, List<String> wordDict) {
        return DFS(s,wordDict,new HashMap<>());
    }

    public static List<String> DFS(String s, List<String> wordDict, Map<String,List<String>> map){
        if (map.containsKey(s)) return map.get(s);
        List<String> res = new LinkedList<>();
        if (s.isEmpty()){
            res.add("");
            return res;
        }
        for (String word:wordDict){
            if (s.startsWith(word)){
                List<String> down = DFS(s.substring(word.length()),wordDict,map);
                for (String sub:down){
                    res.add(word+(sub.isEmpty()?"":" ")+sub);
                }
            }
        }
        map.put(s,res);
        return res;
    }
}
