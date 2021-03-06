package Offer;

//解题思路
//①如果该节点不是尾节点，那么可以直接将下一个节点的值赋给该节点，然后令该节点指向下下个节点，再删除下一个节点，时间复杂度为O(1)。
//②否则，就需要先遍历链表，找到节点的前一个节点，然后让前一个节点指向null，时间复杂度为O(N)。
//综上，如果进行N次操作，那么大约需要操作节点的次数为N-1+N=2N-1，
//其中N-1表示N-1个不是尾节点的每个节点以O(1)的时间复杂度操作节点的总次数，
//N表示1个尾节点以O(N)的时间复杂度操作节点的总次数。(2N-1)/N~2，因此该算法的平均时间复杂度为O(1)。
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
            //要删除的节点不是尾节点
            ListNode next = tobeDelete.next;
            tobeDelete.val = next.val;
            tobeDelete.next = next.next;
        } else {
            //只有一个节点
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
