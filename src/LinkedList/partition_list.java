package LinkedList;

//86
//����һ�������һ���ض�ֵ x����������зָ���ʹ������С�� x �Ľڵ㶼�ڴ��ڻ���� x �Ľڵ�֮ǰ��
//��Ӧ����������������ÿ���ڵ�ĳ�ʼ���λ�á�
//ʾ��:
//����: head = 1->4->3->2->5->2, x = 3
//���: 1->2->2->4->3->5
public class partition_list {
    public static void main(String[] args) {
        ListNode head = ListNode.stringToListNode("[2,1]");
        ListNode result = new partition_list.Solution().partition(head, 2);
        System.out.println(ListNode.listNodeToString(result));
    }
    //��������ɨ�裬�����ҵ���һ������X��ָ�룬Ȼ���ڸ�ָ����߲��ϲ���С��X��Ԫ��
    //��ͷ�ڵ�֮ǰ����ڵ��ֹͷ�ڵ�Ϊ��
    static class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode p = new ListNode(x - 1);
            p.next = head;
            head = p;
            ListNode pre = null;
            //preָ�����x��ǰһ���ڵ�
            //pָ�����x�ĵ�һ���ڵ�
            while (p != null) {
                if (p.val >= x) break;
                pre = p;
                p = p.next;
            }
            ListNode cur = pre;
            while (p != null) {
                if (p.val < x) {
                    ListNode temp = cur.next;
                    pre.next = p.next;
                    cur.next = p;
                    p.next = temp;
                    cur = cur.next;
                }
                pre = p;
                p = p.next;
            }
            head = head.next;
            return head;
        }
    }
}
