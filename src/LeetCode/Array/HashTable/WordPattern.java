package LeetCode.Array.HashTable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mayiwei on 2017/5/15.
 */
//https://leetcode.com/problems/word-pattern/#/description
public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        String[] word=str.split(" ");
        if (pattern.length()!=word.length) return false;
        Map<Character,String> map=new HashMap<>();
        for (int i=0;i<word.length;i++){
            char c=pattern.charAt(i);
            if (map.containsKey(c)){
                if (!map.get(c).equals(word[i])) return false;
            }else {
                if (map.containsValue(word[i])) return false;
                map.put(c,word[i]);
            }
        }
        return true;
    }

    public boolean wordPattern2(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i){
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        }
        return true;
    }

}
