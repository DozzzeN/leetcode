package Tree;

import java.util.ArrayList;
import java.util.List;

//113
//����һ����������һ��Ŀ��ͣ��ҵ����дӸ��ڵ㵽Ҷ�ӽڵ�·���ܺ͵��ڸ���Ŀ��͵�·����
//˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
//ʾ��:
//�������¶��������Լ�Ŀ��� sum = 22��
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//����:
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
public class path_sum_ii {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        List<List<Integer>> result = new path_sum_ii.Solution().pathSum(root, 22);
        for (List<Integer> integers : result) {
            System.out.println(integers);
        }
    }

    static class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            pathSum(root, 0, sum);
            return result;
        }

        public void pathSum(TreeNode root, int sum, int target) {
            if (root == null) return;
            sum += root.val;
            solution.add(root.val);
            if (root.left == null && root.right == null) {
                if (sum == target) {
                    result.add(new ArrayList<>(solution));
                }
            } else {
                if (root.left != null) {
                    pathSum(root.left, sum, target);
                }
                if (root.right != null) {
                    pathSum(root.right, sum, target);
                }
            }
            solution.remove(solution.size() - 1);
        }
    }
}
