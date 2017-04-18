package LeetCode.Array;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mayiwei on 2017/4/18.
 */
//https://leetcode.com/problems/triangle/#/description
public class Triangle {

    public static void main(String[] args){
        minimumTotal(Arrays.asList(Arrays.asList(2),Arrays.asList(3,4),Arrays.asList(6,5,7),Arrays.asList(4,1,8,3)));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle==null||triangle.isEmpty()) return 0;
        if (triangle.size()==1) return triangle.get(0).get(0);
        int n=triangle.size();
        int[] dp=new int[n];
        dp[0]=triangle.get(0).get(0);
        int min=Integer.MAX_VALUE;
        for (int i=1;i<n;i++){
            for (int j=triangle.get(i).size()-1;j>=0;j--){
                if (j==triangle.get(i).size()-1) dp[j]=dp[j-1]+triangle.get(i).get(j);
                else if (j==0) dp[j]=dp[j]+triangle.get(i).get(j);
                else dp[j]=Math.min(dp[j-1],dp[j])+triangle.get(i).get(j);
                if (i==n-1&&min>dp[j]) min=dp[j];
            }
        }
        return min;
    }


    //简洁,自底向上
    public int minimumTotal2(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
            }
        }
        return A[0];
    }


}
