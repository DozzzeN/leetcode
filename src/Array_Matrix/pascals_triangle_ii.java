package Array_Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//119
//����һ���Ǹ����� k������ k �� 33������������ǵĵ� k �С�
//����������У�ÿ�����������Ϸ������Ϸ������ĺ͡�
//ʾ��:
//����: 3
//���: [1,3,3,1]
//���ף�
//������Ż�����㷨�� O(k) �ռ临�Ӷ���
public class pascals_triangle_ii {
    public static void main(String[] args) {
        System.out.println(new pascals_triangle_ii.Solution().getRow(3));
    }

    //�Ӻ���ǰɨ�裬����Ҫ�洢��ʱ������Ҳ����Ҫ��ά���飨ʹ�ù������飩
    static class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> result = new ArrayList<>();
            int[] resultArray = new int[rowIndex + 2];
            Arrays.fill(resultArray, 0);
            resultArray[1] = 1;
            for (int i = 0; i < rowIndex; i++) {//��
                for (int j = rowIndex + 1; j > 0; j--) {//��
                    resultArray[j] += resultArray[j - 1];
                }
            }
            for (int i = 1; i < resultArray.length; i++) {
                result.add(resultArray[i]);
            }
            return result;
        }
    }
}
