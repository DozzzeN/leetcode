package Offer;

import java.util.ArrayList;
import java.util.LinkedList;

//https://www.nowcoder.com/practice/445c44d982d04483b04a54f298796288?tpId=13&tqId=11213&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
public class print_the_binary_tree_into_multiple_lines {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        System.out.println(new print_the_binary_tree_into_multiple_lines.Solution().Print(root));
    }

    public static class Solution {
        ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            if (pRoot != null) {
                queue.add(pRoot);
            } else {
                return result;
            }
            ArrayList<Integer> level = new ArrayList<>();
            int nextNumbers = 0;
            int currentNumbers = 0;
            int expectedNumers = 1;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                level.add(node.val);
                currentNumbers++;
                if (node.left != null) {
                    queue.add(node.left);
                    nextNumbers++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    nextNumbers++;
                }
                if (expectedNumers == currentNumbers) {
                    result.add(new ArrayList<>(level));
                    level.clear();
                    expectedNumers = nextNumbers;
                    currentNumbers = 0;
                    nextNumbers = 0;
                }
            }
            return result;
        }
    }
}
