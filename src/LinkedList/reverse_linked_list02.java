package LinkedList;

//206
//反转一个单链表。
//示例:
//输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//进阶:
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
public class reverse_linked_list02 {
    public static void main(String[] args) {
        ListNode input = ListNode.stringToListNode("[1,2,3,4,5]");
        System.out.println(ListNode.listNodeToString(new reverse_linked_list02.Solution().reverseList(input)));
    }

    //递归
    //1->2->3->4->5->NULL
    //把1和[2->3->4->5->NULL]看成两个节点进行反转
    //NULL<-1<-[2->3->4->5->NULL]
    static class Solution {
        public ListNode reverseList(ListNode head) {//返回反转后的头节点
            if (head == null || head.next == null) return head;//已到尾节点
            ListNode newHead = reverseList(head.next);//[2->3->4->5->NULL]变成[2<-3<-4<-5] newHead指向5
            head.next.next = head;//NULL<-1<-2
            head.next = null;//NULL<-1  切断该节点与前一个节点之间的联系，并且避免循环的产生
            return newHead;
        }
    }
}
