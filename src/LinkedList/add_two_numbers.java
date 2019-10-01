package LinkedList;

//2
//�������� �ǿ� ������������ʾ�����Ǹ������������У����Ǹ��Ե�λ���ǰ��� ���� �ķ�ʽ�洢�ģ��������ǵ�ÿ���ڵ�ֻ�ܴ洢 һλ ���֡�
//��������ǽ��������������������᷵��һ���µ���������ʾ���ǵĺ͡�
//�����Լ���������� 0 ֮�⣬���������������� 0 ��ͷ��
//ʾ����
//���룺(2 -> 4 -> 3) + (5 -> 6 -> 4)
//�����7 -> 0 -> 8
//ԭ��342 + 465 = 807

//��һ���б����һ���б�ʱ
//��һ���б�Ϊ��ʱ�������ֿ��б�
//������������ܳ��ֶ���Ľ�λ����һ������ױ����� 99+1
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
                //�յ�����ʹ��0����
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

                //����޽�λ
                if (temp.val + l1.val + l2.val < 10) {
                    temp.val += l1.val + l2.val;
                    //�����µ�λ��
                    if (l1.next != null || l2.next != null) {
                        temp.next = new ListNode(0);
                    } else {
                        temp.next = null;
                    }
                } else {
                    //�н�λ
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

