package Offer;

//https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?tpId=13&tqId=11179&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
public class binary_search_tree_and_doubly_linked_list02 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        System.out.println(new binary_search_tree_and_doubly_linked_list02.Solution().Convert(root));
    }

    //����֪��������������������Ľ�����ź���ģ�Ȼ�����뵽�������������Ĺ��̣����������뵽���������������ķ���ȥ����
    //��һ��ȫ�ֱ���ȥ����ǰһ���ڵ㣬Ȼ����ȥ�����ڵ�֮��Ĺ�ϵ���������������������������ǣ������������������ڵ�֮��
    //�Ĺ�ϵ���ڽڵ�����Һ���Ϊ�յ�ʱ���ȡ�������������������Ƕ���������������Ͳ��ǣ�ֻҪpre���գ��ʹ�����ϵ������
    //����������ˣ����������ƻ��ˣ���
    public static class Solution {
        TreeNode pre = null;
        TreeNode root = null;

        public TreeNode Convert(TreeNode pRootOfTree) {
            if (pRootOfTree == null)
                return null;
            Convert(pRootOfTree.left);
            if (root == null) {
                root = pRootOfTree;
            }
            if (pre != null) {
                pRootOfTree.left = pre;
                pre.right = pRootOfTree;
            }
            pre = pRootOfTree;
            Convert(pRootOfTree.right);
            return root;
        }
    }
}
