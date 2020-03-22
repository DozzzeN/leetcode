package Offer;

//https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&tqId=11210&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
public class the_next_node_of_the_binary_tree {
    public static void main(String[] args) {
        //        1
        //      2  3
        //   4  5  6  7
        //         8 9
        // 4-2-5-1-8-6-9-3-7
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.next = root;
        root.right.next = root;

        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.left.left.next = root.left;
        root.left.right.next = root.left;

        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);
        root.right.left.next = root.right;
        root.right.right.next = root.right;

        root.right.left.left = new TreeLinkNode(8);
        root.right.left.right = new TreeLinkNode(9);
        root.right.left.left.next = root.right.left;
        root.right.left.right.next = root.right.left;
        System.out.println(new Solution().GetNext(root.right.left.right).val);//9->3
    }

    //�ýڵ�������������һ��������������е�������
    //�ýڵ������������ҽ���Ǹý�㸸����������������һ����Ǹý��ĸ����
    //�ýڵ������������ҽ���Ǹý�㸸������������������һֱ���Ÿ����׷�ݣ�
    //ֱ���ҵ�ĳ��������丸������������������������Ľ�㣬��ô������ĸ�����������Ҫ�ҵ���һ��㡣
    public static class Solution {
        public TreeLinkNode GetNext(TreeLinkNode pNode) {
            if (pNode.right != null) {
                TreeLinkNode node = pNode.right;
                while (node.left != null) {
                    node = node.left;
                }
                return node;
            }
            if (pNode.next != null && pNode == pNode.next.left) {
                return pNode.next;
            }
            if (pNode.next != null && pNode == pNode.next.right) {
                TreeLinkNode node = pNode;
                while (node.next != null && node.next.right == node) {
                    node = node.next;
                }
                return node.next;
            }
            return null;
        }
    }
}
