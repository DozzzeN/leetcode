package LinkedList;

//61
//����һ��������ת����������ÿ���ڵ������ƶ� k ��λ�ã����� k �ǷǸ�����
//ʾ�� 1:
//����: 1->2->3->4->5->NULL, k = 2
//���: 4->5->1->2->3->NULL
//����:
//������ת 1 ��: 5->1->2->3->4->NULL
//������ת 2 ��: 4->5->1->2->3->NULL
//ʾ�� 2:
//����: 0->1->2->NULL, k = 4
//���: 2->0->1->NULL
//����:
//������ת 1 ��: 2->0->1->NULL
//������ת 2 ��: 1->2->0->NULL
//������ת 3 ��: 0->1->2->NULL
//������ת 4 ��: 2->0->1->NULL
public class rotate_list {
    public static void main(String[] args) {
        ListNode head = ListNode.stringToListNode("[1,2,3,4,5]");
        ListNode result = new rotate_list.Solution().rotateRight(head, 0);
        System.out.println(ListNode.listNodeToString(result));
    }

    //���ȱ����ڵ�õ�������
    //Ȼ��βָ��ָ��ͷָ�룬�����������γɻ���������ǰ��len-k%len��������Ͽ�����
    static class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || k == 0) return head;
            int len = 1;
            ListNode p = head;
            while (p.next != null) {
                p = p.next;
                len++;
            }
            p.next = head;
            k = len - k % len;
            while (k > 0) {
                p = p.next;
                k--;
            }
            head = p.next;
            p.next = null;
            return head;
        }
    }
}
