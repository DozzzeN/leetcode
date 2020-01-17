package Tree;

//106
//����һ��������������������������������
//ע��:
//����Լ�������û���ظ���Ԫ�ء�
//���磬����
//������� inorder = [9,3,15,20,7]
//������� postorder = [9,15,7,20,3]
//�������µĶ�������
//    3
//   / \
//  9  20
//    /  \
//   15   7
public class construct_binary_tree_from_inorder_and_postorder_traversal {
    public static void main(String[] args) {
        int[] inorder = new int[]{4, 10, 3, 1, 7, 11, 8, 2};
        int[] postorder = new int[]{4, 1, 3, 10, 11, 8, 2, 7};
        TreeNode node = new construct_binary_tree_from_inorder_and_postorder_traversal.Solution().buildTree(inorder, postorder);
        System.out.println(new binary_tree_level_order_traversal.Solution().levelOrder(node));
    }

    static class Solution {
        int[] inorder;
        int[] postorder;

        //�����������+����
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            this.inorder = inorder;
            this.postorder = postorder;
            return buildTree(0, inorder.length - 1, 0, postorder.length - 1);
        }

        //ֻ���̶��������������߽����������ô����������������������飬���ٿռ临�Ӷ�
        public TreeNode buildTree(int inStart, int inEnd, int postStart, int postEnd) {
            if (postEnd < postStart || inEnd < inStart) return null;
            int pivot = postorder[postEnd];//���ڵ�
            TreeNode node = new TreeNode(pivot);
            int i;
            for (i = inStart; i < inEnd; i++) {
                if (inorder[i] == pivot) break;
            }
            node.left = buildTree(inStart, i - 1, postStart, postStart + i - inStart - 1);
            node.right = buildTree(i + 1, inEnd, postStart + i - inStart, postEnd - 1);
            return node;
        }
    }
}
