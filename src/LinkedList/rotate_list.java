package LinkedList;

//61
//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
//示例 1:
//输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
//示例 2:
//输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL
public class rotate_list {
    public static void main(String[] args) {
        ListNode head = ListNode.stringToListNode("[1,2,3,4,5]");
        ListNode result = new rotate_list.Solution().rotateRight(head, 0);
        System.out.println(ListNode.listNodeToString(result));
    }

    //首先遍历节点得到链表长度
    //然后将尾指针指向头指针，将整个链表形成环，接着往前跑len-k%len，从这里断开即可
    static class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || k == 0) return head;
            int len = 1;
            ListNode p = head;
            while (p.next != null) {
                p = p.next;
                len++;
            }
            p.next = head;
            k = len - k % len;
            while (k > 0) {
                p = p.next;
                k--;
            }
            head = p.next;
            p.next = null;
            return head;
        }
    }
}
