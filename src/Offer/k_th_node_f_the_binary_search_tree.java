package Offer;

//https://www.nowcoder.com/practice/ef068f602dde4d28aab2b210e859150a?tpId=13&tqId=11215&tPage=4&rp=4&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//给定一棵二叉搜索树，请找出其中的第k小的结点。例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
public class k_th_node_f_the_binary_search_tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        System.out.println(new Solution().KthNode(root, 4).val);
    }

    public static class Solution {
        private int current = 0;
        private TreeNode node;

        TreeNode KthNode(TreeNode pRoot, int k) {
            travel(pRoot, k);
            return node;
        }

        void travel(TreeNode root, int k) {
            if (root != null) {
                travel(root.left, k);
                current++;
                if (current == k)
                    node = root;
                travel(root.right, k);
            }
        }
    }
}
