package LeetCode.Array.DP;

/**
 * Created by mayiwei on 2017/5/19.
 */
//https://leetcode.com/problems/edit-distance/#/description
public class EditDistance {

    public static void main(String[] args){
        minDistance("a","ab");
    }

    public static int minDistance(String word1, String word2) {
        if (word1==null||word2==null||word1.equals(word2)) return 0;
        int row=word2.length()+1,col=word1.length()+1;
        int[][] dp=new int[row][col];
        for (int i=0;i<row;i++){
            dp[i][0]=i;
        }
        for (int j=0;j<col;j++){
            dp[0][j]=j;
        }
        for (int i=1;i<row;i++){
            for (int j=1;j<col;j++){
                if (word1.charAt(j-1)==word2.charAt(i-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
        return dp[row-1][col-1];
    }

}
