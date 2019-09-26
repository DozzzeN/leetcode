package Tree;
//98
//����һ�����������ж����Ƿ���һ����Ч�Ķ�����������
//����һ��������������������������
//	�ڵ��������ֻ����С�ڵ�ǰ�ڵ������
//	�ڵ��������ֻ�������ڵ�ǰ�ڵ������
//	�������������������������Ҳ�Ƕ�����������
public class validate_binary_search_tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);

        System.out.println(new Solution().isValidBST(root2));
    }

    //���Ƚ�����ֵ���Ͻ���½磨����У��Ƚϡ�Ȼ�󣬶����������������ݹ���иù���
    static class Solution {
        boolean isValidBST(TreeNode root) {
            return isValidBST(root, null, null);
        }

        boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
            if (root == null) return true;
            if (min != null && root.val <= min.val) return false;
            if (max != null && root.val >= max.val) return false;
            return isValidBST(root.left, min, root)
                    && isValidBST(root.right, root, max);
        }
    }
}
