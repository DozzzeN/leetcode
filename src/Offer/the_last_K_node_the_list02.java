package Offer;

import LinkedList.ListNode;

//https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&tqId=11167&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
//输入一个链表，输出该链表中倒数第k个结点。
public class the_last_K_node_the_list02 {
    public static void main(String[] args) {
        ListNode input = ListNode.stringToListNode("[1,2,3,4,5]");
        ListNode output = new the_last_K_node_the_list02.Solution().FindKthToTail(input, 6);
        System.out.println(output);
    }

    //设链表的长度为N。设置两个指针P1和P2，先让P1移动K个节点，则还有N-K个节点可以移动。
    //此时让P1和P2同时移动，可以知道当P1移动到链表结尾时，P2移动到第N-K个节点处，该位置就是倒数第K个节点。
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
