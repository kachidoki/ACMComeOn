package LeetCode.Array;

/**
 * Created by mayiwei on 2017/5/7.
 */
//https://leetcode.com/problems/candy/#/description
public class Candy {

    //左右来回检查
    //n n
    public int candy(int[] ratings) {
        if (ratings==null||ratings.length==0) return 0;
        if (ratings.length==1) return 1;
        int[] candy=new int[ratings.length];
        candy[0]=1;
        for (int i=1;i<ratings.length;i++){
            if (ratings[i]>ratings[i-1]) candy[i]=candy[i-1]+1;
            else candy[i]=1;
        }
        for (int i=ratings.length-2;i>=0;i--){
            if (ratings[i]>ratings[i+1]&&candy[i]<=candy[i+1]){
                candy[i]=candy[i+1]+1;
            }
        }
        int res=0;
        for (int i=0;i<candy.length;i++){
            res+=candy[i];
        }
        return res;
    }

    //n 1
    //http://www.cnblogs.com/felixfang/p/3620086.html
    public int candy2(int[] ratings) {
        if (ratings==null||ratings.length==0) return 0;
        if (ratings.length==1) return 1;
        int res=1,downLen=0,preCandy=1,lastdownCandy=1;
        for (int i=1;i<ratings.length;i++){
            if (ratings[i]<ratings[i-1]){//递减
                downLen++;
                if (lastdownCandy<=downLen) res++;
                res+=downLen;
                preCandy=1;
            }else {
                if (ratings[i]>ratings[i-1]){
                    res+=++preCandy;
                    lastdownCandy=preCandy;
                }else {
                    preCandy=1;
                    res+=preCandy;
                    lastdownCandy=preCandy;
                }
                downLen=0;
            }
        }
        return res;
    }

}
