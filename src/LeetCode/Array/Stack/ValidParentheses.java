package LeetCode.Array.Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by mayiwei on 2017/4/17.
 */
//https://leetcode.com/problems/valid-parentheses/#/description
public class ValidParentheses {

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    if (stack.isEmpty()||stack.pop()!=s.charAt(i))
                        return false;
            }
        }

        return stack.isEmpty();
    }
}
