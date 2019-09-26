package Tree;
//100
//������������������дһ�����������������Ƿ���ͬ��
//����������ڽṹ����ͬ�����ҽڵ������ͬ��ֵ������Ϊ��������ͬ�ġ�
//����:       1         1
//          / \       / \
//         2   3     2   3
//        [1,2,3],   [1,2,3]
//���: true

//����:       1         1
//          / \       / \
//         2   1     1   2
//        [1,2,1],   [1,1,2]
//���: false
public class same_tree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(1);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);

        System.out.println(new Solution().isSameTree(p, q));
    }

    //�����ж� p �� q �ǲ��� None��Ȼ���ж����ǵ�ֵ�Ƿ���ȡ�
    //�������ж�ͨ������ݹ���ӽ����ͬ��������
    //ʱ�临�Ӷ� :O(N)������ N �����Ľ��������Ϊÿ����㶼����һ��
    static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            if (p.val == q.val) {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
                //д�������Ҳ��
                //if (!isSameTree(p.left, q.left)) return false;
                //validate_binary_search_treeif (!isSameTree(p.right, q.right)) return false;
            }
            return false;
        }
    }
}
