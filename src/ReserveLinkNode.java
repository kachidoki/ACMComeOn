/**
 * Created by mayiwei on 2017/3/27.
 */
public class ReserveLinkNode {
    public class ListNode {
        int val;
        ListNode next = null;

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
                resign(start,end,left,next);
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


    public void resign(ListNode start,ListNode end,ListNode left,ListNode right){
        ListNode cur = start.next,pre=start,next=null;
        if (left!=null) left.next=end;
        while (cur!=right){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        start.next=right;
    }

}
