package Offer;

//https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tqId=11157&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
public class rebuild_the_binary_tree {
    public static void main(String[] args) {
        int[] preorder = new int[]{7, 10, 4, 3, 1, 2, 8, 11};
        int[] inorder = new int[]{4, 10, 3, 1, 7, 11, 8, 2};
        TreeNode node = new rebuild_the_binary_tree.Solution().reConstructBinaryTree(preorder, inorder);
        System.out.println(new binary_tree_level_order_traversal.Solution().levelOrder(node));
    }

    public static class Solution {
        public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
            return buildTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
        }

        public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
            if (preStart > preEnd || inStart > inEnd) return null;
            int root = preorder[preStart];
            TreeNode node = new TreeNode(root);
            int i;
            for (i = 0; i < inorder.length - 1; i++) {
                if (inorder[i] == root) break;
            }
            node.left = buildTree(preorder, inorder, preStart + 1, preStart + i - inStart, inStart, i - 1);
            node.right = buildTree(preorder, inorder, preStart + i - inStart + 1, preEnd, i + 1, inEnd);
            return node;
        }
    }
}
