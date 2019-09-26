package Tree;

import java.util.ArrayList;
import java.util.List;

//98
//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//假设一个二叉搜索树具有如下特征：
//	节点的左子树只包含小于当前节点的数。
//	节点的右子树只包含大于当前节点的数。
//	所有左子树和右子树自身必须也是二叉搜索树。
public class validate_binary_search_tree02 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);//true
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(5);//false
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);

        System.out.println(new Solution().isValidBST(root));
    }

    //中序遍历，存储遍历结果
    static class Solution {
        public boolean isValidBST(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            traversal(root, result);
            System.out.println(result);
            for (int i = 0; i < result.size() - 1; i++) {
                if (result.get(i) >= result.get(i + 1)) return false;
            }
            return true;
        }

        public void traversal(TreeNode root, List<Integer> result) {
            if (root != null) {
                if (root.left != null) traversal(root.left, result);
                result.add(root.val);
                if (root.right != null) traversal(root.right, result);
            }
        }
    }
}
