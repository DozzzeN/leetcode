package Offer;

//leetcode 235
//����һ������������,�ҵ�����������ָ���ڵ������������ȡ�
//�ٶȰٿ�������������ȵĶ���Ϊ���������и���T���������p��q������������ȱ�ʾΪһ�����x��
//����x��p��q��������x����Ⱦ����ܴ�һ���ڵ�Ҳ���������Լ������ȣ�����
//���磬�������¶���������:root=[6,2,8,0,4,7,9,null,null,3,5]
//ʾ��1:
//����:root=[6,2,8,0,4,7,9,null,null,3,5],p=2,q=8
//���:6
//����:�ڵ�2�ͽڵ�8���������������6��
//ʾ��2:
//����:root=[6,2,8,0,4,7,9,null,null,3,5],p=2,q=4
//���:2
//����:�ڵ�2�ͽڵ�4���������������2,��Ϊ���ݶ�������������Ƚڵ����Ϊ�ڵ㱾��
//˵��:
//	���нڵ��ֵ����Ψһ�ġ�
//	p��qΪ��ͬ�ڵ��Ҿ������ڸ����Ķ����������С�
public class the_lowest_common_ancestor_of_two_nodes_in_the_tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        System.out.println(new the_lowest_common_ancestor_of_two_nodes_in_the_tree().lowestCommonAncestor(
                root, root.left, root.left.right
        ).val);
    }

    //�ڶ���������У������ڵ�p,q�Ĺ�������root����root.val>=p.val&&root.val<=q.val��
    //  2  1<2 2<3 2��1��3�Ĺ�������
    // / \
    //1   3
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
