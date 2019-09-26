package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//94
//����һ���������������������� ������
public class binary_tree_inorder_traversal {
    public static void main(String[] args) {
        //    3
        //   / \
        //  9  20
        //    /  \
        //   15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().inorderTraversal(root));
    }

    static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) return result;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode treeNode = root;
            while (!stack.isEmpty() || treeNode != null) {
                while (treeNode != null) {
                    stack.push(treeNode);
                    treeNode = treeNode.left;
                }
                treeNode = stack.pop();
                result.add(treeNode.val);
                //Ҫ�����ҽڵ����ֹ������whileѭ��
                treeNode = treeNode.right;
            }
            return result;
        }
    }
}
