package Offer;

//https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?tpId=13&tqId=11179&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
public class binary_search_tree_and_doubly_linked_list02 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        System.out.println(new binary_search_tree_and_doubly_linked_list02.Solution().Convert(root));
    }

    //我们知道二叉排序树中序遍历的结果是排好序的，然后再想到线索化二叉树的过程，很容易联想到用线索化二叉树的方法去做，
    //用一个全局变量去保存前一个节点，然后再去创建节点之间的关系（这里区别与线索化二叉树的是，线索化二叉树创建节点之间
    //的关系是在节点的左右孩子为空的时候采取创建，这样二叉树还是二叉树。但是这里就不是，只要pre不空，就创建关系，创建
    //后就是链表了，二叉树被破坏了）。
    public static class Solution {
        TreeNode pre = null;
        TreeNode root = null;

        public TreeNode Convert(TreeNode pRootOfTree) {
            if (pRootOfTree == null)
                return null;
            Convert(pRootOfTree.left);
            if (root == null) {
                root = pRootOfTree;
            }
            if (pre != null) {
                pRootOfTree.left = pre;
                pre.right = pRootOfTree;
            }
            pre = pRootOfTree;
            Convert(pRootOfTree.right);
            return root;
        }
    }
}
