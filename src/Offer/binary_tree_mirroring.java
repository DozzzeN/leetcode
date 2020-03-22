package Offer;

//https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011?tpId=13&tqId=11171&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//题目描述
//操作给定的二叉树，将其变换为源二叉树的镜像。
//输入描述:
//二叉树的镜像定义：源二叉树
//    	    8
//    	   /  \
//    	  6   10
//    	 / \  / \
//    	5  7 9 11
//    	镜像二叉树
//    	    8
//    	   /  \
//    	  10   6
//    	 / \  / \
//    	11 9 7  5
public class binary_tree_mirroring {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        new binary_tree_mirroring.Solution().Mirror(root);
        System.out.println(new binary_tree_level_order_traversal.Solution().levelOrder(root));
    }

    public static class Solution {
        public void Mirror(TreeNode root) {
            if (root == null) return;
            TreeNode node = root.left;
            root.left = root.right;
            root.right = node;
            Mirror(root.left);
            Mirror(root.right);
        }
    }
}
