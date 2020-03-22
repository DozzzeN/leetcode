package Offer;

//https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb?tpId=13&tqId=11211&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
public class symmetric_binary_tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(new symmetric_binary_tree.Solution().isSymmetrical(root));
    }

    public static class Solution {
        boolean isSymmetrical(TreeNode pRoot) {
            return pRoot == null || helper(pRoot.left, pRoot.right);
        }

        boolean helper(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if (left == null || right == null) return false;
            if (left.val == right.val) {
                return helper(left.right, right.left) && helper(left.left, right.right);
            } else {
                return false;
            }
        }
    }
}
