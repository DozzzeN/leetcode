package Offer;

//����˼·
//������ýڵ㲻��β�ڵ㣬��ô����ֱ�ӽ���һ���ڵ��ֵ�����ýڵ㣬Ȼ����ýڵ�ָ�����¸��ڵ㣬��ɾ����һ���ڵ㣬ʱ�临�Ӷ�ΪO(1)��
//�ڷ��򣬾���Ҫ�ȱ��������ҵ��ڵ��ǰһ���ڵ㣬Ȼ����ǰһ���ڵ�ָ��null��ʱ�临�Ӷ�ΪO(N)��
//���ϣ��������N�β�������ô��Լ��Ҫ�����ڵ�Ĵ���ΪN-1+N=2N-1��
//����N-1��ʾN-1������β�ڵ��ÿ���ڵ���O(1)��ʱ�临�ӶȲ����ڵ���ܴ�����
//N��ʾ1��β�ڵ���O(N)��ʱ�临�ӶȲ����ڵ���ܴ�����(2N-1)/N~2����˸��㷨��ƽ��ʱ�临�Ӷ�ΪO(1)��
public class delete_the_linked_list_node_in_O1_time {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        ListNode result = new delete_the_linked_list_node_in_O1_time().deleteNode(node, node.next.next);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if (head == null || tobeDelete == null) return null;
        if (tobeDelete.next != null) {
            //Ҫɾ���Ľڵ㲻��β�ڵ�
            ListNode next = tobeDelete.next;
            tobeDelete.val = next.val;
            tobeDelete.next = next.next;
        } else {
            //ֻ��һ���ڵ�
            if (head == tobeDelete) head = null;
            else {
                ListNode cur = head;
                while (cur.next != tobeDelete)
                    cur = cur.next;
                cur.next = null;
            }
        }
        return head;
    }
}
