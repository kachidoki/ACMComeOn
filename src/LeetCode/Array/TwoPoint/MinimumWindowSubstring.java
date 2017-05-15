package LeetCode.Array.TwoPoint;

/**
 * Created by mayiwei on 2017/5/14.
 */
//https://leetcode.com/problems/minimum-window-substring/#/description
public class MinimumWindowSubstring {

    public static void main(String[] args){
        minWindow2("ADOBECODEBANC","ABC");
    }

    public static String minWindow(String s, String t) {
        int[] map=new int[256];
        for (int i=0;i<t.length();i++){
            map[t.charAt(i)]++;
        }
        int counter=t.length(),begin=0,end=0,min=Integer.MAX_VALUE,head=0;
        while (end<s.length()){
            if (map[s.charAt(end++)]-->0) counter--;
            while (counter==0){
                if (end-begin<min){
                    head=begin;
                    min=end-head;
                }
                if (map[s.charAt(begin++)]++==0) counter++;
            }
        }
        return min==Integer.MAX_VALUE?"":s.substring(head,head+min);
    }

    public static String minWindow2(String s, String t) {
        int[] map=new int[26];
        for (int i=0;i<t.length();i++){
            map[t.charAt(i)-'A']++;
        }
        int counter=t.length(),begin=0,end=0,min=Integer.MAX_VALUE,head=0;
        while (end<s.length()){
            if (map[s.charAt(end++)-'A']-->0) counter--;
            while (counter==0){
                if (end-begin<min){
                    head=begin;
                    min=end-head;
                }
                if (map[s.charAt(begin++)-'A']++==0) counter++;
            }
        }
        return min==Integer.MAX_VALUE?"":s.substring(head,head+min);
    }




//For most substring problem, we are given a string and need to find a substring of it which satisfy some restrictions.
// A general way is to use a hashmap assisted with two pointers. The template is given below.

//    public int findSubstring(String s){
//        int[] map=new int[256];
//        int counter; // check whether the substring is valid
//        int begin=0, end=0; //two pointers, one point to tail and one  head
//        int d; //the length of substring
//
//        for(;;) { /* initialize the hash map here */ }
//
//        while(end<s.length()){
//
//            if(map[s.charAt(end++)]-- ?){  /* modify counter here */ }
//
//            while(/* counter condition */){
//
//                 /* update d here if finding minimum*/
//
//                //increase begin to make it invalid/valid again
//
//                if(map[s[begin++]]++ ?){ /*modify counter here*/ }
//            }
//
//            /* update d here if finding maximum*/
//        }
//        return d;
//    }

}
