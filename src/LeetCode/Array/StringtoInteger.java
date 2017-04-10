package LeetCode.Array;

/**
 * Created by mayiwei on 2017/4/10.
 */
//https://leetcode.com/problems/string-to-integer-atoi/#/solutions
public class StringtoInteger {


    public static int myAtoi(String str) {
        if (str.isEmpty()) return 0;
        int index=0,sign=1,res=0;
        while (str.charAt(index)==' '&&index<str.length())
            index++;
        if (str.charAt(index)=='+'||str.charAt(index)=='-'){
            if (str.charAt(index)=='+') sign=1;
            else sign=-1;
            index++;
        }
        int tmp;
        while (index<str.length()){
            tmp=str.charAt(index)-'0';
            if (tmp<0||tmp>9) break;
            if (Integer.MAX_VALUE/10<res||Integer.MAX_VALUE/10==res&&Integer.MAX_VALUE%10<tmp)
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            res=10*res+tmp;
            index++;
        }

        return res*sign;
    }


}
