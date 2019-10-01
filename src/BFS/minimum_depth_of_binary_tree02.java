package BFS;

import Tree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//111
//给定一个二叉树，找出其最小深度。
//最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//说明: 叶子节点是指没有子节点的节点。
//示例:
//给定二叉树 [3,9,20,null,null,15,7],
//    3
//   / \
//  9  20
//    /  \
//   15   7
//返回它的最小深度  2.
public class minimum_depth_of_binary_tree02 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().minDepth(root));
    }

    //想法是对于每个节点，按照深度优先搜索的策略访问，同时在访问到叶子节点时更新最小深度。
    //我们从一个包含根节点的栈开始，当前深度为 1 。
    //然后开始迭代：弹出当前栈顶元素，将它的孩子节点压入栈中。当遇到叶子节点时更新最小深度。
    static class Solution {
        public int minDepth(TreeNode root) {
            LinkedList<Map<TreeNode, Integer>> stack = new LinkedList<>();
            if (root == null) {
                return 0;
            } else {
                HashMap temp = new HashMap();
                temp.put(root, 1);
                stack.add(temp);
            }
            int min_depth = Integer.MAX_VALUE;
            while (!stack.isEmpty()) {
                //返回尾元素或null
                Map<TreeNode, Integer> current = stack.pollLast();
                for (TreeNode treeNode : current.keySet()) {
                    //只有一个节点
                    root = treeNode;
                    break;
                }
                int current_depth = current.get(root);
                if ((root.left == null) && (root.right == null)) {
                    min_depth = Math.min(min_depth, current_depth);
                }
                if (root.left != null) {
                    HashMap temp = new HashMap();
                    temp.put(root.left, current_depth + 1);
                    stack.add(temp);
                }
                if (root.right != null) {
                    HashMap temp = new HashMap();
                    temp.put(root.right, current_depth + 1);
                    stack.add(temp);
                }
            }
            return min_depth;
        }
    }
}
