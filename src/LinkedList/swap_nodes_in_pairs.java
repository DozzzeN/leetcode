package LinkedList;

//24
//����һ���������������������ڵĽڵ㣬�����ؽ����������
//�㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����
//ʾ��:
//���� 1->2->3->4, ��Ӧ�÷��� 2->1->4->3.
public class swap_nodes_in_pairs {
    public static void main(String[] args) {
        ListNode head = ListNode.stringToListNode("[1,2,3,4]");
        ListNode result = new swap_nodes_in_pairs.Solution().swapPairs(head);
        System.out.println(ListNode.listNodeToString(result));
    }

    static class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null) return null;
            if (head.next == null) return head;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;//����ͷ����Ϊ�����Ժ�ͷ���
            ListNode pre = head.next;
            ListNode cur = head;
            ListNode post = dummy;
            while (pre != null) {
                ListNode temp = pre.next;
                pre.next = cur;
                cur.next = temp;
                post.next = pre;
                post = cur;
                if (post.next == null) break;
                cur = post.next;
                pre = cur.next;
            }
            return dummy.next;
        }
    }
}
