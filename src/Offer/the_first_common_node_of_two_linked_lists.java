package Offer;

//https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=13&tqId=11189&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//�������������ҳ����ǵĵ�һ��������㡣��ע����Ϊ�����������������Դ���������ݵ���ʾ����������ʽ��ʾ�ģ���֤������������ȷ�ģ�
public class the_first_common_node_of_two_linked_lists {
    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        System.out.println(new Solution().FindFirstCommonNode(p1, p3).val);
    }

    //��pHead1��pHead2����һ��������б�������Ϊ������ͬ�����ڱ�������ǰ���ҵ������ڵ�
    public static class Solution {
        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            if (pHead1 == null || pHead2 == null) return null;
            ListNode p1 = pHead1, p2 = pHead2;
            while (p1 != p2) {
                p1 = p1.next;
                p2 = p2.next;
                if (p1 == null && p2 == null) break;
                if (p1 == null) {
                    p1 = pHead2;
                }
                if (p2 == null) {
                    p2 = pHead1;
                }
            }
            return p1;
        }
    }
}
