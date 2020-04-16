package Offer;

//https://www.nowcoder.com/practice/cf7e25aa97c04cc1a68c8f040e71fb84?tpId=13&tqId=11214&tPage=4&rp=4&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//��ʵ�������������ֱ��������л��ͷ����л�������
//�����������л���ָ����һ�ö���������ĳ�ֱ�����ʽ�Ľ����ĳ�ָ�ʽ����Ϊ�ַ������Ӷ�ʹ���ڴ��н��������Ķ��������Գ־ñ��档
//���л����Ի����������򡢺��򡢲���Ķ�����������ʽ�������޸ģ����л��Ľ����һ���ַ��������л�ʱͨ��
//ĳ�ַ��ű�ʾ�սڵ㣨#������ �� ��ʾһ�����ֵ�Ľ�����value!����
//�������ķ����л���ָ������ĳ�ֱ���˳��õ������л��ַ������str���ع���������
public class serialized_binary_tree02 {
    public static void main(String[] args) {
        serialized_binary_tree02.Solution solution = new serialized_binary_tree02.Solution();
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

        solution = new serialized_binary_tree02.Solution();
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
        private String deserializeStr;

        public String Serialize(TreeNode root) {
            if (root == null) return "#";
            return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
        }

        public TreeNode Deserialize(String str) {
            deserializeStr = str;
            return Deserialize();
        }

        private TreeNode Deserialize() {
            if (deserializeStr.length() == 0) return null;
            int index = deserializeStr.indexOf(" ");
            String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
            deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
            if (node.equals("#")) return null;
            TreeNode t = new TreeNode(Integer.parseInt(node));
            t.left = Deserialize();
            t.right = Deserialize();
            return t;
        }
    }
}
