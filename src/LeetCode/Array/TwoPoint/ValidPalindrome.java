package LeetCode.Array.TwoPoint;

/**
 * Created by mayiwei on 2017/4/18.
 */
//https://leetcode.com/problems/valid-palindrome/#/description
public class ValidPalindrome {


    public static void main(String[] args){
        isPalindrome("a.b,.");

    }

    public static boolean isPalindrome(String s) {
        if (s==null||s.isEmpty()) return true;
        int start=0,end=s.length()-1;
        while (start<end){
            char t=s.charAt(start),w=s.charAt(end);
            if (!((t<='z'&&t>='a')||(t<='Z'&&t>='A')||(t<='9'&&t>='0'))){
                start++;
            }else if (!((w<='z'&&w>='a')||(w<='Z'&&w>='A')||(w<='9'&&w>='0'))){
                end--;
            }else {
                if (t==w||(Math.abs(t-w)==32&&(t<='z'&&t>='A')&&(w<='z'&&w>='A'))) {
                    start++;
                    end--;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    //使用Character简化
    public boolean isPalindrome2(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }

        return true;
    }

    public boolean isPalindrome3(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }

}
