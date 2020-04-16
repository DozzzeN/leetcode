package Offer;

import LinkedList.ListNode;

import java.util.ArrayList;

//https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
//输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
public class print_the_linked_list_from_end_to_end03 {
    public static void main(String[] args) {
        ListNode input = ListNode.stringToListNode("[1,2,3,4,5]");
        ArrayList<Integer> output = new print_the_linked_list_from_end_to_end03.Solution().printListFromTailToHead(input);
        System.out.println(output);
    }

    //在遍历原始链表时，将当前节点插入新链表的头部，使其成为第一个节点。
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
