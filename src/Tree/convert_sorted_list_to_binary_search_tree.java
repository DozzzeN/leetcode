package Tree;

//109
//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
//本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//示例:
//给定的有序链表： [-10, -3, 0, 5, 9],
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
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

    //另见官方题解使用快慢指针进行寻找链表中间节点
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
