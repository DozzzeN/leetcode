package Offer;

//https://www.nowcoder.com/practice/cf7e25aa97c04cc1a68c8f040e71fb84?tpId=13&tqId=11214&tPage=4&rp=4&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//请实现两个函数，分别用来序列化和反序列化二叉树
//二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
//序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过
//某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
//二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
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

    //先序遍历
    //层序遍历做不出来：如下的情况
    //          1
    //         / \
    //        2   3
    //       /     \
    //      4       5
    //     /         \
    //    6           7
    //中间的空节点如何用#补全：1!2!3!4!#!#!5!6!#!#!#!#!7!
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
