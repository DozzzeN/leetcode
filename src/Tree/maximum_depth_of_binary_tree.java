package Tree;

//104
//给定一个二叉树，找出其最大深度。
//二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//说明: 叶子节点是指没有子节点的节点。
public class maximum_depth_of_binary_tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(1);
        System.out.println(new Solution().maxDepth(root));
    }

    static class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return getDepth(root);

        }

        //如果当前节点为空，那么当前节点的子树深度为0
        //如果有左节点，那么深度是当前深度加1和左节点的子树深度的最大值
        //如果都有，那么深度就是左右节点的子树深度最大值加一

        public int getDepth(TreeNode root) {
            int depth = 1;
            if (root == null) return 0;
            if (root.left != null && root.right == null) {
                depth = Math.max(depth + 1, getDepth(root.left) + 1);
            }
            if (root.right != null && root.left == null) {
                depth = Math.max(depth + 1, getDepth(root.right) + 1);
            }
            if (root.left != null && root.right != null) {
                depth = Math.max(getDepth(root.left) + 1, getDepth(root.right) + 1);
            }
            return depth;
        }

        //代码简化
        public int maxDepthV2(TreeNode root) {
            if (root == null) return 0;
            return Math.max(maxDepthV2(root.left), maxDepthV2(root.right)) + 1;
        }
    }
}
