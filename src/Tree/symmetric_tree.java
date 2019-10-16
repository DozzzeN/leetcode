package Tree;

import java.util.ArrayList;
import java.util.List;

//101
//����һ����������������Ƿ��Ǿ���ԳƵġ�
//���磬������ [1,2,2,3,4,4,3] �ǶԳƵġ�
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//����������� [1,2,2,null,3,null,3] ���Ǿ���ԳƵ�:
//    1
//   / \
//  2   2
//   \   \
//   3    3
//˵��:
//�����������õݹ�͵������ַ������������⣬��ܼӷ֡�
public class symmetric_tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(new symmetric_tree.Solution().isSymmetric(root));
    }

    //�������������ÿһ��Ľ�����뵽list�У�����Ƿ��ǶԳƵ�
    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            int countOnLevel = 1;
            while (countOnLevel > 0) {
                for (int i = 0; i < countOnLevel; i++) {
                    TreeNode p = list.get(i);
                    if (p != null) {
                        list.add(p.left);
                        list.add(p.right);
                    }
                }
                int start = 0, end = countOnLevel - 1;
                while (start < end) {
                    int l = list.get(start) == null ? Integer.MIN_VALUE : list.get(start).val;
                    int r = list.get(end) == null ? Integer.MIN_VALUE : list.get(end).val;
                    if (l != r) return false;
                    start++;
                    end--;
                }
                for (int i = 0; i < countOnLevel; i++) {
                    list.remove(0);
                }
                countOnLevel = list.size();
            }
            return true;
        }
    }
}
