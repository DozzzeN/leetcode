package LinkedList;

//25
//����һ������ÿ k ���ڵ�һ����з�ת�����㷵�ط�ת�������
//k ��һ��������������ֵС�ڻ��������ĳ��ȡ�
//����ڵ��������� k ������������ô�뽫���ʣ��Ľڵ㱣��ԭ��˳��
//ʾ�� :
//�����������1->2->3->4->5
//�� k = 2 ʱ��Ӧ������: 2->1->4->3->5
//�� k = 3 ʱ��Ӧ������: 3->2->1->4->5
//˵�� :
//	����㷨ֻ��ʹ�ó����Ķ���ռ䡣
//	�㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����

public class reverse_nodes_in_k_group {
    public static void main(String[] args) {
        ListNode head = ListNode.stringToListNode("[1,2,3]");
        ListNode result = new reverse_nodes_in_k_group.Solution().reverseKGroup(head, 3);
        System.out.println(ListNode.listNodeToString(result));
    }

    //����92��ĺ���
    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            int len = 0;
            ListNode p = head;
            while (p != null) {
                len++;
                p = p.next;
            }
            ListNode cur = head;
            for (int i = 1; i + k - 1 <= len; i = i + k) {
                cur = reverseBetween(cur, i, i + k - 1);
            }
            return cur;
        }

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
