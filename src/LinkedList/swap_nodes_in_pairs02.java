package LinkedList;

//24
//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//示例:
//给定 1->2->3->4, 你应该返回 2->1->4->3.
public class swap_nodes_in_pairs02 {
    public static void main(String[] args) {
        ListNode head = ListNode.stringToListNode("[1,2,3,4]");
        ListNode result = new swap_nodes_in_pairs02.Solution().swapPairs(head);
        System.out.println(ListNode.listNodeToString(result));
    }

    static class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode newPair = head.next.next;
            ListNode newHead = head.next;
            head.next.next = head;
            head.next = swapPairs(newPair);
            return newHead;
        }
    }
}
