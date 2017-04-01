import java.util.Scanner;

/**
 * Created by mayiwei on 2017/3/29.
 */
//写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）
public class ChangeNum {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.nextLine().substring(2);
            System.out.println(Integer.parseInt(str,16));
        }
    }


}
