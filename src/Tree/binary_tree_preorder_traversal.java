package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//144
//给定一个二叉树，返回它的 前序 遍历。
public class binary_tree_preorder_traversal {
    public static void main(String[] args) {
        //    3
        //   / \
        //  9  20
        //    /  \
        //   15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().preorderTraversal(null));
    }

    public static class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) return result;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode treeNode = stack.pop();
                result.add(treeNode.val);
                //右子树先入栈
                if (treeNode.right != null) {
                    stack.push(treeNode.right);
                }
                if (treeNode.left != null) {
                    stack.push(treeNode.left);
                }
            }
            return result;
        }
    }
}
