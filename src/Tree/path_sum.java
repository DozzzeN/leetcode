package Tree;

//112
//�������¶��������Լ�Ŀ��� sum = 22��
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
//���� true, ��Ϊ����Ŀ���Ϊ 22 �ĸ��ڵ㵽Ҷ�ӽڵ��·�� 5->4->11->2��
public class path_sum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);
        System.out.println(new path_sum.Solution().hasPathSum(root, 22));
    }

    //BFS
    //��һ������������ǰ������������������ۼӽڵ�ֵ������������Ҷ���ʱ�������ж�
    //������ڸ���ֵ�򷵻أ������������
    static class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            return hasPathSum(root, 0, sum);
        }

        public boolean hasPathSum(TreeNode root, int sum, int target) {
            if (root == null) return false;
            sum += root.val;
            //Ҷ���
            if (root.left == null && root.right == null) {
                return sum == target;
            } else {
                //ֻҪ�н���У�����һ������true�ͷ���true
                return hasPathSum(root.left, sum, target) || hasPathSum(root.right, sum, target);
            }
        }
    }
}
