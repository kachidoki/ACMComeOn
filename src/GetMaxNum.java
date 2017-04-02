/**
 * Created by mayiwei on 2017/4/1.
 */
//比较A与B的值，返回最大的那个，不能用大于或小于
public class GetMaxNum {

    public static void main(String[] args){
        System.out.println(getMax(3,2));
    }


    public static int getMax(int a, int b) {
        int c = a-b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int isABdif = sa^sb;
        int isABsame = flip(isABdif);
        int returnA = isABdif*a+isABsame*sc;
        int returnB = flip(returnA);
        return returnA*a+returnB*b;
    }


    //符号取反
    public static int flip(int opp){
        return opp^1;
    }

    //获得符号位正为1，负为0
    public static int sign(int x){
        return flip((x>>31)&1);
    }


}
