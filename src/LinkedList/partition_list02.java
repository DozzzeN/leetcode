package LinkedList;

//86
//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
//你应当保留两个分区中每个节点的初始相对位置。
//示例:
//输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
public class partition_list02 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        ListNode result = new partition_list02.Solution().partition(head, 3);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    //用X分割原链表成两个链表，然后再连接他们
    static class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode beforeHead = new ListNode(0);
            ListNode beforeTail = beforeHead;
            ListNode afterHead = new ListNode(0);
            ListNode afterTail = afterHead;
            while (head != null) {
                if (head.val >= x) {
                    afterTail.next = head;
                    afterTail = afterTail.next;
                } else {
                    beforeTail.next = head;
                    beforeTail = beforeTail.next;
                }
                head = head.next;
            }
            afterTail.next = null;
            beforeTail.next = afterHead.next;
            return beforeHead.next;
        }
    }
}
