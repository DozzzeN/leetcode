package Tree;

//101
//给定一个二叉树，检查它是否是镜像对称的。
//例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//    1
//   / \
//  2   2
//   \   \
//   3    3
//说明:
//如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
public class symmetric_tree02 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(new symmetric_tree02.Solution().isSymmetric(root));
    }

    //按层序遍历，将每一层的结果放入到list中，检查是否是对称的
    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return isSymmetric(root.left, root.right);
        }

        public boolean isSymmetric(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            else if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            return isSymmetric(left.right, right.left)
                    && isSymmetric(left.left, right.right);
        }
    }
}
