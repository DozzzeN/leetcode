package Tree;

//124
//����һ���ǿն����������������·���͡�
//�����У�·��������Ϊһ������������ڵ�������ﵽ����ڵ�����С���·�����ٰ���һ���ڵ㣬�Ҳ�һ���������ڵ㡣
//ʾ�� 1:
//����: [1,2,3]
//       1
//      / \
//     2   3
//���: 6
//ʾ�� 2:
//����: [-10,9,20,null,null,15,7]
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//���: 42
public class binary_tree_maximum_path_sum {
    public static void main(String[] args) {
        //      1
        //     /  \
        //   -2   -3
        //   / \  /
        //  1  3 -2
        // /
        //-1
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(-2);
        root.left.left.left = new TreeNode(-1);
        TreeNode root2 = new TreeNode(-10);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);
        System.out.println(new binary_tree_maximum_path_sum.Solution().maxPathSum(root));
    }

    static class Solution {
        double max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            getMax(root);
            return (int) max;
        }

        public double getMax(TreeNode node) {
            if (node == null) {
                return Integer.MIN_VALUE;
            }
            double left = Math.max(getMax(node.left), 0);
            double right = Math.max(getMax(node.right), 0);
            //�����·��������������ǰ�ڵ��·��
            max = Math.max(max, node.val + left + right);
//            max = Math.max(max, Math.max(node.val + left + right, left + right));
            //�����ݹ��÷���ֵ��ֻѡ��һ��·��������ң�
            return node.val + Math.max(left, right);
        }
    }
}
