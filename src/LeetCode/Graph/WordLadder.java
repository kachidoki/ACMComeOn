package LeetCode.Graph;

import java.util.*;

/**
 * Created by mayiwei on 2017/4/4.
 */
//https://leetcode.com/problems/word-ladder/#/description
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> toChange = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        toChange.offer(beginWord);
        visited.add(beginWord);
        int step=0,count;
        String tmp;
        while (!toChange.isEmpty()){
            tmp=toChange.poll();
            step++;
            if (tmp.equals(endWord)) break;
            for (String word:wordList){
                count=0;
                for (int i=0;i<tmp.length();i++){
                    if (tmp.charAt(i)!=word.charAt(i)) count++;
                }
                if (count==1) toChange.offer(word);
            }
        }
        return step;
    }

}
