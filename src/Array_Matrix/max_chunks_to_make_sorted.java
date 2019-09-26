package Array_Matrix;

import java.util.Arrays;
//769
//����arr��[0, 1, ..., arr.length - 1]��һ�����У����ǽ��������ָ�ɼ������顱��������Щ��ֱ��������
//֮��������������ʹ�����ӵĽ���Ͱ�����������ԭ������ͬ��
//����: arr = [1,0,2,3,4]
//���: 4
//����:
//���ǿ��԰����ֳ����飬���� [1, 0], [2, 3, 4]��
//Ȼ�����ֳ� [1, 0], [2], [3], [4] ���Եõ����Ŀ�����
public class max_chunks_to_make_sorted {
    public static void main(String[] args) {
//        int[] arr = {1,0,2,3,4};
        int[] arr = {0,2,1};
        System.out.println(new max_chunks_to_make_sorted.Solution().maxChunksToSorted(arr));
    }

    static class Solution {
        //ԭ�������������������Ƚ�
        public int maxChunksToSorted(int[] arr) {
            int[] copy = Arrays.copyOf(arr, arr.length);
            Arrays.sort(arr);//׼�������������
            int result = 0;
            boolean flag = false;//�Ƿ���Էֿ�
            for (int i = 0; i < arr.length; i++) {
                int[] temp = Arrays.copyOf(copy, copy.length);
                Arrays.sort(temp, 0, i + 1);//ֻ��0��i����
                for (int j = 0; j <= i; j++) {//������i�������Ƿ������������һ�£���һ������Խ��зֿ�
                    if (arr[j] != temp[j]) {
                        flag = false;
                        break;
                    }
                    flag = true;
                }
                if (flag) {
                    result++;
                }
            }
            return result;
        }
    }
}
