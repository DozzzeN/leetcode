package Tree;

//101
//����һ����������������Ƿ��Ǿ���ԳƵġ�
//���磬������ [1,2,2,3,4,4,3] �ǶԳƵġ�
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//����������� [1,2,2,null,3,null,3] ���Ǿ���ԳƵ�:
//    1
//   / \
//  2   2
//   \   \
//   3    3
//˵��:
//�����������õݹ�͵������ַ������������⣬��ܼӷ֡�
public class symmetric_tree02 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(new symmetric_tree02.Solution().isSymmetric(root));
    }

    //�������������ÿһ��Ľ�����뵽list�У�����Ƿ��ǶԳƵ�
    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return isSymmetric(root.left, root.right);
        }

        public boolean isSymmetric(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            else if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            return isSymmetric(left.right, right.left)
                    && isSymmetric(left.left, right.right);
        }
    }
}
