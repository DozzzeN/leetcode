package Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.nowcoder.com/practice/cf7e25aa97c04cc1a68c8f040e71fb84?tpId=13&tqId=11214&tPage=4&rp=4&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//��ʵ�������������ֱ��������л��ͷ����л�������
//�����������л���ָ����һ�ö���������ĳ�ֱ�����ʽ�Ľ����ĳ�ָ�ʽ����Ϊ�ַ������Ӷ�ʹ���ڴ��н��������Ķ��������Գ־ñ��档
//���л����Ի����������򡢺��򡢲���Ķ�����������ʽ�������޸ģ����л��Ľ����һ���ַ��������л�ʱͨ��
//ĳ�ַ��ű�ʾ�սڵ㣨#������ �� ��ʾһ�����ֵ�Ľ�����value!����
//�������ķ����л���ָ������ĳ�ֱ���˳��õ������л��ַ������str���ع���������
public class serialized_binary_tree {
    public static void main(String[] args) {
        serialized_binary_tree.Solution solution = new serialized_binary_tree.Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(5);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(-2);
        root2.right = new TreeNode(-2);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(3);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(4);
        String str = solution.Serialize(root);
        System.out.println(str);
        System.out.println(new binary_tree_level_order_traversal.Solution().levelOrder(solution.Deserialize(str)));

        solution = new serialized_binary_tree.Solution();
        str = solution.Serialize(root2);
        System.out.println(str);
        System.out.println(new binary_tree_level_order_traversal.Solution().levelOrder(solution.Deserialize(str)));
    }

    //�������
    //��������������������µ����
    //          1
    //         / \
    //        2   3
    //       /     \
    //      4       5
    //     /         \
    //    6           7
    //�м�Ŀսڵ������#��ȫ��1!2!3!4!#!#!5!6!#!#!#!#!7!
    public static class Solution {
        String Serialize(TreeNode root) {
            if (root == null) return null;
            String result = serialize(root, new StringBuilder());
            return result.substring(0, result.length() - 1);
        }

        public String serialize(TreeNode root, StringBuilder result) {
            if (root == null) {
                result.append("#!");
                return null;
            } else {
                result.append(root.val).append("!");
                serialize(root.left, result);
                serialize(root.right, result);
            }
            return result.toString();
        }

        TreeNode Deserialize(String str) {
            if (str == null || str.length() == 0) return null;
            String[] array = str.split("!");
            List<String> list = new ArrayList<>(Arrays.asList(array));
            return deserialize(list);
        }

        public TreeNode deserialize(List<String> list) {
            if (list.get(0).equals("#")) {
                list.remove(0);
                return null;
            } else {
                TreeNode node = new TreeNode(Integer.parseInt(list.get(0)));
                list.remove(0);
                node.left = deserialize(list);
                node.right = deserialize(list);
                return node;
            }
        }
    }
}
