package LinkedList;

//24
//����һ���������������������ڵĽڵ㣬�����ؽ����������
//�㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����
//ʾ��:
//���� 1->2->3->4, ��Ӧ�÷��� 2->1->4->3.
public class swap_nodes_in_pairs02 {
    public static void main(String[] args) {
        ListNode head = ListNode.stringToListNode("[1,2,3,4]");
        ListNode result = new swap_nodes_in_pairs02.Solution().swapPairs(head);
        System.out.println(ListNode.listNodeToString(result));
    }

    static class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode newPair = head.next.next;
            ListNode newHead = head.next;
            head.next.next = head;
            head.next = swapPairs(newPair);
            return newHead;
        }
    }
}
