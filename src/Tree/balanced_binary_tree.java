package Tree;

//110
//给定一个二叉树，判断它是否是高度平衡的二叉树。
//本题中，一棵高度平衡二叉树定义为：
//一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
public class balanced_binary_tree {
    public static void main(String[] args) {
        //    3
        //   / \
        //  9  20
        //    /  \
        //   15   7
        TreeNode root = new TreeNode(3);//true
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        //       1
        //      / \
        //     2   2
        //    /     \
        //   3       3
        //  /       /
        // 4       4
        TreeNode root2 = new TreeNode(1);//false
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.right.right = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        root2.right.right.left = new TreeNode(4);
        System.out.println(new Solution().isBalanced(root2));
    }

    static class Solution {
        boolean isBalanced = true;
        public boolean isBalanced(TreeNode root) {
            getBalance(root);
            return isBalanced;
        }

        public int getBalance(TreeNode root) {
            if (root == null) return 0;
            int leftDepth = getBalance(root.left) + 1;
            int rightDepth = getBalance(root.right) + 1;
            if (Math.abs(leftDepth - rightDepth) > 1) {
                //注意return并不能跳出所有递归，故需要借助类变量
                //return -1;
                isBalanced = false;
            }
            return Math.max(leftDepth, rightDepth);
        }
    }
}
