package LinkedList;

//141
//���룺head = [3,2,0,-4], pos = 1
//�����true
//���ͣ���������һ��������β�����ӵ��ڶ����ڵ㡣
//ʾ�� 2��
//���룺head = [1,2], pos = 0
//�����true
//���ͣ���������һ��������β�����ӵ���һ���ڵ㡣
//ʾ�� 3��
//���룺head = [1], pos = -1
//�����false
//���ͣ�������û�л���
public class linked_list_cycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(new linked_list_cycle.Solution().hasCycle(head));
    }

    static public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) return false;
            ListNode slow = head;
            ListNode fast = head;
            while (slow != null && fast != null) {
                slow = slow.next;
                if (fast.next != null) {
                    fast = fast.next.next;
                } else return false;
                if (slow == fast) return true;
            }
            return false;
        }
    }
}
