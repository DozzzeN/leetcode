package Tree;
//100
//给定两个二叉树，编写一个函数来检验它们是否相同。
//如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
//输入:       1         1
//          / \       / \
//         2   3     2   3
//        [1,2,3],   [1,2,3]
//输出: true

//输入:       1         1
//          / \       / \
//         2   1     1   2
//        [1,2,1],   [1,1,2]
//输出: false
public class same_tree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(1);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);

        System.out.println(new Solution().isSameTree(p, q));
    }

    //首先判断 p 和 q 是不是 None，然后判断它们的值是否相等。
    //若以上判断通过，则递归对子结点做同样操作。
    //时间复杂度 :O(N)，其中 N 是树的结点数，因为每个结点都访问一次
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
                //写成下面的也行
                //if (!isSameTree(p.left, q.left)) return false;
                //validate_binary_search_treeif (!isSameTree(p.right, q.right)) return false;
            }
            return false;
        }
    }
}
