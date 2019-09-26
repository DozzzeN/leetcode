package Tree;

//889
//�����������ǰ��ͺ������ƥ����κζ�������
// pre �� post �����е�ֵ�ǲ�ͬ����������
//ʾ����
//���룺pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
//�����[1,2,3,4,5,6,7]
//��ʾ��
//	1 <= pre.length == post.length <= 30
//	pre[] �� post[] ���� 1, 2, ..., pre.length ������
//	ÿ�����뱣֤������һ���𰸡�����ж���𰸣����Է�������һ����
public class construct_binary_tree_from_preorder_and_postorder_traversal {
    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] post = new int[]{4, 5, 2, 6, 7, 3, 1};
        TreeNode node = new construct_binary_tree_from_preorder_and_postorder_traversal.Solution().constructFromPrePost(pre, post);
        System.out.println(new binary_tree_level_order_traversal.Solution().levelOrder(node));
    }

    static class Solution {
        //�����������+����
        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            return constructFromPrePost(pre, post, 0, pre.length - 1, 0, post.length - 1);
        }

        //ֻ���̶��������ʼĩָ�룬���ô����������������������飬���ٿռ临�Ӷ�
        public TreeNode constructFromPrePost(int[] pre, int[] post, int preStart, int preEnd, int postStart, int postEnd) {
            if (preEnd < preStart || postEnd < postStart || preStart > pre.length - 1) return null;
            int pivot = pre[preStart];//���ڵ�
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
