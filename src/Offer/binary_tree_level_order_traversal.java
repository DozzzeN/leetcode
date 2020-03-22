package Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//102
//给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
//例如:
//给定二叉树: [3,9,20,null,null,15,7],
//    3
//   / \
//  9  20
//    /  \
//   15   7
//返回其层次遍历结果：
//[
//  [3],
//  [9,20],
//  [15,7]
//]
public class binary_tree_level_order_traversal {
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
        System.out.println(new binary_tree_level_order_traversal.Solution().levelOrder(root));
    }

    public static class Solution {
        //广度优先搜索（也可以使用递归）
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            List<Integer> temp = new ArrayList<>();
            if (root != null) {
                queue.add(root);
            } else {
                return result;
            }
            //目前层需要遍历的节点数目
            int currentNodeNumber = 1;
            //下一层需要遍历的节点数目
            int nextNodeNumber = 0;
            //已经遍历的节点数目
            int visitedNodeNumber = 0;
            while (queue.size() != 0) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                visitedNodeNumber++;
                if (node.left != null) {
                    queue.add(node.left);
                    nextNodeNumber++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    nextNodeNumber++;
                }
                if (visitedNodeNumber == currentNodeNumber) {
                    visitedNodeNumber = 0;
                    currentNodeNumber = nextNodeNumber;
                    nextNodeNumber = 0;
                    result.add(new ArrayList<>(temp));
                    temp.clear();
                }
            }
            return result;
        }
    }
}
