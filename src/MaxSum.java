import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaxSum {


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;
        List<Integer> list=new ArrayList<>();
        while (in.hasNextInt()){
            list.add(in.nextInt());
        }
        res = maxSum(list);
        System.out.println(String.valueOf(res));

    }


    public static int maxSum(List<Integer> list){
        int n=list.size();
        int[] dp=new int[n];
        dp[0]=list.get(0);
        int max = dp[0];
        for (int i=1;i<n;i++){
            dp[i]=(list.get(i)>dp[i-1]+list.get(i))?list.get(i):dp[i-1]+list.get(i);
            if (dp[i]>max) max=dp[i];
        }
        return max;
    }
}
