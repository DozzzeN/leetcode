package Offer;

//https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&tqId=11209&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
//返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
public class remove_duplicate_nodes_in_a_linked_list {
    public static void main(String[] args) {
        ListNode pHead = new ListNode(1);
        pHead.next = new ListNode(1);
        pHead.next.next = new ListNode(1);
        pHead.next.next.next = new ListNode(1);
        pHead.next.next.next.next = new ListNode(1);
        pHead.next.next.next.next.next = new ListNode(1);
        pHead.next.next.next.next.next.next = new ListNode(2);
        ListNode result = new remove_duplicate_nodes_in_a_linked_list.Solution().deleteDuplication02(pHead);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    //删除:1-1-2
    //操作:pre-cur-next为三个变量 令pre->next = next即可，需要三个变量
    public static class Solution {
        public ListNode deleteDuplication(ListNode pHead) {
            if (pHead == null) return null;
            ListNode dummy = new ListNode(-1);//防止头被删
            dummy.next = pHead;
            ListNode cur = dummy;
            ListNode pre;
            int remove = -1;//保存重复的数字
            while (cur.next != null) {
                pre = cur;
                cur = cur.next;
                ListNode next = cur.next;
                if (next != null) {
                    if (cur.val == next.val || cur.val == remove) {
                        remove = cur.val;
                        pre.next = next.next;
                        cur = pre;
                    } else {
                        cur = pre.next;
                    }
                } else if (cur.val == remove) {
                    //全部都被删除:1-1-1-1-1
                    pre.next = null;
                }
            }
            return dummy.next;
        }

        public ListNode deleteDuplication02(ListNode pHead) {
            if (pHead == null || pHead.next == null) return pHead;
            ListNode next = pHead.next;
            if (pHead.val == next.val) {
                while (next != null && pHead.val == next.val)
                    next = next.next;//多个相同的值时，next指向下一个不相同的节点，如2-2-2-3，next指向3
                return deleteDuplication02(next);//忽略2，直接返回3
            } else {
                pHead.next = deleteDuplication02(pHead.next);
                return pHead;
            }
        }
    }
}
