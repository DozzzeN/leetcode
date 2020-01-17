package Offer;

import LinkedList.ListNode;

//https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&tqId=11167&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
//输入一个链表，输出该链表中倒数第k个结点。
public class The_last_K_node_the_list02 {
    public static void main(String[] args) {
        ListNode input = ListNode.stringToListNode("[1,2,3,4,5]");
        ListNode output = new The_last_K_node_the_list02.Solution().FindKthToTail(input, 6);
        System.out.println(output);
    }

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
