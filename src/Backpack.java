import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by mayiwei on 2017/4/9.
 */
//01背包问题
public class Backpack {


    public static void main(String[] args){
        maxValue2(new int[]{1,2,3},new int[]{1,2,3},3,6);
    }

    //use dp
    public static int maxValue(int[] w, int[] v, int n, int cap) {
        if (w==null||v==null||n==0||cap==0) return 0;
        int[][] dp = new int[n][cap+1];
        for (int i=0;i<cap+1;i++){
            if (i>=w[0])
                dp[0][i]=v[0];
        }
        for (int i=1;i<n;i++){
            for (int j=1;j<cap+1;j++){
                if (j-w[i]>=0){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n-1][cap];
    }

    //greedy
    public static int maxValue2(int[] w, int[] v, int n, int cap) {
        if (w==null||v==null||n==0||cap==0) return 0;
        What[] list=new What[n];
        for (int i=0;i<n;i++){
            list[i]=new What(w[i],v[i]);
        }
        Arrays.sort(list, new Comparator<What>() {
            @Override
            public int compare(What o1, What o2) {
                return Integer.compare(o1.v/o1.w,o2.v/o2.w);
            }
        });
        int sum=0;
        boolean[] hasChoose = new boolean[n];
        while (cap>0){
            for (int i=0;i<n;i++){
                if (!hasChoose[i]){
                    if (cap>=list[i].w){
                        cap-=list[i].w;
                        sum+=list[i].v;
                        hasChoose[i]=true;
                        break;
                    }
                }
            }
        }
        return sum;
    }

    public static class What{
        public int w;
        public int v;
        public What(int w,int v){
            this.w=w;
            this.v=v;
        }
    }


}
