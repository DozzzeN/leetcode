package Array_Matrix;

//769
public class max_chunks_to_make_sorted02 {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 4};
//        int[] arr = {0,2,1};
        System.out.println(new max_chunks_to_make_sorted02.Solution().maxChunksToSorted(arr));
    }

    //����������i��λ��ʱ����������з�Ϊ�飬��ǰi��λ�õ����ֵһ������i��
    //����һ���б�iС�������ֵ�����Ŀ飬�ǿ������һ������������
    static class Solution {
        public int maxChunksToSorted(int[] arr) {
            if (arr == null) {
                return 0;
            }
            int result = 0;
            int right = arr[0];
            for (int i = 0; i < arr.length; i++) {
                right = Math.max(right, arr[i]);//����������
                if (right == i) {//���������Ԫ����������һ�£�����Էֿ�
                    result++;
                }
            }
            return result;
        }
    }
}
