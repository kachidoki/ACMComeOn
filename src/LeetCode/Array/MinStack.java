package LeetCode.Array;

import java.util.Stack;

/**
 * Created by mayiwei on 2017/4/25.
 */
//https://leetcode.com/problems/min-stack/#/description
public class MinStack {

    Stack<Integer> data;
    Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        data=new Stack<>();
        min=new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (min.isEmpty()||min.peek()>x){
            min.push(x);
        }else {
            min.push(min.peek());
        }
    }

    public void pop() {
        if (data.isEmpty()) throw new RuntimeException("Stack is empty");
        min.pop();
        data.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        if (min.isEmpty()) throw new RuntimeException("Stack is empty");
        return min.peek();
    }

}
