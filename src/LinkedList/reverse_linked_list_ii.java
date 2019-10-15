package LinkedList;

//92
//��ת��λ�� m �� n ��������ʹ��һ��ɨ����ɷ�ת��
//˵��:
//1 �� m �� n �� �����ȡ�
//ʾ��:
//����: 1->2->3->4->5->NULL, m = 2, n = 4
//���: 1->4->3->2->5->NULL
public class reverse_linked_list_ii {
    public static void main(String[] args) {
        ListNode head = ListNode.stringToListNode("[1,2]");
        ListNode result = new reverse_linked_list_ii.Solution().reverseBetween(head, 1, 2);
        System.out.println(ListNode.listNodeToString(result));
    }

    //�ҵ�m�ڵ��ǰһ���ڵ�pre��ʹ��dummy�ڵ���⴦��ͷ�ڵ�������
    //��m�ڵ㿪ʼ�������m-n���ڵ㣬���з�ת
    //�ϲ���������
    static class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (n - m == 0) return head;
            int step = n - m;
            ListNode dummy = new ListNode(Integer.MIN_VALUE);
            dummy.next = head;
            head = dummy;
            ListNode pre = head;
            while (m > 1) {
                pre = pre.next;
                m--;
            }
            ListNode cur = pre.next;
            ListNode post = cur.next;
            while (step > 0 && post != null) {
                ListNode temp = post.next;//���漴�����жϵĽڵ�
                post.next = cur;
                cur = post;
                post = temp;
                step--;
            }
            ListNode temp = pre.next;
            pre.next = cur;
            temp.next = post;
            return head.next;
        }
    }
}
