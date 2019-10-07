package LinkedList;

//83
//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//示例 1:
//输入: 1->1->2
//输出: 1->2
//示例 2:
//输入: 1->1->2->3->3
//输出: 1->2->3
public class remove_duplicates_from_sorted_list {
    public static void main(String[] args) {
        ListNode head = ListNode.stringToListNode("[1,1,1,2]");
        ListNode result = new remove_duplicates_from_sorted_list.Solution().deleteDuplicates(head);
        System.out.println(ListNode.listNodeToString(result));
    }

    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) return null;
            ListNode p = head.next;
            ListNode pre = head;
            while (p != null) {
                if (pre.val == p.val) {
                    p = p.next;
                    pre.next = p;
                    continue;
                }
                p = p.next;
                pre = pre.next;
            }
            return head;
        }
    }
}
