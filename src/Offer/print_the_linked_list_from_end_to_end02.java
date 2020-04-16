package Offer;

import LinkedList.ListNode;

import java.util.ArrayList;

//https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
//输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
public class print_the_linked_list_from_end_to_end02 {
    public static void main(String[] args) {
        ListNode input = ListNode.stringToListNode("[1,2,3,4,5]");
        ArrayList<Integer> output = new print_the_linked_list_from_end_to_end02.Solution().printListFromTailToHead(input);
        System.out.println(output);
    }

    public static class Solution {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> result = new ArrayList<>();
            while (listNode != null) {
                result.add(0, listNode.val);
                listNode = listNode.next;
            }
            return result;
        }
    }
}
