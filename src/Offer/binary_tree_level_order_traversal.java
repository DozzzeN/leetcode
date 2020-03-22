package Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//102
//����һ���������������䰴��α����Ľڵ�ֵ�� �������أ������ҷ������нڵ㣩��
//����:
//����������: [3,9,20,null,null,15,7],
//    3
//   / \
//  9  20
//    /  \
//   15   7
//�������α��������
//[
//  [3],
//  [9,20],
//  [15,7]
//]
public class binary_tree_level_order_traversal {
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
        System.out.println(new binary_tree_level_order_traversal.Solution().levelOrder(root));
    }

    public static class Solution {
        //�������������Ҳ����ʹ�õݹ飩
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            List<Integer> temp = new ArrayList<>();
            if (root != null) {
                queue.add(root);
            } else {
                return result;
            }
            //Ŀǰ����Ҫ�����Ľڵ���Ŀ
            int currentNodeNumber = 1;
            //��һ����Ҫ�����Ľڵ���Ŀ
            int nextNodeNumber = 0;
            //�Ѿ������Ľڵ���Ŀ
            int visitedNodeNumber = 0;
            while (queue.size() != 0) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                visitedNodeNumber++;
                if (node.left != null) {
                    queue.add(node.left);
                    nextNodeNumber++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    nextNodeNumber++;
                }
                if (visitedNodeNumber == currentNodeNumber) {
                    visitedNodeNumber = 0;
                    currentNodeNumber = nextNodeNumber;
                    nextNodeNumber = 0;
                    result.add(new ArrayList<>(temp));
                    temp.clear();
                }
            }
            return result;
        }
    }
}
