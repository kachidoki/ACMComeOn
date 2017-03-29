import java.util.Arrays;

/**
 * Created by mayiwei on 2017/3/20.
 */
//链接：https://www.nowcoder.com/questionTerminal/c3083cd30d5043e1b95000f139b5b2c9
//来源：牛客网

//牛牛的好朋友羊羊在纸上写了n+1个整数，羊羊接着抹除掉了一个整数，给牛牛猜他抹除掉的数字是什么。
// 牛牛知道羊羊写的整数神排序之后是一串连续的正整数，牛牛现在要猜出所有可能是抹除掉的整数。例如：
//10 7 12 8 11    那么抹除掉的整数只可能是9
//5 6 7 8         那么抹除掉的整数可能是4也可能是9

//输入描述:
//输入包括2行：
//第一行为整数n(1 <= n <= 50)，即抹除一个数之后剩下的数字个数
//第二行为n个整数num[i] (1 <= num[i] <= 1000000000)
public class ContinuousNum {
    public static void main(String[] args){

    }

    public static void solution(int[] num,int n){

//如果只有一个数字，注意保证输入正整数        

        if (n == 1) {
            if (num[0] > 1) {
                System.out.println(num[0] - 1 + " " + (num[0] + 1));
                return;
            } else {
                System.out.println((num[0] + 1));
                return;
            }
        }
        Arrays.sort(num);
        for (int i = 0; i < n-1; i ++) {
            if (num[i] == num[i+1]) {
                System.out.println("mistake");
            }
        }



    }


}
