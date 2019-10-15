package LinkedList;

//25
//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//k 是一个正整数，它的值小于或等于链表的长度。
//如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//示例 :
//给定这个链表：1->2->3->4->5
//当 k = 2 时，应当返回: 2->1->4->3->5
//当 k = 3 时，应当返回: 3->2->1->4->5
//说明 :
//	你的算法只能使用常数的额外空间。
//	你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

public class reverse_nodes_in_k_group {
    public static void main(String[] args) {
        ListNode head = ListNode.stringToListNode("[1,2,3]");
        ListNode result = new reverse_nodes_in_k_group.Solution().reverseKGroup(head, 3);
        System.out.println(ListNode.listNodeToString(result));
    }

    //调用92题的函数
    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            int len = 0;
            ListNode p = head;
            while (p != null) {
                len++;
                p = p.next;
            }
            ListNode cur = head;
            for (int i = 1; i + k - 1 <= len; i = i + k) {
                cur = reverseBetween(cur, i, i + k - 1);
            }
            return cur;
        }

        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (n - m == 0) return head;
            int step = n - m;
            ListNode dummy = new ListNode(Integer.MIN_VALUE);
            dummy.next = head;
            head = dummy;
            ListNode pre = head;
            while (m > 1) {
                pre = pre.next;
                m--;
            }
            ListNode cur = pre.next;
            ListNode post = cur.next;
            while (step > 0 && post != null) {
                ListNode temp = post.next;//保存即将被切断的节点
                post.next = cur;
                cur = post;
                post = temp;
                step--;
            }
            ListNode temp = pre.next;
            pre.next = cur;
            temp.next = post;
            return head.next;
        }
    }
}
