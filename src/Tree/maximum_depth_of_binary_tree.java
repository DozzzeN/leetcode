package Tree;

//104
//����һ�����������ҳ��������ȡ�
//�����������Ϊ���ڵ㵽��ԶҶ�ӽڵ���·���ϵĽڵ�����
//˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
public class maximum_depth_of_binary_tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(1);
        System.out.println(new Solution().maxDepth(root));
    }

    static class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return getDepth(root);

        }

        //�����ǰ�ڵ�Ϊ�գ���ô��ǰ�ڵ���������Ϊ0
        //�������ڵ㣬��ô����ǵ�ǰ��ȼ�1����ڵ��������ȵ����ֵ
        //������У���ô��Ⱦ������ҽڵ������������ֵ��һ

        public int getDepth(TreeNode root) {
            int depth = 1;
            if (root == null) return 0;
            if (root.left != null && root.right == null) {
                depth = Math.max(depth + 1, getDepth(root.left) + 1);
            }
            if (root.right != null && root.left == null) {
                depth = Math.max(depth + 1, getDepth(root.right) + 1);
            }
            if (root.left != null && root.right != null) {
                depth = Math.max(getDepth(root.left) + 1, getDepth(root.right) + 1);
            }
            return depth;
        }

        //�����
        public int maxDepthV2(TreeNode root) {
            if (root == null) return 0;
            return Math.max(maxDepthV2(root.left), maxDepthV2(root.right)) + 1;
        }
    }
}
