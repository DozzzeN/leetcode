package LinkedList;

//2
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//示例：
//输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807

//当一个列表比另一个列表长时
//当一个列表为空时，即出现空列表
//求和运算最后可能出现额外的进位，这一点很容易被遗忘 99+1
public class add_two_numbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        //l2.next.next = new ListNode(4);

        ListNode temp = new add_two_numbers.Solution().addTwoNumbers(l1, l2);
        while (temp != null) {
            System.out.print(temp.val);
            temp = temp.next;
        }
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode temp = new ListNode(0);
            temp.next = null;
            ListNode head = temp;
            while (l1 != null || l2 != null) {
                //空的链表使用0代替
                if (l1 != null && l2 == null) {
                    l2 = new ListNode(0);
                    l2.next = null;
                }
                if (l2 != null && l1 == null) {
                    l1 = new ListNode(0);
                    l1.next = null;
                }

                if (l1 == null && l2 == null) {
                    break;
                }

                //相加无进位
                if (temp.val + l1.val + l2.val < 10) {
                    temp.val += l1.val + l2.val;
                    //还有新的位数
                    if (l1.next != null || l2.next != null) {
                        temp.next = new ListNode(0);
                    } else {
                        temp.next = null;
                    }
                } else {
                    //有进位
                    temp.val = temp.val + l1.val + l2.val - 10;
                    temp.next = new ListNode(1);
                }

                l1 = l1.next;
                l2 = l2.next;

                if (temp.next != null) {
                    temp = temp.next;
                } else {
                    break;
                }

            }
            return head;
        }
    }
}

