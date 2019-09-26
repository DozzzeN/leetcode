package Tree;

//889
//返回与给定的前序和后序遍历匹配的任何二叉树。
// pre 和 post 遍历中的值是不同的正整数。
//示例：
//输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
//输出：[1,2,3,4,5,6,7]
//提示：
//	1 <= pre.length == post.length <= 30
//	pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列
//	每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。
public class construct_binary_tree_from_preorder_and_postorder_traversal {
    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] post = new int[]{4, 5, 2, 6, 7, 3, 1};
        TreeNode node = new construct_binary_tree_from_preorder_and_postorder_traversal.Solution().constructFromPrePost(pre, post);
        System.out.println(new binary_tree_level_order_traversal.Solution().levelOrder(node));
    }

    static class Solution {
        //深度优先搜索+分治
        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            return constructFromPrePost(pre, post, 0, pre.length - 1, 0, post.length - 1);
        }

        //只传固定的数组和始末指针，不用传各个左子树和右子树数组，减少空间复杂度
        public TreeNode constructFromPrePost(int[] pre, int[] post, int preStart, int preEnd, int postStart, int postEnd) {
            if (preEnd < preStart || postEnd < postStart || preStart > pre.length - 1) return null;
            int pivot = pre[preStart];//根节点
            TreeNode node = new TreeNode(pivot);
            int i;
            for (i = postStart; i < postEnd - 1; i++) {
                if (post[i] == pre[preStart + 1]) break;
            }
            if (preStart == preEnd) return node;
            node.left = constructFromPrePost(pre, post, preStart + 1, preStart + i - postStart + 1, postStart, i);
            node.right = constructFromPrePost(pre, post, preStart + i - postStart + 2, preEnd, i + 1, postEnd - 1);
            return node;
        }
    }
}
