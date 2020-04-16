package Offer;

//https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd?tpId=13&tqId=11176&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
public class post_order_traversal_sequence_of_binary_search_tree {
    public static void main(String[] args) {
        System.out.println(new post_order_traversal_sequence_of_binary_search_tree.Solution().VerifySquenceOfBST(
                new int[]{5, 7, 6, 9, 11, 10, 8}
        ));
    }

    public static class Solution {
        public boolean VerifySquenceOfBST(int[] sequence) {
            if (sequence == null || sequence.length == 0) return false;
            return verify(sequence, 0, sequence.length - 1);
        }

        //5, 7, 6, 9, 11, 10, 8
        //[5, 7, 6] 8 [9, 11, 10]
        //左子树均小于根，根均小于右子树
        public boolean verify(int[] sequence, int left, int right) {
            if (left >= right) return true;//注意不是等于，存在mid=right的情况
            int root = sequence[right];
            int mid = left;
            while (mid < right && sequence[mid] < root) mid++;
            for (int i = mid; i < right; i++) {//左边无需比较，因为mid在找的时候就保证了左边小于mid
                if (sequence[i] < root) return false;
            }
            return verify(sequence, left, mid - 1) && verify(sequence, mid, right - 1);
        }
    }
}
