package Tree;

//108
//��һ�������������е��������飬ת��Ϊһ�ø߶�ƽ�������������
//�����У�һ���߶�ƽ���������ָһ��������ÿ���ڵ� ���������������ĸ߶Ȳ�ľ���ֵ������ 1��
//ʾ��:
//������������: [-10,-3,0,5,9],
//һ�����ܵĴ��ǣ�[0,-3,9,-10,null,5]�������Ա�ʾ��������߶�ƽ�������������
//      0
//     / \
//   -3   9
//   /   /
// -10  5
public class convert_sorted_array_to_binary_search_tree {
    public static void main(String[] args) {
        System.out.println(new binary_tree_level_order_traversal.Solution().levelOrder
                (new convert_sorted_array_to_binary_search_tree.Solution().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9})));
    }

    static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return sortedArrayToBST(nums, 0, nums.length - 1);
        }

        public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
            if (start > end) return null;
            int mid = (start + end) / 2;//���ڵ�
            TreeNode node = new TreeNode(nums[mid]);
            node.left = sortedArrayToBST(nums, start, mid - 1);
            node.right = sortedArrayToBST(nums, mid + 1, end);
            return node;
        }
    }
}
