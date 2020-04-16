package Offer;

import LinkedList.ListNode;

import java.util.ArrayList;
import java.util.Stack;

//https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
//输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
public class print_the_linked_list_from_end_to_end {
    public static void main(String[] args) {
        ListNode input = ListNode.stringToListNode("[1,2,3,4,5]");
        ArrayList<Integer> output = new print_the_linked_list_from_end_to_end.Solution().printListFromTailToHead(input);
        System.out.println(output);
    }

    //在遍历链表时将值按顺序放入栈中，最后出栈的顺序即为逆序。
    public static class Solution {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> result = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            while (listNode != null) {
                stack.push(listNode.val);
                listNode = listNode.next;
            }
            while (!stack.isEmpty()) {
                result.add(stack.pop());
            }
            return result;
        }
    }
}
