package DivideConquer;

import LinkedList.ListNode;

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
public class merge_k_sorted_lists02 {
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
        ListNode result = new merge_k_sorted_lists02.Solution().mergeKLists(input);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    //典型的归并分治思想，自底向上，依次合并(可结合归并排序理解，将每个链表理解成排序的值)
    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) return null;
            return solve(lists, 0, lists.length - 1);
        }

        public ListNode solve(ListNode[] list, int left, int right) {
            if (left == right) return list[left];
            int mid = (left + right) / 2;
            //归
            ListNode lNode = solve(list, left, mid);
            ListNode rNode = solve(list, mid + 1, right);
            //并
            return mergeTwoLists(lNode, rNode);
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
