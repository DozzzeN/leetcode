package LinkedList;

//19
//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//示例：
//给定一个链表: 1->2->3->4->5, 和 n = 2.
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
//说明：
//给定的 n 保证是有效的。
//进阶：
//你能尝试使用一趟扫描实现吗？
public class remove_nth_node_from_end_of_list {
    public static void main(String[] args) {
        ListNode head = ListNode.stringToListNode("[1,2,3,4,5]");
        ListNode result = new remove_nth_node_from_end_of_list.Solution().removeNthFromEnd(head, 5);
        System.out.println(ListNode.listNodeToString(result));
    }

    //一个指针先走n步，然后两个指针一起走，当第一个指针指向终点的时候，第二个指针指向的元素即为所求
    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode pre = head;
            ListNode p = head;
            //多循环一次
            for (int i = 0; i < n; i++) {
                p = p.next;
            }
            //删除的是头节点
            if (p == null) {
                return head.next;
            }
            //pre指向要删除的上一个节点
            while (p.next != null) {
                p = p.next;
                pre = pre.next;
            }
            pre.next = pre.next.next;
            return head;
        }
    }
}
