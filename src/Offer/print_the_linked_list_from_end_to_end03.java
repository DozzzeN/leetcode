package Offer;

import LinkedList.ListNode;

import java.util.ArrayList;

//https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
//����һ�������������β��ͷ��˳�򷵻�һ��ArrayList��
public class print_the_linked_list_from_end_to_end03 {
    public static void main(String[] args) {
        ListNode input = ListNode.stringToListNode("[1,2,3,4,5]");
        ArrayList<Integer> output = new print_the_linked_list_from_end_to_end03.Solution().printListFromTailToHead(input);
        System.out.println(output);
    }

    //�ڱ���ԭʼ����ʱ������ǰ�ڵ�����������ͷ����ʹ���Ϊ��һ���ڵ㡣
    public static class Solution {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ListNode head = new ListNode(-1);
            while (listNode != null) {
                ListNode temp = listNode.next;
                listNode.next = head.next;
                head.next = listNode;
                listNode = temp;
            }
            ArrayList<Integer> result = new ArrayList<>();
            head = head.next;
            while (head != null) {
                result.add(head.val);
                head = head.next;
            }
            return result;
        }
    }
}
