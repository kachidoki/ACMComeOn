import java.util.Scanner;

/**
 * Created by mayiwei on 2017/3/29.
 */
// 有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。
// 小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”答案是5瓶，方法如下：
// 先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。
// 然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。
// 如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
public class ChangeWater {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            changePrint(n);
        }
    }


    public static void change(int n){
        int count=0,kong=0,out = n;
        while (!(kong==0&&out==1)){
            if (out>=3){
                int del = out%3;
                kong=kong+out-del;
                out=del;
            }
            if (out==2&&kong==0){
                count=count+1;
                break;
            }
            count=count+kong/3;
            out =out+kong/3+kong%3;
            kong=0;
        }
        System.out.println(count);
    }


    //法2：递归解决（通过递归发现结果就是n/2）
    public static void changePrint(int n){
        int count = exchange(n);
        System.out.println(count);
    }

    public static int exchange(int n){
        if (n==1) return 0;
        if (n==2) return 1;
        return exchange(n-2)+1;
    }

}
