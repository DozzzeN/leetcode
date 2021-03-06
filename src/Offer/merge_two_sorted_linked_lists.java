package Offer;

import LinkedList.ListNode;

//https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&tqId=11169&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
//输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
public class merge_two_sorted_linked_lists {
    public static void main(String[] args) {
        ListNode list1 = ListNode.stringToListNode("[1,3,5,7,9]");
        ListNode list2 = ListNode.stringToListNode("[2,4,6,8]");
        ListNode output = new merge_two_sorted_linked_lists.Solution().Merge(list1, list2);
        System.out.println(ListNode.listNodeToString(output));
        list1 = ListNode.stringToListNode("[1,3,5,7,9]");//重新赋值
        list2 = ListNode.stringToListNode("[2,4,6,8]");
        output = new merge_two_sorted_linked_lists.Solution().Merge02(list1, list2);
        System.out.println(ListNode.listNodeToString(output));
    }

    static public class Solution {
        //迭代
        public ListNode Merge(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    cur.next = list1;
                    list1 = list1.next;
                } else {
                    cur.next = list2;
                    list2 = list2.next;
                }
                cur = cur.next;
            }
            if (list1 != null) {
                cur.next = list1;
            }
            if (list2 != null) {
                cur.next = list2;
            }
            return dummy.next;
        }

        //递归
        //1->3->5
        //2->4->6
        public ListNode Merge02(ListNode list1, ListNode list2) {
            if (list1 == null) return list2;
            if (list2 == null) return list1;
            if (list1.val <= list2.val) {
                list1.next = Merge02(list1.next, list2);//意思是1->merge(3->5,2->4->6)
                return list1;
            } else {
                list2.next = Merge(list1, list2.next);
                return list2;
            }
        }
    }
}
