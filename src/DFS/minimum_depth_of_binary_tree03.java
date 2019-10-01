package DFS;

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
public class minimum_depth_of_binary_tree03 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().minDepth(root));
    }

    //深度优先搜索方法的缺陷是所有节点都必须访问到，以保证能够找到最小深度。因此复杂度是 O(N)。
    //一个优化的方法是利用宽度优先搜索，我们按照树的层次去迭代，第一个访问到的叶子就是最小深度的节点，这样就不要遍历所有的节点了。
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
            int current_depth = 0;
            while (!stack.isEmpty()) {
                //返回头元素或null
                Map<TreeNode, Integer> current = stack.poll();
                for (TreeNode treeNode : current.keySet()) {
                    //只有一个节点
                    root = treeNode;
                    break;
                }
                current_depth = current.get(root);
                if ((root.left == null) && (root.right == null)) {
                    break;
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
            return current_depth;
        }
    }
}
