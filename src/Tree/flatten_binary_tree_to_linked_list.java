package Tree;
//114
//����һ����������ԭ�ؽ���չ��Ϊ����
//���磬����������
//    1
//   / \
//  2   5
// / \   \
//3   4   6
//����չ��Ϊ��
//1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6

public class flatten_binary_tree_to_linked_list {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        new flatten_binary_tree_to_linked_list.Solution().flatten(root);
    }

    //�����������뵽�������ĵط�
    //��ԭ�����������ӵ������������ұ߽ڵ�
    //�����µ��������ĸ��ڵ㣬һֱ�ظ��ϱߵĹ��̣�ֱ���µ�������Ϊ null
    static class Solution {
        public void flatten(TreeNode root) {
            if (root == null) return;
            else if (root.left == null) {
                if (root.right == null) return;
                flatten(root.right);
            }
            while (root.left != null) {
                if (root.right == null) {
                    root.right = root.left;
                    root.left = null;
                } else {
                    TreeNode temp = root.right;
                    root.right = root.left;
                    //�ҵ����������ұߵĽڵ�
                    TreeNode rightOfLeft = root.right;
                    while (rightOfLeft.right != null) {
                        rightOfLeft = rightOfLeft.right;
                    }
                    //���������뵽�����������ҽڵ���ұ�
                    rightOfLeft.right = temp;
                    root.left = null;
                }
                //������һ���ڵ�
                flatten(root.right);
            }
        }
    }
}
