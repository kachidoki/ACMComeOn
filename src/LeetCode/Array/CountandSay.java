package LeetCode.Array;

/**
 * Created by mayiwei on 2017/5/11.
 */
//https://leetcode.com/problems/count-and-say/#/description
public class CountandSay {

    public static void main(String[] args){
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        String res="1";
        for (int i=1;i<n;i++){
            res=Recursion(res);
        }
        return res;
    }

    public static String Recursion(String s){
        char[] cs=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        char tmp;
        int count;
        for (int i=0;i<cs.length;i++){
            count=1;
            tmp=cs[i];
            while (i+1<cs.length&&cs[i+1]==tmp) {
                count++;
                i++;
            }
            sb.append(count).append(tmp);
        }
        return sb.toString();
    }

}
