package LinkedList;

import com.sun.jdi.IntegerValue;

//148
//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
//示例 1:
//输入: 4->2->1->3
//输出: 1->2->3->4
//示例 2:
//输入: -1->5->3->4->0
//输出: -1->0->3->4->5
public class sort_list {
    public static void main(String[] args) {
        ListNode head = ListNode.stringToListNode("[5,7,3,9,1,2,6,8,4]");
        ListNode result = new sort_list.Solution().sortList(head);
        System.out.println(ListNode.listNodeToString(result));
    }
    //合并排序 使用递归时空间复杂度为O(logn)
    //知识点1：归并排序的整体思想
    //知识点2：找到一个链表的中间节点的方法
    //知识点3：合并两个已排好序的链表为一个新的有序链表
    static class Solution {
        public ListNode sortList(ListNode head) {
            ListNode p = head;
            int length = 0;
            while (p != null) {
                p = p.next;
                length++;
            }
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            for (int interval = 1; interval <= length; interval = interval * 2) {
                if (interval == 2) {
                    System.out.println();
                }
                //每次从dummy节点开始，dummy是防止头节点改变位置设立的虚拟头节点
                ListNode pre = dummy;
                ListNode slow = dummy.next;
                ListNode fast = dummy.next;
                while (fast != null || slow != null) {
                    int i =0;
                    while (i < interval && fast != null) {
                        //fast指针向前移动interval步，指向此次合并的下一个interval的起点位置
                        //不足一个interval时，fast可能为空
                        fast = fast.next;
                        i++;
                    }
                    int fvisit = 0, svisit = 0;
                    while (fvisit < interval && svisit < interval && fast != null && slow != null) {
                        if (fast.val < slow.val) {
                            pre.next = fast;
                            pre = fast;
                            fast = fast.next;
                            fvisit++;
                        } else {
                            pre.next = slow;
                            pre = slow;
                            slow = slow.next;
                            svisit++;
                        }
                    }
                    while (fvisit < interval && fast != null) {
                        pre.next = fast;
                        pre = fast;
                        fast = fast.next;
                        fvisit++;
                    }
                    while (svisit < interval && slow != null) {
                        pre.next = slow;
                        pre = slow;
                        slow = slow.next;
                        svisit++;
                    }
                    pre.next = fast;//更新pre节点，指向剩余部分
                    slow = fast;//快慢节点同时指向下一个interval的起点
                }
            }
            return dummy.next;
        }
    }
}
