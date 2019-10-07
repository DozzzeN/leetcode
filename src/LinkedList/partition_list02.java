package LinkedList;

//86
//����һ�������һ���ض�ֵ x����������зָ���ʹ������С�� x �Ľڵ㶼�ڴ��ڻ���� x �Ľڵ�֮ǰ��
//��Ӧ����������������ÿ���ڵ�ĳ�ʼ���λ�á�
//ʾ��:
//����: head = 1->4->3->2->5->2, x = 3
//���: 1->2->2->4->3->5
public class partition_list02 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        ListNode result = new partition_list02.Solution().partition(head, 3);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    //��X�ָ�ԭ�������������Ȼ������������
    static class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode beforeHead = new ListNode(0);
            ListNode beforeTail = beforeHead;
            ListNode afterHead = new ListNode(0);
            ListNode afterTail = afterHead;
            while (head != null) {
                if (head.val >= x) {
                    afterTail.next = head;
                    afterTail = afterTail.next;
                } else {
                    beforeTail.next = head;
                    beforeTail = beforeTail.next;
                }
                head = head.next;
            }
            afterTail.next = null;
            beforeTail.next = afterHead.next;
            return beforeHead.next;
        }
    }
}
