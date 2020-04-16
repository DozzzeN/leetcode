package Offer;

//https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&tqId=11209&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻������
//��������ͷָ�롣 ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
public class remove_duplicate_nodes_in_a_linked_list {
    public static void main(String[] args) {
        ListNode pHead = new ListNode(1);
        pHead.next = new ListNode(1);
        pHead.next.next = new ListNode(1);
        pHead.next.next.next = new ListNode(1);
        pHead.next.next.next.next = new ListNode(1);
        pHead.next.next.next.next.next = new ListNode(1);
        pHead.next.next.next.next.next.next = new ListNode(2);
        ListNode result = new remove_duplicate_nodes_in_a_linked_list.Solution().deleteDuplication02(pHead);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    //ɾ��:1-1-2
    //����:pre-cur-nextΪ�������� ��pre->next = next���ɣ���Ҫ��������
    public static class Solution {
        public ListNode deleteDuplication(ListNode pHead) {
            if (pHead == null) return null;
            ListNode dummy = new ListNode(-1);//��ֹͷ��ɾ
            dummy.next = pHead;
            ListNode cur = dummy;
            ListNode pre;
            int remove = -1;//�����ظ�������
            while (cur.next != null) {
                pre = cur;
                cur = cur.next;
                ListNode next = cur.next;
                if (next != null) {
                    if (cur.val == next.val || cur.val == remove) {
                        remove = cur.val;
                        pre.next = next.next;
                        cur = pre;
                    } else {
                        cur = pre.next;
                    }
                } else if (cur.val == remove) {
                    //ȫ������ɾ��:1-1-1-1-1
                    pre.next = null;
                }
            }
            return dummy.next;
        }

        public ListNode deleteDuplication02(ListNode pHead) {
            if (pHead == null || pHead.next == null) return pHead;
            ListNode next = pHead.next;
            if (pHead.val == next.val) {
                while (next != null && pHead.val == next.val)
                    next = next.next;//�����ͬ��ֵʱ��nextָ����һ������ͬ�Ľڵ㣬��2-2-2-3��nextָ��3
                return deleteDuplication02(next);//����2��ֱ�ӷ���3
            } else {
                pHead.next = deleteDuplication02(pHead.next);
                return pHead;
            }
        }
    }
}
