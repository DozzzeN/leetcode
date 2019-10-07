package Tree;

import java.util.ArrayList;
import java.util.List;

//437
//给定一个二叉树，它的每个结点都存放着一个整数值。
//找出路径和等于给定数值的路径总数。
//路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
//二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
//示例：
//root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//返回 3。和等于 8 的路径有:
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
public class path_sum_iii02 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(3);
        List<List<Integer>> result = new path_sum_iii02.Solution().pathSum(root, 8);
        for (List<Integer> integers : result) {
            System.out.println(integers);
        }
    }

    //找出所有路径
    static class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            //遍历所有节点
            if (root != null) {
                findPath(root, 0, sum);
                pathSum(root.left, sum);
                pathSum(root.right, sum);
            }
            return result;
        }

        //以root为根的子树中，以root为路径的起使节点的路径个数
        public void findPath(TreeNode root, int sum, int target) {
            if (root == null) return;
            sum += root.val;
            solution.add(root.val);
            if (sum == target) {
                result.add(new ArrayList<>(solution));
            }
            findPath(root.left, sum, target);
            findPath(root.right, sum, target);
            solution.remove(solution.size() - 1);
        }
    }
}
