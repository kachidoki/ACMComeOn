package LeetCode.Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mayiwei on 2017/4/2.
 */
//https://leetcode.com/problems/binary-tree-level-order-traversal/#/description
public class TreeBFS {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }



    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root==null) return res;
        List<Integer> level = new LinkedList<>();
        Queue<TreeNode> toPrint=new LinkedList<>();
        TreeNode cur=root;
        TreeNode last=root,levelLast=root;
        toPrint.offer(cur);
        while (!toPrint.isEmpty()){
            cur=toPrint.poll();
            if (cur.left!=null) {
                toPrint.offer(cur.left);
                last=cur.left;
            }
            if (cur.right!=null) {
                toPrint.offer(cur.right);
                last=cur.right;
            }
            level.add(cur.val);
            if (cur==levelLast){
                res.add(new LinkedList<>(level));
                level.clear();
                levelLast=last;
            }
        }
        return res;
    }

}
