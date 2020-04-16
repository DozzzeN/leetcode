package Offer;

//https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd?tpId=13&tqId=11176&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ��������������Yes,�������No���������������������������ֶ�������ͬ��
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
        //��������С�ڸ�������С��������
        public boolean verify(int[] sequence, int left, int right) {
            if (left >= right) return true;//ע�ⲻ�ǵ��ڣ�����mid=right�����
            int root = sequence[right];
            int mid = left;
            while (mid < right && sequence[mid] < root) mid++;
            for (int i = mid; i < right; i++) {//�������Ƚϣ���Ϊmid���ҵ�ʱ��ͱ�֤�����С��mid
                if (sequence[i] < root) return false;
            }
            return verify(sequence, left, mid - 1) && verify(sequence, mid, right - 1);
        }
    }
}
