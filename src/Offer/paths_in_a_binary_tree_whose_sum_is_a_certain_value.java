package Offer;

import java.util.ArrayList;

//https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=13&tqId=11177&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//����һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
//·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����(ע��: �ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ)
public class paths_in_a_binary_tree_whose_sum_is_a_certain_value {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(-2);
        root.right.left.right = new TreeNode(7);
        root.right.right = new TreeNode(5);
        System.out.println(new paths_in_a_binary_tree_whose_sum_is_a_certain_value.Solution().FindPath(
                root, 3
        ));
    }

    public static class Solution {
        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            if (root == null) return result;
            helper(root, target, 0, result, new ArrayList<>());
            //���ռ��ϸ�����������
            result.sort((o1, o2) -> o2.size() - o1.size());
            return result;
        }

        //����
        public void helper(TreeNode root, int target, int current, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> solution) {
            if (root != null) {
                current += root.val;
                solution.add(root.val);
                //·����һֱ��Ҷ�ڵ�ģ�����Ҫ���ϴ��ж�
                if (current == target && root.left == null && root.right == null) {
                    result.add(new ArrayList<>(solution));
                }
                helper(root.left, target, current, result, solution);
                helper(root.right, target, current, result, solution);
                solution.remove(solution.size() - 1);
            }
        }
    }
}