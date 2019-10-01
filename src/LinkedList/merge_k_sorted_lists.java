package LinkedList;

//23
//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
//示例:
//输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6
public class merge_k_sorted_lists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode[] input = new ListNode[]{l1, l2, l3};
        ListNode result = new merge_k_sorted_lists.Solution().mergeKLists(input);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) return null;
            ListNode result = lists[0];
            for (int i = 1; i < lists.length; i++) {
                result = mergeTwoLists(result, lists[i]);
            }
            return result;
        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(-1);
            ListNode result = head;
            while (l1 != null || l2 != null) {
                int val1 = l1 == null ? Integer.MAX_VALUE : l1.val;
                int val2 = l2 == null ? Integer.MAX_VALUE : l2.val;
                if (val1 <= val2) {
                    result.next = l1;
                    l1 = l1.next;
                } else {
                    result.next = l2;
                    l2 = l2.next;
                }
                result = result.next;
            }
            result = head.next;
            return result;
        }
    }
}
