import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mayiwei on 2017/3/25.
 */
public class MathTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mathlen= scanner.nextLine();
        scanner.close();
        math(mathlen);
    }

    public static void math(String s){
        if (s==null||s.isEmpty()){
            System.out.println("");
        }
        List<Integer> op = new ArrayList<>();
        List<Integer> num = new ArrayList<>();
        int start=0,end=0;
        for (int i=0;i<s.length();i++){
            if (addOp(s.charAt(i))!=-1) {
                op.add(addOp(s.charAt(i)));
                end=i-1;
                if (start==end){
                    num.add(Integer.valueOf(String.valueOf(s.charAt(start))));
                }else {
                    num.add(Integer.valueOf(s.substring(start,end)));
                }
                start=i+1;
            }
        }
        if (end<s.length()) {
            end=s.length();
            if (start==end){
                num.add(Integer.valueOf(String.valueOf(s.charAt(start))));
            }else {
                num.add(Integer.valueOf(s.substring(start,end)));
            }
        }
        int res = cap(op,num);
        System.out.println(res+"");
    }


    public static int cap(List<Integer> op,List<Integer> num){
        int result = 0;
        int numi=0;
        int a=-1,b=-1;
        for (int i=0;i<op.size();i++){
            if (a==-1&&b==-1) {
                a=num.get(0);
                b=num.get(1);
                numi=numi+2;
            }
            if (b==-1){
                b=num.get(numi++);
            }
            //计算
            if (op.get(i)==0){
                result=a+b;
            }else if (op.get(i)==1){
                result=a-b;
            }else if (op.get(i)==2){
                result=a*b;
            }
            a=result;
            b=-1;
        }

        return result;
    }

    public static int addOp(char o){
        if (o=='+') return 0;
        else if(o=='-') return 1;
        else if (o=='*') return 2;
        else return -1;
    }

}
