package LinkedList;

//19
//����һ������ɾ������ĵ����� n ���ڵ㣬���ҷ��������ͷ��㡣
//ʾ����
//����һ������: 1->2->3->4->5, �� n = 2.
//��ɾ���˵����ڶ����ڵ�������Ϊ 1->2->3->5.
//˵����
//������ n ��֤����Ч�ġ�
//���ף�
//���ܳ���ʹ��һ��ɨ��ʵ����
public class remove_nth_node_from_end_of_list {
    public static void main(String[] args) {
        ListNode head = ListNode.stringToListNode("[1,2,3,4,5]");
        ListNode result = new remove_nth_node_from_end_of_list.Solution().removeNthFromEnd(head, 5);
        System.out.println(ListNode.listNodeToString(result));
    }

    //һ��ָ������n����Ȼ������ָ��һ���ߣ�����һ��ָ��ָ���յ��ʱ�򣬵ڶ���ָ��ָ���Ԫ�ؼ�Ϊ����
    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode pre = head;
            ListNode p = head;
            //��ѭ��һ��
            for (int i = 0; i < n; i++) {
                p = p.next;
            }
            //ɾ������ͷ�ڵ�
            if (p == null) {
                return head.next;
            }
            //preָ��Ҫɾ������һ���ڵ�
            while (p.next != null) {
                p = p.next;
                pre = pre.next;
            }
            pre.next = pre.next.next;
            return head;
        }
    }
}
