package LeetCode.Array.DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mayiwei on 2017/4/3.
 */
//https://leetcode.com/problems/word-break/#/description
public class WordBreak {

    public static void main(String[] args){
        List<String> wordDict=new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        wordBreak("leetcode",wordDict);
    }


    //DP
    public static boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict==null||wordDict.size()==0) return false;
        if (s==null||s.isEmpty()) return true;
        int n=s.length();
        boolean[] dp=new boolean[n+1];//dp(i)表示长度为0-i-1的字符能不能被切分,0表示没有长度，n表示全部
        dp[0]=true;
        String tmp;
        for (int i=1;i<n+1;i++){//到s[i-1]字符结尾
            for (int j=i;j>=0;j--){
                tmp=s.substring(i-j,i);
                if (dp[i-j]&&wordDict.contains(tmp)){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }

    //DFS
    public static boolean wordBreak2(String s, List<String> wordDict) {
        return DFS(s,wordDict,new HashMap<>());
    }

    public static boolean DFS(String s, List<String> wordDict, Map<String,Boolean> map){
        if (map.containsKey(s)) return map.get(s);
        if (s.isEmpty()) return true;
        if (wordDict==null||wordDict.isEmpty()) return false;
        for (String startword:wordDict){
            if (s.startsWith(startword)){
                 if (DFS(s.substring(startword.length()),wordDict,map)) return true;
            }
        }
        map.put(s,false);
        return false;
    }
}
