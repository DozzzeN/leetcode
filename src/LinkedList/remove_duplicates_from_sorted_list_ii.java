package LinkedList;

//82
//����һ����������ɾ�����к����ظ����ֵĽڵ㣬ֻ����ԭʼ������ û���ظ����� �����֡�
//ʾ�� 1:
//����: 1->2->3->3->4->4->5
//���: 1->2->5
//ʾ�� 2:
//����: 1->1->1->2->3
//���: 2->3
public class remove_duplicates_from_sorted_list_ii {
    public static void main(String[] args) {
        ListNode head = ListNode.stringToListNode("[1,2,3,3,3,5]");
        ListNode result = new remove_duplicates_from_sorted_list_ii.Solution().deleteDuplicates(head);
        System.out.println(ListNode.listNodeToString(result));
    }

    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode pre = new ListNode(Integer.MIN_VALUE);
            ListNode _head = pre;
            ListNode p = head;
            while (p != null) {
                boolean isDup = false;
                while (p.next != null && p.next.val == p.val) {
                    isDup = true;
                    p = p.next;
                }
                if (isDup) {
                    p = p.next;
                    continue;
                }
                pre.next = p;
                pre = pre.next;
                p = p.next;
            }
            pre.next = p;
            return _head.next;
        }
    }
}
