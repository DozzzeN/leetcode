package Tree;

//124
//给定一个非空二叉树，返回其最大路径和。
//本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
//示例 1:
//输入: [1,2,3]
//       1
//      / \
//     2   3
//输出: 6
//示例 2:
//输入: [-10,9,20,null,null,15,7]
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//输出: 42
public class binary_tree_maximum_path_sum {
    public static void main(String[] args) {
        //      1
        //     /  \
        //   -2   -3
        //   / \  /
        //  1  3 -2
        // /
        //-1
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(-2);
        root.left.left.left = new TreeNode(-1);
        TreeNode root2 = new TreeNode(-10);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);
        System.out.println(new binary_tree_maximum_path_sum.Solution().maxPathSum(root));
    }

    static class Solution {
        double max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            getMax(root);
            return (int) max;
        }

        public double getMax(TreeNode node) {
            if (node == null) {
                return Integer.MIN_VALUE;
            }
            double left = Math.max(getMax(node.left), 0);
            double right = Math.max(getMax(node.right), 0);
            //保存旧路径，即不依赖当前节点的路径
            max = Math.max(max, node.val + left + right);
//            max = Math.max(max, Math.max(node.val + left + right, left + right));
            //继续递归获得返回值：只选择一条路径（左或右）
            return node.val + Math.max(left, right);
        }
    }
}
