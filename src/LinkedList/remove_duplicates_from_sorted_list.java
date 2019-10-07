package LinkedList;

//83
//����һ����������ɾ�������ظ���Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Ρ�
//ʾ�� 1:
//����: 1->1->2
//���: 1->2
//ʾ�� 2:
//����: 1->1->2->3->3
//���: 1->2->3
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
