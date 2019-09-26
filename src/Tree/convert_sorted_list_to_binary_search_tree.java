package Tree;

//109
//����һ�����������е�Ԫ�ذ��������򣬽���ת��Ϊ�߶�ƽ��Ķ�����������
//�����У�һ���߶�ƽ���������ָһ��������ÿ���ڵ� ���������������ĸ߶Ȳ�ľ���ֵ������ 1��
//ʾ��:
//�������������� [-10, -3, 0, 5, 9],
//һ�����ܵĴ��ǣ�[0, -3, 9, -10, null, 5], �����Ա�ʾ��������߶�ƽ�������������
//      0
//     / \
//   -3   9
//   /   /
// -10  5
public class convert_sorted_list_to_binary_search_tree {
    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        System.out.println(new binary_tree_level_order_traversal.Solution().levelOrder
                (new convert_sorted_list_to_binary_search_tree.Solution().sortedListToBST(head)));
    }

    //����ٷ����ʹ�ÿ���ָ�����Ѱ�������м�ڵ�
    static class Solution {
        ListNode head;
        public TreeNode sortedListToBST(ListNode head) {
            this.head = head;
            int length = 0;
            ListNode temp = head;
            while (temp != null) {
                length++;
                temp = temp.next;
            }
            return sortedListToBST(0, length - 1);
        }

        public TreeNode sortedListToBST(int start, int end) {
            if (start > end) return null;
            int mid = (start + end) / 2;
            TreeNode leftChild = sortedListToBST(start, mid - 1);
            TreeNode parent = new TreeNode(head.val);
            parent.left = leftChild;
            head = head.next;
            parent.right = sortedListToBST(mid + 1, end);
            return parent;
        }
    }
}
