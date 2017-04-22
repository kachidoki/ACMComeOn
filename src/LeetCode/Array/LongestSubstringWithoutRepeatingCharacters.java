package LeetCode.Array;

/**
 * Created by mayiwei on 2017/4/22.
 */
//https://leetcode.com/problems/longest-substring-without-repeating-characters/#/description
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args){
        lengthOfLongestSubstring2("dvdf");
    }


    public static int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0) return 0;
        int n=s.length();
        int[] busket=new int[256];
        int[] dp=new int[n+1];
        int max=0,tmp;
        for (int i=1;i<n+1;i++){
            tmp=busket[s.charAt(i-1)];
            if (tmp!=0) {
                dp[i]=i-tmp;
                clearBuk(busket);
                for (int j=tmp;j<=i;j++){
                    busket[s.charAt(i-1)]=j;
                }
            } else{
                dp[i]=dp[i-1]+1;
                busket[s.charAt(i-1)]=i;
            }
            if (max<dp[i]) max=dp[i];
        }
        return max;
    }

    public static void clearBuk(int[] b){
        for (int i=0;i<b.length;i++){
            if (b[i]!=0) b[i]=0;
        }
    }


    public static int lengthOfLongestSubstring2(String s){
        if(s==null||s.length()==0) return 0;
        int[] busket=new int[256];
        int max=0,last=1;
        for (int i=1;i<s.length()+1;i++){
            if (busket[s.charAt(i-1)]!=0){
                last=Math.max(last,busket[s.charAt(i-1)]+1);
            }
            busket[s.charAt(i-1)]=i;
            max=Math.max(max,i-last+1);
        }
        return max;
    }

}
