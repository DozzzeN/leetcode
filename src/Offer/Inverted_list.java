package Offer;

import LinkedList.ListNode;

//https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=13&tqId=11168&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//输入一个链表，反转链表后，输出新链表的表头。
public class Inverted_list {
    public static void main(String[] args) {
        ListNode input = ListNode.stringToListNode("[]");
        ListNode output = new Inverted_list.Solution().ReverseList(input);
        System.out.println(ListNode.listNodeToString(output));
    }

    static public class Solution {
        public ListNode ReverseList(ListNode head) {
            if (head == null) return null;
            ListNode p = head.next;
            ListNode cur = head;
            cur.next = null;
            ListNode temp;
            if (p != null) {
                temp = p.next;
            } else {
                return head;
            }
            while (temp != null) {
                p.next = cur;
                cur = p;
                p = temp;
                temp = temp.next;
            }
            p.next = cur;
            return p;
        }
    }
}
