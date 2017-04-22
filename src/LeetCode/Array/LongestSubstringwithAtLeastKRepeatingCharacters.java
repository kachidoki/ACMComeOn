package LeetCode.Array;

/**
 * Created by mayiwei on 2017/4/22.
 */
//https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/#/description
public class LongestSubstringwithAtLeastKRepeatingCharacters {

    //划分的解法
    public static int longestSubstring2(String s, int k) {
        char[] str = s.toCharArray();
        return divide(str,0,s.length(),k);
    }
    public static int divide(char[] str, int start, int end,  int k){
        if(end-start<k) return 0;//substring length shorter than k.
        int[] count = new int[26];
        for(int i = start;i<end;i++){
            int idx = str[i]-'a';
            count[idx]++;
        }
        for(int i = 0;i<26;i++){
            if(count[i]<k&&count[i]>0){ //将没有那些出现次数小于k的字母两边划分
                for(int j = start;j<end;j++){
                    if(str[j]==i+'a'){
                        int left = divide(str,start,j,k);
                        int right = divide(str,j+1,end,k);
                        return Math.max(left,right);
                    }
                }
            }
        }
        return end-start;
    }

}
