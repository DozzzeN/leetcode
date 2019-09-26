package Tree;
//114
//给定一个二叉树，原地将它展开为链表。
//例如，给定二叉树
//    1
//   / \
//  2   5
// / \   \
//3   4   6
//将其展开为：
//1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6

public class flatten_binary_tree_to_linked_list {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        new flatten_binary_tree_to_linked_list.Solution().flatten(root);
    }

    //将左子树插入到右子树的地方
    //将原来的右子树接到左子树的最右边节点
    //考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
    static class Solution {
        public void flatten(TreeNode root) {
            if (root == null) return;
            else if (root.left == null) {
                if (root.right == null) return;
                flatten(root.right);
            }
            while (root.left != null) {
                if (root.right == null) {
                    root.right = root.left;
                    root.left = null;
                } else {
                    TreeNode temp = root.right;
                    root.right = root.left;
                    //找到左子树最右边的节点
                    TreeNode rightOfLeft = root.right;
                    while (rightOfLeft.right != null) {
                        rightOfLeft = rightOfLeft.right;
                    }
                    //右子数插入到左子树的最右节点的右边
                    rightOfLeft.right = temp;
                    root.left = null;
                }
                //考虑下一个节点
                flatten(root.right);
            }
        }
    }
}
