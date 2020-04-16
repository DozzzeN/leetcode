package Offer;

import java.util.ArrayList;
import java.util.LinkedList;

//https://www.nowcoder.com/practice/7fe2212963db4790b57431d9ed259701?tpId=13&tqId=11175&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//从上往下打印出二叉树的每个节点，同层节点从左至右打印。
public class print_binary_tree_from_top_to_bottom {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        System.out.println(new print_binary_tree_from_top_to_bottom.Solution().PrintFromTopToBottom(root));
    }

    public static class Solution {
        public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            ArrayList<Integer> result = new ArrayList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            if (root != null) {
                queue.add(root);
                result.add(root.val);
            } else return result;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    result.add(node.left.val);
                    queue.add(node.left);
                }
                if (node.right != null) {
                    result.add(node.right.val);
                    queue.add(node.right);
                }
            }
            return result;
        }
    }
}
