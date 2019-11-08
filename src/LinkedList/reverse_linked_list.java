package LinkedList;

//206
//��תһ��������
//ʾ��:
//����: 1->2->3->4->5->NULL
//���: 5->4->3->2->1->NULL
//����:
//����Ե�����ݹ�ط�ת�������ܷ������ַ����������⣿
public class reverse_linked_list {
    public static void main(String[] args) {
        ListNode input = ListNode.stringToListNode("[1,2,3,4,5]");
        System.out.println(ListNode.listNodeToString(new reverse_linked_list.Solution().reverseList(input)));
    }

    static class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null) return null;
            ListNode cur = new ListNode(head.val);
            ListNode next = head.next;
            ListNode temp;
            while (next != null) {
                temp = next.next;
                next.next = cur;
                cur = next;
                next = temp;
            }
            return cur;
        }
    }
}
