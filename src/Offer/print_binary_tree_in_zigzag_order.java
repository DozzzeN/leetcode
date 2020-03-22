package Offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0?tpId=13&tqId=11212&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
public class print_binary_tree_in_zigzag_order {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(new print_binary_tree_in_zigzag_order.Solution().Print(root));
    }

    public static class Solution {
        public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            if (pRoot == null) return result;
            LinkedList<TreeNode> queue = new LinkedList<>();
            List<Integer> temp = new ArrayList<>();
            queue.add(pRoot);
            //目前层需要遍历的节点数目
            int currentNodeNumber = 1;
            //下一层需要遍历的节点数目
            int nextNodeNumber = 0;
            //已经遍历的节点数目
            int visitedNodeNumber = 0;
            int depth = 1;
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
                    if (depth % 2 == 0) Collections.reverse(temp);
                    result.add(new ArrayList<>(temp));
                    depth++;
                    temp.clear();
                }
            }
            return result;
        }
    }
}
