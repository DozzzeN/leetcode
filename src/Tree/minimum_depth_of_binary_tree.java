package Tree;

//111
//����һ�����������ҳ�����С��ȡ�
//��С����ǴӸ��ڵ㵽���Ҷ�ӽڵ�����·���ϵĽڵ�������
//˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
//ʾ��:
//���������� [3,9,20,null,null,15,7],
//    3
//   / \
//  9  20
//    /  \
//   15   7
//����������С���  2.
public class minimum_depth_of_binary_tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().minDepth(root));
    }

    static class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            int lmin = minDepth(root.left);
            int rmin = minDepth(root.right);
            if (lmin == 0 && rmin == 0) return 1;
            return Math.min(lmin == 0 ? Integer.MAX_VALUE : lmin,
                    rmin == 0 ? Integer.MAX_VALUE : rmin) + 1;
        }
    }
}
