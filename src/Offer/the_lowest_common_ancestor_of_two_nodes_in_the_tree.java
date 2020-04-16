package Offer;

//leetcode 235
//给定一个二叉搜索树,找到该树中两个指定节点的最近公共祖先。
//百度百科中最近公共祖先的定义为：“对于有根树T的两个结点p、q，最近公共祖先表示为一个结点x，
//满足x是p、q的祖先且x的深度尽可能大（一个节点也可以是它自己的祖先）。”
//例如，给定如下二叉搜索树:root=[6,2,8,0,4,7,9,null,null,3,5]
//示例1:
//输入:root=[6,2,8,0,4,7,9,null,null,3,5],p=2,q=8
//输出:6
//解释:节点2和节点8的最近公共祖先是6。
//示例2:
//输入:root=[6,2,8,0,4,7,9,null,null,3,5],p=2,q=4
//输出:2
//解释:节点2和节点4的最近公共祖先是2,因为根据定义最近公共祖先节点可以为节点本身。
//说明:
//	所有节点的值都是唯一的。
//	p、q为不同节点且均存在于给定的二叉搜索树中。
public class the_lowest_common_ancestor_of_two_nodes_in_the_tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        System.out.println(new the_lowest_common_ancestor_of_two_nodes_in_the_tree().lowestCommonAncestor(
                root, root.left, root.left.right
        ).val);
    }

    //在二叉查找树中，两个节点p,q的公共祖先root满足root.val>=p.val&&root.val<=q.val。
    //  2  1<2 2<3 2是1和3的公共祖先
    // / \
    //1   3
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
