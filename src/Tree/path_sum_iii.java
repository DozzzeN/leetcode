package Tree;

//437
//����һ��������������ÿ����㶼�����һ������ֵ��
//�ҳ�·���͵��ڸ�����ֵ��·��������
//·������Ҫ�Ӹ��ڵ㿪ʼ��Ҳ����Ҫ��Ҷ�ӽڵ����������·��������������µģ�ֻ�ܴӸ��ڵ㵽�ӽڵ㣩��
//������������1000���ڵ㣬�ҽڵ���ֵ��Χ�� [-1000000,1000000] ��������
//ʾ����
//root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//���� 3���͵��� 8 ��·����:
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
public class path_sum_iii {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(3);
        System.out.println(new path_sum_iii.Solution().pathSum(treeNode, 3));
    }

    static class Solution {
        int count = 0;

        public int pathSum(TreeNode root, int sum) {
            //�������нڵ�
            if (root != null) {
                findPath(root, 0, sum);
                pathSum(root.left, sum);
                pathSum(root.right, sum);
            }
            return count;
        }

        //��rootΪ���������У���rootΪ·������ʹ�ڵ��·������
        public void findPath(TreeNode root, int sum, int target) {
            if (root == null) return;
            sum += root.val;
            if (sum == target) {
                count++;
            }
            findPath(root.left, sum, target);
            findPath(root.right, sum, target);
        }
    }
}
