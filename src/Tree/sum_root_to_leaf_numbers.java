package Tree;

//129
//����һ��������������ÿ����㶼���һ�� 0-9 �����֣�ÿ���Ӹ���Ҷ�ӽڵ��·��������һ�����֡�
//���磬�Ӹ���Ҷ�ӽڵ�·�� 1->2->3 �������� 123��
//����Ӹ���Ҷ�ӽڵ����ɵ���������֮�͡�
//˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
//ʾ�� 1:
//����: [1,2,3]
//    1
//   / \
//  2   3
//���: 25
//����:
//�Ӹ���Ҷ�ӽڵ�·�� 1->2 �������� 12.
//�Ӹ���Ҷ�ӽڵ�·�� 1->3 �������� 13.
//��ˣ������ܺ� = 12 + 13 = 25.
//ʾ�� 2:
//����: [4,9,0,5,1]
//    4
//   / \
//  9   0
// / \
//5   1
//���: 1026
//����:
//�Ӹ���Ҷ�ӽڵ�·�� 4->9->5 �������� 495.
//�Ӹ���Ҷ�ӽڵ�·�� 4->9->1 �������� 491.
//�Ӹ���Ҷ�ӽڵ�·�� 4->0 �������� 40.
//��ˣ������ܺ� = 495 + 491 + 40 = 1026.
public class sum_root_to_leaf_numbers {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(new sum_root_to_leaf_numbers.Solution().sumNumbers(root));
    }

    static class Solution {
        public int sumNumbers(TreeNode root) {
            int path = 0;
            return sumNumbers(root, path);
        }

        public int sumNumbers(TreeNode root, int path) {
            if (root == null) return 0;
            path = path * 10 + root.val;
            if (root.left == null && root.right == null) {
                return path;
            }
            return sumNumbers(root.left, path) + sumNumbers(root.right, path);
        }
    }
}
