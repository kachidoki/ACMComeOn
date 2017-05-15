package LeetCode.Array;

import java.util.*;

/**
 * Created by mayiwei on 2017/5/15.
 */
//https://leetcode.com/problems/simplify-path/#/description
//".."是返回上级目录（如果是根目录则不处理）
public class SimplifyPath {

    public String simplifyPath(String path) {
        Deque<String> stack=new ArrayDeque<>();
        Set<String> skip=new HashSet<>(Arrays.asList("..",".",""));
        for (String dir:path.split("/")){
            if (dir.equals("..")&&!stack.isEmpty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }
        String res="";
        for (String dir:stack){
            res="/"+dir+res;
        }
        return res.isEmpty()?"/":res;
    }

}
