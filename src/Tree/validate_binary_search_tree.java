package Tree;
//98
//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//假设一个二叉搜索树具有如下特征：
//	节点的左子树只包含小于当前节点的数。
//	节点的右子树只包含大于当前节点的数。
//	所有左子树和右子树自身必须也是二叉搜索树。
public class validate_binary_search_tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);

        System.out.println(new Solution().isValidBST(root2));
    }

    //首先将结点的值与上界和下界（如果有）比较。然后，对左子树和右子树递归进行该过程
    static class Solution {
        boolean isValidBST(TreeNode root) {
            return isValidBST(root, null, null);
        }

        boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
            if (root == null) return true;
            if (min != null && root.val <= min.val) return false;
            if (max != null && root.val >= max.val) return false;
            return isValidBST(root.left, min, root)
                    && isValidBST(root.right, root, max);
        }
    }
}
