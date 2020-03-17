package Offer;

//https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&tqId=11208&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
public class entry_point_of_a_ring_in_a_linked_list {
    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p2;
        System.out.println(new Solution().EntryNodeOfLoop(p1).val);
    }

    public static class Solution {
        public ListNode EntryNodeOfLoop(ListNode pHead) {
            if (pHead == null || pHead.next == null) return null;
            ListNode slow = pHead;
            ListNode fast = pHead;
            while (slow.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    while (pHead != slow) {
                        pHead = pHead.next;
                        slow = slow.next;
                    }
                    return pHead;
                }
            }
            return null;
        }
    }
}
