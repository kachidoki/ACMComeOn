package LeetCode.Array;

/**
 * Created by mayiwei on 2017/4/17.
 */
public class ImplementstrStr {
    //kmp
    public int strStr(String s, String m) {
        if(s == null || m == null || s.length() < m.length()){
            return -1;
        }
        if(s.length()==0||m.length()==0) return 0;
        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();

        int[] nextArr = getNextArray(ms);
        int index = 0;
        int mi = 0;
        while(index < ss.length && mi < ms.length){
            if(ss[index] == ms[mi]){
                index++;
                mi++;
            }else if(nextArr[mi] == -1){
                index++;
            }else{
                mi = nextArr[mi];
            }
        }
        return mi == ms.length? index - mi: -1;
    }
    private int[] getNextArray(char[] ms) {
        if(ms.length == 1){
            return new int[]{-1};
        }
        int[] nextArr = new int[ms.length];
        nextArr[0] = -1;
        nextArr[1] = 0;
        int pos = 2;
        int cn = 0;
        while(pos < nextArr.length){
            if(ms[pos - 1] == ms[cn]){
                nextArr[pos++] = ++cn;
            }else if(cn > 0){
                cn = nextArr[cn];
            }else{
                nextArr[pos++] = 0;
            }
        }
        return nextArr;
    }

    public int strStr2(String haystack, String needle) {
        for (int i=0;;i++){
            for (int j=0;;j++){
                if (j==needle.length()) return i;
                if (i+j==haystack.length()) return -1;
                if (needle.charAt(j)!=haystack.charAt(i+j)) break;
            }
        }
    }

}
