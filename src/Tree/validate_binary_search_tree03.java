package Tree;

//98
//����һ�����������ж����Ƿ���һ����Ч�Ķ�����������
//����һ��������������������������
//	�ڵ��������ֻ����С�ڵ�ǰ�ڵ������
//	�ڵ��������ֻ�������ڵ�ǰ�ڵ������
//	�������������������������Ҳ�Ƕ�����������
public class validate_binary_search_tree03 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);//true
        root.left = new TreeNode(-1);

        TreeNode root2 = new TreeNode(10);//false
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(15);
        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(20);

        System.out.println(new Solution().isValidBST(root));
    }

    //������������洢�������
    static class Solution {
        private double lastRoot = -Double.MAX_VALUE;
        private boolean isValid = true;
        public boolean isValidBST(TreeNode root) {
            if (root == null || root.left == null && root.right == null) {
                return true;
            }
            traversal(root);
            return isValid;
        }

        public void traversal(TreeNode root) {
            if (root != null) {
                if (root.left != null) {
                    traversal(root.left);
                }
                if (root.val <= lastRoot) {
                    isValid = false;
                } else {
                    lastRoot = root.val;
                }
                if (root.right != null) {
                    traversal(root.right);
                }
            }
        }
    }
}
