package Offer;

//Substructure of tree
//输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
public class substructure_of_tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(8);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);
        System.out.println(new substructure_of_tree.Solution().HasSubtree(
                root, root2
        ));
    }

    public static class Solution {
        public boolean HasSubtree(TreeNode root1, TreeNode root2) {
            if (root1 == null || root2 == null) return false;
            return isSubstructure(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }

        public boolean isSubstructure(TreeNode root1, TreeNode root2) {
            if (root2 == null) return true;
            if (root1 == null) return false;
            if (root1.val != root2.val) return false;
            return isSubstructure(root1.left, root2.left) && isSubstructure(root1.right, root2.right);
        }
    }
}
