package Offer;

//https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222?tpId=13&tqId=11192&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//输入一棵二叉树，判断该二叉树是否是平衡二叉树。
public class balanced_binary_tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
//        root.left.right.left = new TreeNode(2);
//        root.left.right.right = new TreeNode(6);
        System.out.println(new balanced_binary_tree.Solution().IsBalanced_Solution(root));
    }

    public static class Solution {
        public boolean IsBalanced_Solution(TreeNode root) {
            return helper(root);
        }

        public int depth(TreeNode root) {
            if (root == null) return 0;
            else return 1 + Math.max(depth(root.left), depth(root.right));
        }

        public boolean helper(TreeNode root) {
            if (root == null) return true;
            return Math.abs(depth(root.left) - depth(root.right)) <= 1;
        }
    }
}
