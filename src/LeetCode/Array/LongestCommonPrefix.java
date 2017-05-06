package LeetCode.Array;

/**
 * Created by mayiwei on 2017/5/6.
 */
//https://leetcode.com/problems/longest-common-prefix/#/description
public class LongestCommonPrefix {

    public static void main(String[] args){
        longestCommonPrefix(new String[]{"aa","a"});
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs==null||strs.length==0) return "";
        char[] comPre=strs[0].toCharArray();
        char[] tmp;
        int index=comPre.length,indTmp;
        for (int i=1;i<strs.length;i++){
            tmp=strs[i].toCharArray();
            indTmp=0;
            for (int j=0;j<tmp.length&&j<index;j++){
                if (comPre[j]==tmp[j]) indTmp++;
                else break;
            }
            index=indTmp;
        }
        char[] s=new char[index];
        for (int i=0;i<index;i++){
            s[i]=comPre[i];
        }
        return new String(s);
    }

    public String longestCommonPrefix2(String[] strs) {
        if(strs.length==0) return "";
        StringBuilder res=new StringBuilder();
        for(int i=0;i<strs[0].length();i++){
            char c=strs[0].charAt(i);
            for(String s:strs){
                if(s.length()<i+1||c!=s.charAt(i)) return res.toString();
            }
            res.append(c);
        }
        return res.toString();
    }

}
