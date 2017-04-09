package LeetCode.Graph;

import java.util.*;

/**
 * Created by mayiwei on 2017/4/4.
 */
//https://leetcode.com/problems/word-ladder/#/description
public class WordLadder {

    public static void main(String[] args){
        List<String> list=new LinkedList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
//        list.add("cog");
        ladderLength2("hit","cog",list);
    }
    //BFS
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList==null||wordList.isEmpty()) return 0;
        if (!wordList.contains(endWord)) return 0;
        Queue<Word> toChange = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        toChange.offer(new Word(beginWord,1));
        visited.add(beginWord);
        int count;
        Word tmp;
        while (!toChange.isEmpty()){
            tmp=toChange.poll();
            for (String word:wordList){
                if (visited.contains(word)) continue;
                count=0;
                for (int i=0;i<tmp.val.length();i++){
                    if (tmp.val.charAt(i)!=word.charAt(i)) {
                        if (++count>1) break;
                    }
                }
                if (count==1) {
                    if (word.equals(endWord)) return tmp.step+1;
                    toChange.offer(new Word(word,tmp.step+1));
                    visited.add(word);
                }
            }
        }
        return 0;
    }

    public static class Word{
        public String val;
        public int step;
        public Word(String a,int s){
            val=a;
            step=s;
        }
    }

    //BFS
    public static int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (wordList==null||wordList.isEmpty()) return 0;
        if (!wordList.contains(endWord)) return 0;
        Queue<String> toChange = new LinkedList<>();
        toChange.offer(beginWord);
        wordList.remove(beginWord);
        String tmp,inTmp;
        int level = 1;
        while (!toChange.isEmpty()){
            int size = toChange.size();
            for (int i=0;i<size;i++){
                tmp=toChange.poll();
                for (int j=0;j<tmp.length();j++){
                    char[] chars = tmp.toCharArray();
                    for (char c='a';c<='z';c++){
                        chars[j]=c;
                        inTmp=new String(chars);
                        if (inTmp.equals(endWord)) return level+1;
                        if (wordList.remove(inTmp)) toChange.offer(inTmp);
                    }
                }
            }
            level++;
        }
        return 0;
    }

    //Dijkstra's
    public static int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        if (wordList==null||wordList.isEmpty()) return 0;
        if (!wordList.contains(endWord)) return 0;
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        wordList.add(endWord);
        int distance = 1;
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if (wordList.contains(word)) {
                            toAdd.add(word);
                            wordList.remove(word);
                        }
                    }
                }
            }
            distance++;
            if (toAdd.size() == 0) return 0;
            reached = toAdd;
        }
        return distance;
    }


}
