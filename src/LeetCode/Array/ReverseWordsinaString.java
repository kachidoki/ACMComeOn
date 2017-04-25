package LeetCode.Array;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by mayiwei on 2017/4/24.
 */
//https://leetcode.com/problems/reverse-words-in-a-string/#/description
public class ReverseWordsinaString {

    public static void main(String[] args){
        System.out.println(reverseWords("the sky is blue"));
    }


    public static String reverseWords(String s) {
        char[] c=s.toCharArray();
        reverse(c,0,c.length-1);
        int left=0,right=-1,index=0;
        while (index<c.length){
            while (index<c.length&&c[index]!=' ') index++;
            if (right!=-1) left=right+2;
            right=index-1;
            reverse(c,left,right);
            index++;
        }
        return cleanSpaces(c,c.length);
    }

    public static void reverse(char[] s,int l,int r){
        int start=l,end=r;
        char tmp;
        while (start<end){
            tmp=s[start];
            s[start++]=s[end];
            s[end--]=tmp;
        }
    }

    public static String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;
        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ') j++;             // skip spaces
            if (j < n) a[i++] = ' ';                      // keep only one space
        }
        return new String(a).substring(0, i);
    }


    public static String reverseWords2(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

}
