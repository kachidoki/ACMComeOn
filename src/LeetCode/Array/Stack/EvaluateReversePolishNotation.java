package LeetCode.Array.Stack;
import java.util.Stack;

/**
 * Created by mayiwei on 2017/4/3.
 */
//https://leetcode.com/problems/evaluate-reverse-polish-notation/#/description
//后缀表达式http://blog.csdn.net/sgbfblog/article/details/8001651
public class EvaluateReversePolishNotation {

    public static void main(String[] args){
        evalRPN(new String[]{"0", "3", "*"});
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> RPN = new Stack<>();
        int tmp=0,res=0;
        for (String s:tokens) {
            if (s.equals("+")){
                tmp=RPN.pop();
                res=RPN.pop();
                res+=tmp;
                RPN.push(res);
            }else if(s.equals("-")){
                tmp=RPN.pop();
                res=RPN.pop();
                res-=tmp;
                RPN.push(res);
            }else if(s.equals("*")){
                tmp=RPN.pop();
                res=RPN.pop();
                res*=tmp;
                RPN.push(res);
            }else if(s.equals("/")){
                tmp=RPN.pop();
                res=RPN.pop();
                if (tmp==0) return 0;
                res/=tmp;
                RPN.push(res);
            }else {
                RPN.push(Integer.valueOf(s));
            }
        }
        tmp=RPN.pop();
        return tmp;
    }
}
