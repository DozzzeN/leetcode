package Offer;

//leetcode 236
//����һ������������,�ҵ�����������ָ���ڵ������������ȡ�
//�ٶȰٿ�������������ȵĶ���Ϊ���������и���T���������p��q������������ȱ�ʾΪһ�����x��
//����x��p��q��������x����Ⱦ����ܴ�һ���ڵ�Ҳ���������Լ������ȣ�����
//���磬�������¶���������:root=[3,5,1,6,2,0,8,null,null,7,4]
//ʾ��1:
//����:root=[3,5,1,6,2,0,8,null,null,7,4],p=5,q=1
//���:3
//����:�ڵ�5�ͽڵ�1��������������ǽڵ�3��
//ʾ��2:
//����:root=[3,5,1,6,2,0,8,null,null,7,4],p=5,q=4
//���:5
//����:�ڵ�5�ͽڵ�4��������������ǽڵ�5����Ϊ���ݶ�������������Ƚڵ����Ϊ�ڵ㱾��
//˵��:
//  ���нڵ��ֵ����Ψһ�ġ�
//  p��qΪ��ͬ�ڵ��Ҿ������ڸ����Ķ������С�
public class the_lowest_common_ancestor_of_two_nodes_in_the_tree_ii {
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
        System.out.println(new the_lowest_common_ancestor_of_two_nodes_in_the_tree_ii().lowestCommonAncestor(
                root, root.left, root.left.right
        ).val);
    }

    //�����������в����Ƿ����p����q�����p��q�ֱ������������У���ô��˵�����ڵ������͹������ȡ�
    //  2
    // / \
    //4   5
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}
