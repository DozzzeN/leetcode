package LinkedList;

//21
//��������������ϲ�Ϊһ���µ������������ء���������ͨ��ƴ�Ӹ�����������������нڵ���ɵġ�
//ʾ����
//���룺1->2->4, 1->3->4
//�����1->1->2->3->4->4
public class merge_two_sorted_lists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode result = new merge_two_sorted_lists.Solution().mergeTwoLists(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    //��˫ָ��ֱ�ɨ����������ɨ������У����ϱȽ�����ָ��ָ�������ڵ��ֵ����С�Ľڵ���뵽��������
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
