package LinkedList;

//206
//��תһ��������
//ʾ��:
//����: 1->2->3->4->5->NULL
//���: 5->4->3->2->1->NULL
//����:
//����Ե�����ݹ�ط�ת�������ܷ������ַ����������⣿
public class reverse_linked_list02 {
    public static void main(String[] args) {
        ListNode input = ListNode.stringToListNode("[1,2,3,4,5]");
        System.out.println(ListNode.listNodeToString(new reverse_linked_list02.Solution().reverseList(input)));
    }

    //�ݹ�
    //1->2->3->4->5->NULL
    //��1��[2->3->4->5->NULL]���������ڵ���з�ת
    //NULL<-1<-[2->3->4->5->NULL]
    static class Solution {
        public ListNode reverseList(ListNode head) {//���ط�ת���ͷ�ڵ�
            if (head == null || head.next == null) return head;//�ѵ�β�ڵ�
            ListNode newHead = reverseList(head.next);//[2->3->4->5->NULL]���[2<-3<-4<-5] newHeadָ��5
            head.next.next = head;//NULL<-1<-2
            head.next = null;//NULL<-1  �жϸýڵ���ǰһ���ڵ�֮�����ϵ�����ұ���ѭ���Ĳ���
            return newHead;
        }
    }
}
