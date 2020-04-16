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
        ListNode input2 = ListNode.stringToListNode("[1,2,3,4,5]");
        System.out.println(ListNode.listNodeToString(new reverse_linked_list.Solution().reverseList02(input2)));
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

        //ͷ�巨 new->head->next ��next���뵽new��head֮�䣬Ȼ��ԭ����next�����ڵ�head
        public ListNode reverseList02(ListNode head) {
            ListNode newList = new ListNode(-1);
            while (head != null) {
                ListNode next = head.next;
                head.next = newList.next;
                newList.next = head;
                head = next;
            }
            return newList.next;
        }
    }
}
