package Offer;

//https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb?tpId=13&tqId=11211&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
public class symmetric_binary_tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(new symmetric_binary_tree.Solution().isSymmetrical(root));
    }

    public static class Solution {
        boolean isSymmetrical(TreeNode pRoot) {
            return pRoot == null || helper(pRoot.left, pRoot.right);
        }

        boolean helper(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if (left == null || right == null) return false;
            if (left.val == right.val) {
                return helper(left.right, right.left) && helper(left.left, right.right);
            } else {
                return false;
            }
        }
    }
}
