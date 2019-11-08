package LinkedList;
//237
//���дһ��������ʹ�����ɾ��ĳ�������и����ģ���ĩβ���ڵ㣬�㽫ֻ������Ҫ��ɾ���Ľڵ㡣
//����һ������ -- head = [4,5,1,9]�������Ա�ʾΪ:
//ʾ�� 1:
//����: head = [4,5,1,9], node = 5
//���: [4,1,9]
//����: ������������ֵΪ 5 �ĵڶ����ڵ㣬��ô�ڵ�������ĺ���֮�󣬸�����Ӧ��Ϊ 4 -> 1 -> 9.
//ʾ�� 2:
//����: head = [4,5,1,9], node = 1
//���: [4,5,9]
//����: ������������ֵΪ 1 �ĵ������ڵ㣬��ô�ڵ�������ĺ���֮�󣬸�����Ӧ��Ϊ 4 -> 5 -> 9.
//˵��:
//	�������ٰ��������ڵ㡣
//	���������нڵ��ֵ����Ψһ�ġ�
//	�����Ľڵ�Ϊ��ĩβ�ڵ㲢��һ���������е�һ����Ч�ڵ㡣
//	��Ҫ����ĺ����з����κν����
public class delete_node_in_a_linked_list {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        one.next = two;
        two.next = three;
        three.next = four;
        new delete_node_in_a_linked_list.Solution().deleteNode(one);
        System.out.println(ListNode.listNodeToString(one));
    }

    static class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
