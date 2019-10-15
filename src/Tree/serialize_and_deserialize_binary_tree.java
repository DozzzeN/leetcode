package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//297
//���л��ǽ�һ�����ݽṹ���߶���ת��Ϊ�����ı���λ�Ĳ������������Խ�ת��������ݴ洢��һ���ļ������ڴ��У�ͬʱҲ����ͨ�����紫�䵽��һ���������������ȡ�෴��ʽ�ع��õ�ԭ���ݡ�
//�����һ���㷨��ʵ�ֶ����������л��뷴���л������ﲻ�޶�������� / �����л��㷨ִ���߼�����ֻ��Ҫ��֤һ�����������Ա����л�Ϊһ���ַ������ҽ�����ַ��������л�Ϊԭʼ�����ṹ��
//ʾ��:
//����Խ����¶�������
//    1
//   / \
//  2   3
//     / \
//    4   5
//���л�Ϊ "[1,2,3,null,null,4,5]"
//��ʾ: ���� LeetCode Ŀǰʹ�õķ�ʽһ�£���������� LeetCode ���л��������ĸ�ʽ���㲢�Ǳ����ȡ���ַ�ʽ����Ҳ���Բ��������ķ������������⡣
//˵��: ��Ҫʹ����ĳ�Ա / ȫ�� / ��̬�������洢״̬��������л��ͷ����л��㷨Ӧ������״̬�ġ�
public class serialize_and_deserialize_binary_tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String result = new serialize_and_deserialize_binary_tree.Codec().serialize(root);
        System.out.println(result);
        TreeNode node = new serialize_and_deserialize_binary_tree.Codec().deserialize("");
        String result1 = new serialize_and_deserialize_binary_tree.Codec().serialize(node);
        System.out.println(result1);
    }

    static public class Codec {
        public String serialize(TreeNode root) {
            if (root == null) return null;
            String result = serialize(root, new StringBuilder());
            return result.substring(0, result.length() - 1);
        }

        public String serialize(TreeNode root, StringBuilder result) {
            if (root == null) {
                result.append("null,");
                return null;
            } else {
                result.append(root.val).append(",");
                serialize(root.left, result);
                serialize(root.right, result);
            }
            return result.toString();
        }

        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) return null;
            String[] array = data.split(",");
            List<String> list = new ArrayList<>(Arrays.asList(array));
            return deserialize(list);
        }

        public TreeNode deserialize(List list) {
            if (list.get(0).equals("null")) {
                list.remove(0);
                return null;
            } else {
                TreeNode node = new TreeNode(Integer.parseInt((String) list.get(0)));
                list.remove(0);
                node.left = deserialize(list);
                node.right = deserialize(list);
                return node;
            }
        }

        //ʹ������index���ظ�ʹ��
        public TreeNode deserialize(String[] data, int index) {
            System.out.println(index);
            if (index > data.length || data[index].equals("null")) {
                return null;
            } else {
                TreeNode node = new TreeNode(Integer.parseInt(data[index]));
                index++;
                node.left = deserialize(data, index);
                index++;
                node.right = deserialize(data, index);
                return node;
            }
        }
    }
}
