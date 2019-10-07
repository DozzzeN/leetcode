package Tree;

//112
//给定如下二叉树，以及目标和 sum = 22，
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
//返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
public class path_sum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);
        System.out.println(new path_sum.Solution().hasPathSum(root, 22));
    }

    //BFS
    //对一个二叉树进行前序遍历，遍历过程中累加节点值，当到达任意叶结点时，进行判断
    //如果等于给定值则返回，否则继续搜索
    static class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            return hasPathSum(root, 0, sum);
        }

        public boolean hasPathSum(TreeNode root, int sum, int target) {
            if (root == null) return false;
            sum += root.val;
            //叶结点
            if (root.left == null && root.right == null) {
                return sum == target;
            } else {
                //只要有解就行，任意一个返回true就返回true
                return hasPathSum(root.left, sum, target) || hasPathSum(root.right, sum, target);
            }
        }
    }
}
