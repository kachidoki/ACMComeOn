import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * Created by mayiwei on 2017/4/11.
 */
public class FindSame {
    /*请完成下面这个函数，实现题目要求的功能*/
/*当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ */
    /******************************开始写代码******************************/
    static String[] doFilter(String[] source, String filter) {
        String[] a=new String[1];
        a[0]="-1";
        return a;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){

        String[] _source = {
                "AB",
                "ABC",
                "ACB",
                "ABCD",
                "ADBCF",
                "ABDCF",
                "ABDC",
                "ABDFCG",
                "ABDFGC",
                "ABDEFG",
                "GABCEFG"
        };

        Scanner in = new Scanner(System.in);
        String _filter;
        try {
            _filter = in.nextLine();
        } catch (Exception e) {
            _filter = null;
        }

        String[] res = doFilter(_source, _filter);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}
