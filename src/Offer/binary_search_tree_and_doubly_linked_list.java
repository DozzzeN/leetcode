package Offer;

import java.util.ArrayList;

//https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?tpId=13&tqId=11179&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
public class binary_search_tree_and_doubly_linked_list {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        System.out.println(new binary_search_tree_and_doubly_linked_list.Solution().Convert(root));
        TreeNode first = root.left.left;
        while (first != null) {
            System.out.println(first.val);
            first = first.right;
        }
    }

    //����һ���������洢��������Ľڵ㣬Ȼ���ٴ�ͷ��β�������ڵ�ǰ������ӹ�ϵ
    public static class Solution {
        public TreeNode Convert(TreeNode pRootOfTree) {
            if (pRootOfTree == null) return null;
            ArrayList<TreeNode> list = new ArrayList<>();
            travel(pRootOfTree, list);
            return Convert(list);
        }

        public void travel(TreeNode root, ArrayList<TreeNode> list) {
            if (root != null) {
                travel(root.left, list);
                list.add(root);
                travel(root.right, list);
            }
        }

        public TreeNode Convert(ArrayList<TreeNode> list) {
            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i).right = list.get(i + 1);
                list.get(i + 1).left = list.get(i);
            }
            return list.get(0);
        }
    }
}
