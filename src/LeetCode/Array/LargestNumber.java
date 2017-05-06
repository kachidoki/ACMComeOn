package LeetCode.Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by mayiwei on 2017/5/6.
 */
//https://leetcode.com/problems/largest-number/#/description
public class LargestNumber {

    public String largestNumber(int[] nums) {
        if (nums==null||nums.length==0) return "";
        String[] ss=new String[nums.length];
        for (int i=0;i<nums.length;i++){
            ss[i]=String.valueOf(nums[i]);
        }
        Comparator<String> comparator=new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1=o1+o2;
                String s2=o2+o1;
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(ss,comparator);
        if (ss[0].charAt(0)=='0') return "0";
        StringBuilder sb=new StringBuilder();
        for (String s:ss){
            sb.append(s);
        }
        return sb.toString();
    }

}
