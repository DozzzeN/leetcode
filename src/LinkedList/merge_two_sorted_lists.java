package LinkedList;

//21
//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//示例：
//输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
public class merge_two_sorted_lists {
    public static void main(String[] args) {
        ListNode l1 = ListNode.stringToListNode("[1,2,4]");

        ListNode l2 = ListNode.stringToListNode("[1,3,4]");
        ListNode result = new merge_two_sorted_lists.Solution().mergeTwoLists(l1, l2);
        System.out.println(ListNode.listNodeToString(result));
    }

    //用双指针分别扫描两个链表，扫描过程中，不断比较两个指针指向的链表节点的值，将小的节点插入到新链表中
    static class Solution {
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
