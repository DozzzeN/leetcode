package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//297
//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
//请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
//示例:
//你可以将以下二叉树：
//    1
//   / \
//  2   3
//     / \
//    4   5
//序列化为 "[1,2,3,null,null,4,5]"
//提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
//说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
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

        //使用数组index会重复使用
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
