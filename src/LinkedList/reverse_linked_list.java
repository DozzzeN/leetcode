package LinkedList;

//206
//反转一个单链表。
//示例:
//输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//进阶:
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
public class reverse_linked_list {
    public static void main(String[] args) {
        ListNode input = ListNode.stringToListNode("[1,2,3,4,5]");
        System.out.println(ListNode.listNodeToString(new reverse_linked_list.Solution().reverseList(input)));
        ListNode input2 = ListNode.stringToListNode("[1,2,3,4,5]");
        System.out.println(ListNode.listNodeToString(new reverse_linked_list.Solution().reverseList02(input2)));
    }

    static class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null) return null;
            ListNode cur = new ListNode(head.val);
            ListNode next = head.next;
            ListNode temp;
            while (next != null) {
                temp = next.next;
                next.next = cur;
                cur = next;
                next = temp;
            }
            return cur;
        }

        //头插法 new->head->next 将next插入到new和head之间，然后原来的next是现在的head
        public ListNode reverseList02(ListNode head) {
            ListNode newList = new ListNode(-1);
            while (head != null) {
                ListNode next = head.next;
                head.next = newList.next;
                newList.next = head;
                head = next;
            }
            return newList.next;
        }
    }
}
