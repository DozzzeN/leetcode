package LinkedList;

//92
//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//说明:
//1 ≤ m ≤ n ≤ 链表长度。
//示例:
//输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL
public class reverse_linked_list_ii {
    public static void main(String[] args) {
        ListNode head = ListNode.stringToListNode("[1,2]");
        ListNode result = new reverse_linked_list_ii.Solution().reverseBetween(head, 1, 2);
        System.out.println(ListNode.listNodeToString(result));
    }

    //找到m节点的前一个节点pre（使用dummy节点避免处理头节点的情况）
    //从m节点开始往后遍历m-n个节点，进行翻转
    //合并三个链表
    static class Solution {
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
