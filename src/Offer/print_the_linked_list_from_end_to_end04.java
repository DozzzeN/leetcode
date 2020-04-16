package Offer;

import LinkedList.ListNode;

import java.util.ArrayList;

//https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
//����һ�������������β��ͷ��˳�򷵻�һ��ArrayList��
public class print_the_linked_list_from_end_to_end04 {
    public static void main(String[] args) {
        ListNode input = ListNode.stringToListNode("[1,2,3,4,5]");
        ArrayList<Integer> output = new print_the_linked_list_from_end_to_end04.Solution().printListFromTailToHead(input);
        System.out.println(output);
    }

    //Ҫ�����ӡ����1->2->3(3,2,1)�������������ӡ����2->3(3,2)������ٴ�ӡ��һ���ڵ�1��
    //������2->3���Կ���һ���µ�����Ҫ�����ӡ��������Լ���ʹ����⺯��
    public static class Solution {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> result = new ArrayList<>();
            if (listNode != null) {
                result.addAll(printListFromTailToHead(listNode.next));
                result.add(listNode.val);
            }
            return result;
        }
    }
}
