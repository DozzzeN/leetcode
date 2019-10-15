package LinkedList;

import com.sun.jdi.IntegerValue;

//148
//�� O(n log n) ʱ�临�ӶȺͳ������ռ临�Ӷ��£��������������
//ʾ�� 1:
//����: 4->2->1->3
//���: 1->2->3->4
//ʾ�� 2:
//����: -1->5->3->4->0
//���: -1->0->3->4->5
public class sort_list {
    public static void main(String[] args) {
        ListNode head = ListNode.stringToListNode("[5,7,3,9,1,2,6,8,4]");
        ListNode result = new sort_list.Solution().sortList(head);
        System.out.println(ListNode.listNodeToString(result));
    }
    //�ϲ����� ʹ�õݹ�ʱ�ռ临�Ӷ�ΪO(logn)
    //֪ʶ��1���鲢���������˼��
    //֪ʶ��2���ҵ�һ��������м�ڵ�ķ���
    //֪ʶ��3���ϲ��������ź��������Ϊһ���µ���������
    static class Solution {
        public ListNode sortList(ListNode head) {
            ListNode p = head;
            int length = 0;
            while (p != null) {
                p = p.next;
                length++;
            }
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            for (int interval = 1; interval <= length; interval = interval * 2) {
                if (interval == 2) {
                    System.out.println();
                }
                //ÿ�δ�dummy�ڵ㿪ʼ��dummy�Ƿ�ֹͷ�ڵ�ı�λ������������ͷ�ڵ�
                ListNode pre = dummy;
                ListNode slow = dummy.next;
                ListNode fast = dummy.next;
                while (fast != null || slow != null) {
                    int i =0;
                    while (i < interval && fast != null) {
                        //fastָ����ǰ�ƶ�interval����ָ��˴κϲ�����һ��interval�����λ��
                        //����һ��intervalʱ��fast����Ϊ��
                        fast = fast.next;
                        i++;
                    }
                    int fvisit = 0, svisit = 0;
                    while (fvisit < interval && svisit < interval && fast != null && slow != null) {
                        if (fast.val < slow.val) {
                            pre.next = fast;
                            pre = fast;
                            fast = fast.next;
                            fvisit++;
                        } else {
                            pre.next = slow;
                            pre = slow;
                            slow = slow.next;
                            svisit++;
                        }
                    }
                    while (fvisit < interval && fast != null) {
                        pre.next = fast;
                        pre = fast;
                        fast = fast.next;
                        fvisit++;
                    }
                    while (svisit < interval && slow != null) {
                        pre.next = slow;
                        pre = slow;
                        slow = slow.next;
                        svisit++;
                    }
                    pre.next = fast;//����pre�ڵ㣬ָ��ʣ�ಿ��
                    slow = fast;//�����ڵ�ͬʱָ����һ��interval�����
                }
            }
            return dummy.next;
        }
    }
}
