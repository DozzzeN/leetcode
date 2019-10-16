package LinkedList;

//24
//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//示例:
//给定 1->2->3->4, 你应该返回 2->1->4->3.
public class swap_nodes_in_pairs {
    public static void main(String[] args) {
        ListNode head = ListNode.stringToListNode("[1,2,3,4]");
        ListNode result = new swap_nodes_in_pairs.Solution().swapPairs(head);
        System.out.println(ListNode.listNodeToString(result));
    }

    static class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null) return null;
            if (head.next == null) return head;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;//保存头，因为交换以后头会变
            ListNode pre = head.next;
            ListNode cur = head;
            ListNode post = dummy;
            while (pre != null) {
                ListNode temp = pre.next;
                pre.next = cur;
                cur.next = temp;
                post.next = pre;
                post = cur;
                if (post.next == null) break;
                cur = post.next;
                pre = cur.next;
            }
            return dummy.next;
        }
    }
}
