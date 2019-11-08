package Tree;

//235
//����һ������������, �ҵ�����������ָ���ڵ������������ȡ�
//�ٶȰٿ�������������ȵĶ���Ϊ���������и��� T ��������� p��q������������ȱ�ʾΪһ����� x������ x �� p��q �������� x ����Ⱦ����ܴ�һ���ڵ�Ҳ���������Լ������ȣ�����
//���磬�������¶���������:  root = [6,2,8,0,4,7,9,null,null,3,5]
//ʾ�� 1:
//����: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//���: 6
//����: �ڵ� 2 �ͽڵ� 8 ��������������� 6��
//ʾ�� 2:
//����: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//���: 2
//����: �ڵ� 2 �ͽڵ� 4 ��������������� 2, ��Ϊ���ݶ�������������Ƚڵ����Ϊ�ڵ㱾��
//˵��:
//	���нڵ��ֵ����Ψһ�ġ�
//	p��q Ϊ��ͬ�ڵ��Ҿ������ڸ����Ķ����������С�
public class lowest_common_ancestor_of_a_binary_search_tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        System.out.println(new Solution().lowestCommonAncestor(root, root.left.left, root.right.right).val);
    }

    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root.val > p.val && root.val > q.val) {
                return lowestCommonAncestor(root.left, p, q);
            } else if (root.val < p.val && root.val < q.val) {
                return lowestCommonAncestor(root.right, p, q);
            } else return root;
        }
    }
}
