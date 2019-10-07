package LinkedList;

//21
//��������������ϲ�Ϊһ���µ������������ء���������ͨ��ƴ�Ӹ�����������������нڵ���ɵġ�
//ʾ����
//���룺1->2->4, 1->3->4
//�����1->1->2->3->4->4
public class merge_two_sorted_lists02 {
    public static void main(String[] args) {
        ListNode l1 = ListNode.stringToListNode("[1,2,4]");

        ListNode l2 = ListNode.stringToListNode("[1,3,4]");
        ListNode result = new merge_two_sorted_lists02.Solution().mergeTwoLists(l1, l2);
        System.out.println(ListNode.listNodeToString(result));
    }

    //�ݹ�
    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            } else if (l2 == null) {
                return l1;
            } else if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }
}
