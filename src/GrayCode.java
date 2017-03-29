// 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同，
// 则称这种编码为格雷码(Gray Code)，请编写一个函数，使用递归的方法生成N位的格雷码。
// 给定一个整数n，请返回n位的格雷码，顺序为从0开始。

import java.util.Scanner;

/**
 * Created by mayiwei on 2017/3/29.
 */
public class GrayCode {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        get(n);
    }

    public static String[] getGray(int n) {
        int m = 1<<n;
        String[] strings = new String[m];
        if (n==1){
            strings[0]="0";
            strings[1]="1";
            return strings;
        }
        String[] last = getGray(n-1);
        for (int i=0;i<last.length;i++){
            strings[i]="0"+last[i];
        }
        for (int i=last.length-1;i>=0;i--){
            strings[m-i-1]="1"+last[i];
        }
        return strings;
    }


    //法二
    public static String[] get(int n){
        int m = 1<<n;
        String[] strings = new String[m];
        for (int i=0;i<m;i++){
            int num = i^(i>>1);
            strings[i] = getbinarystr(num,n);
        }
        return strings;
    }

    public static String getbinarystr(int num,int n){
        String s="";
        int count=0;
        while (count<n){
            if ((num&1)==1){
                s="1"+s;
            }else {
                s="0"+s;
            }
            num=num>>1;
            count++;
        }
        return s;
    }

}
