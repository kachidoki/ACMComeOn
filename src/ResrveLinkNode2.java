import java.util.Stack;

/**
 * Created by mayiwei on 2017/3/27.
 */
public class ResrveLinkNode2 {
    public class ListNode {
        int val;
        ResrveLinkNode2.ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode inverse(ListNode head, int k) {
        if (k<2||head==null) return head;
        //记录一个起始和结束节点，一个游标节点，和一个游标的下一个节点，还有一个新的返回头
        ListNode start=head,end=null,left=null,cur=head,next=null,newHead=null;
        int count=1;
        while (cur!=null){
            next=cur.next;//每次让next先赋值
            if (count==k){
                end=cur;
                if (newHead==null) newHead=cur;
                resign(start,left,next,k);
                //调换完了之后重新赋值起始节点start和left
                left=start;
                start=next;
                count=0;//清空数值继续移动游标
            }
            count++;
            cur=next;
        }
        return newHead;
    }


    public void resign(ListNode start,ListNode left,ListNode right,int k){
        Stack<ListNode> s = new Stack<>();
        ListNode cur = start;
        int count=0;
        while (count<k){
            s.push(cur);
            cur=cur.next;
            count++;
        }
        if (left!=null) left.next=s.peek();
        while (!s.isEmpty()){
            cur=s.pop();
            if (!s.isEmpty()) cur.next=s.peek();
        }
        cur.next=right;
    }

}
