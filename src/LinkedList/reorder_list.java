package LinkedList;

//143
//����һ�������� L��L0��L1������Ln-1��Ln ��
//�����������к��Ϊ�� L0��Ln��L1��Ln-1��L2��Ln-2����
//�㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����
//ʾ�� 1:
//�������� 1->2->3->4, ��������Ϊ 1->4->2->3.
//ʾ�� 2:
//�������� 1->2->3->4->5, ��������Ϊ 1->5->2->4->3.
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
            //slow�����м�ڵ㣬���м�ڵ㽫����ֳ���������
            while (true) {
                fast = fast.next;
                if (fast == null) break;
                fast = fast.next;
                if (fast == null) break;
                slow = slow.next;
            }
            //��ת�ڶ�������
            ListNode left = slow;
            ListNode right = slow.next;
            left.next = null;
            while (right != null) {
                ListNode temp = right.next;
                right.next = left;
                left = right;
                right = temp;
            }
            //�ϲ���������
            ListNode first = head;
            ListNode second = left;
            //�ϲ�
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
