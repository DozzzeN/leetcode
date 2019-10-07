package LinkedList;

//86
//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
//你应当保留两个分区中每个节点的初始相对位置。
//示例:
//输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
public class partition_list {
    public static void main(String[] args) {
        ListNode head = ListNode.stringToListNode("[2,1]");
        ListNode result = new partition_list.Solution().partition(head, 2);
        System.out.println(ListNode.listNodeToString(result));
    }
    //从左往右扫描，首先找到第一个大于X的指针，然后在该指针左边不断插入小于X的元素
    //在头节点之前插入节点防止头节点为空
    static class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode p = new ListNode(x - 1);
            p.next = head;
            head = p;
            ListNode pre = null;
            //pre指向大于x的前一个节点
            //p指向大于x的第一个节点
            while (p != null) {
                if (p.val >= x) break;
                pre = p;
                p = p.next;
            }
            ListNode cur = pre;
            while (p != null) {
                if (p.val < x) {
                    ListNode temp = cur.next;
                    pre.next = p.next;
                    cur.next = p;
                    p.next = temp;
                    cur = cur.next;
                }
                pre = p;
                p = p.next;
            }
            head = head.next;
            return head;
        }
    }
}
