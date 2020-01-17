package DFS;

import Tree.TreeNode;
import Tree.binary_tree_level_order_traversal;

//105
//����һ������ǰ�������������������������
//ע��:
//����Լ�������û���ظ���Ԫ�ء�
//���磬����
//ǰ����� preorder = [3,9,20,15,7]
//������� inorder = [9,3,15,20,7]
//�������µĶ�������
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
public class construct_binary_tree_from_preorder_and_inorder_traversal {
    public static void main(String[] args) {
        int[] preorder = new int[]{7, 10, 4, 3, 1, 2, 8, 11};
        int[] inorder = new int[]{4, 10, 3, 1, 7, 11, 8, 2};
        TreeNode node = new construct_binary_tree_from_preorder_and_inorder_traversal.Solution().buildTree(preorder, inorder);
        System.out.println(new binary_tree_level_order_traversal.Solution().levelOrder(node));
    }

    static class Solution {
        //�����������+����
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        }

        //ֻ���̶��������������߽����������ô����������������������飬���ٿռ临�Ӷ�
        //preorder = 7, 10, 4, 3, 1, 2, 8, 11
        //          ps                     pe
        //inorder = 4, 10, 3, 1, 7, 11, 8, 2
        //          is           i         ie
        //pivot = 7 ���ڵ�
        //preorder = 7, 10, 4, 3, 1, 2, 8, 11
        //              ps        pe
        //inorder = 4, 10, 3, 1, 7, 11, 8, 2
        //          is        ie
        //pivot = 10 ���ڵ�
        public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
            if (preEnd < preStart || inEnd < inStart) return null;
            int pivot = preorder[preStart];//���ڵ�
            TreeNode node = new TreeNode(pivot);
            int i;
            for (i = inStart; i < inEnd; i++) {
                if (inorder[i] == pivot) break;
            }
            node.left = buildTree(preorder, inorder, preStart + 1, i - inStart + preStart, inStart, i - 1);
            node.right = buildTree(preorder, inorder, i - inStart + preStart + 1, preEnd, i + 1, inEnd);
            return node;
        }
    }
}
