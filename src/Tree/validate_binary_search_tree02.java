package Tree;

import java.util.ArrayList;
import java.util.List;

//98
//����һ�����������ж����Ƿ���һ����Ч�Ķ�����������
//����һ��������������������������
//	�ڵ��������ֻ����С�ڵ�ǰ�ڵ������
//	�ڵ��������ֻ�������ڵ�ǰ�ڵ������
//	�������������������������Ҳ�Ƕ�����������
public class validate_binary_search_tree02 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);//true
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(5);//false
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);

        System.out.println(new Solution().isValidBST(root));
    }

    //����������洢�������
    static class Solution {
        public boolean isValidBST(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            traversal(root, result);
            System.out.println(result);
            for (int i = 0; i < result.size() - 1; i++) {
                if (result.get(i) >= result.get(i + 1)) return false;
            }
            return true;
        }

        public void traversal(TreeNode root, List<Integer> result) {
            if (root != null) {
                if (root.left != null) traversal(root.left, result);
                result.add(root.val);
                if (root.right != null) traversal(root.right, result);
            }
        }
    }
}
