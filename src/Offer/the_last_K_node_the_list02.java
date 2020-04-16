package Offer;

import LinkedList.ListNode;

//https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&tqId=11167&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
//����һ����������������е�����k����㡣
public class the_last_K_node_the_list02 {
    public static void main(String[] args) {
        ListNode input = ListNode.stringToListNode("[1,2,3,4,5]");
        ListNode output = new the_last_K_node_the_list02.Solution().FindKthToTail(input, 6);
        System.out.println(output);
    }

    //������ĳ���ΪN����������ָ��P1��P2������P1�ƶ�K���ڵ㣬����N-K���ڵ�����ƶ���
    //��ʱ��P1��P2ͬʱ�ƶ�������֪����P1�ƶ��������βʱ��P2�ƶ�����N-K���ڵ㴦����λ�þ��ǵ�����K���ڵ㡣
    static public class Solution {
        public ListNode FindKthToTail(ListNode head, int k) {
            ListNode fast = head, slow = head;
            for (int i = 0; i < k; i++) {
                if (fast == null) return null;
                fast = fast.next;
            }
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}
