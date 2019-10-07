package LinkedList;

//143
//给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
//你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//示例 1:
//给定链表 1->2->3->4, 重新排列为 1->4->2->3.
//示例 2:
//给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
public class reorder_list {
    public static void main(String[] args) {
        ListNode head = ListNode.stringToListNode("[1]");
        new reorder_list.Solution().reorderList(head);
        System.out.println(ListNode.listNodeToString(head));
    }

    static class Solution {
        public void reorderList(ListNode head) {
            if (head == null) return;
            ListNode fast = head;
            ListNode slow = head;
            //slow就是中间节点，用中间节点将链表分成两个部分
            while (true) {
                fast = fast.next;
                if (fast == null) break;
                fast = fast.next;
                if (fast == null) break;
                slow = slow.next;
            }
            //翻转第二个链表
            ListNode left = slow;
            ListNode right = slow.next;
            left.next = null;
            while (right != null) {
                ListNode temp = right.next;
                right.next = left;
                left = right;
                right = temp;
            }
            //合并两个链表
            ListNode first = head;
            ListNode second = left;
            //合并
            while (second != null && first != null) {
                ListNode temp = first.next;
                first.next = second;
                ListNode temp2 = second.next;
                second.next = temp;
                first = temp;
                second = temp2;
            }
        }
    }
}
