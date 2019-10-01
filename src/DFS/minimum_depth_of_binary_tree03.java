package DFS;

import Tree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//111
//����һ�����������ҳ�����С��ȡ�
//��С����ǴӸ��ڵ㵽���Ҷ�ӽڵ�����·���ϵĽڵ�������
//˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
//ʾ��:
//���������� [3,9,20,null,null,15,7],
//    3
//   / \
//  9  20
//    /  \
//   15   7
//����������С���  2.
public class minimum_depth_of_binary_tree03 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().minDepth(root));
    }

    //�����������������ȱ�������нڵ㶼������ʵ����Ա�֤�ܹ��ҵ���С��ȡ���˸��Ӷ��� O(N)��
    //һ���Ż��ķ��������ÿ���������������ǰ������Ĳ��ȥ��������һ�����ʵ���Ҷ�Ӿ�����С��ȵĽڵ㣬�����Ͳ�Ҫ�������еĽڵ��ˡ�
    static class Solution {
        public int minDepth(TreeNode root) {
            LinkedList<Map<TreeNode, Integer>> stack = new LinkedList<>();
            if (root == null) {
                return 0;
            } else {
                HashMap temp = new HashMap();
                temp.put(root, 1);
                stack.add(temp);
            }
            int current_depth = 0;
            while (!stack.isEmpty()) {
                //����ͷԪ�ػ�null
                Map<TreeNode, Integer> current = stack.poll();
                for (TreeNode treeNode : current.keySet()) {
                    //ֻ��һ���ڵ�
                    root = treeNode;
                    break;
                }
                current_depth = current.get(root);
                if ((root.left == null) && (root.right == null)) {
                    break;
                }
                if (root.left != null) {
                    HashMap temp = new HashMap();
                    temp.put(root.left, current_depth + 1);
                    stack.add(temp);
                }
                if (root.right != null) {
                    HashMap temp = new HashMap();
                    temp.put(root.right, current_depth + 1);
                    stack.add(temp);
                }
            }
            return current_depth;
        }
    }
}
