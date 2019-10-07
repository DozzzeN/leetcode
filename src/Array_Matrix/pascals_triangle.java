package Array_Matrix;

import java.util.ArrayList;
import java.util.List;

//118
//����һ���Ǹ����� numRows������������ǵ�ǰ numRows �С�
//����������У�ÿ�����������Ϸ������Ϸ������ĺ͡�
//ʾ��:
//����: 5
//���:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]
public class pascals_triangle {
    public static void main(String[] args) {
        List<List<Integer>> result = new pascals_triangle.Solution().generate(11);
        for (List<Integer> integers : result) {
            System.out.println(integers);
        }
    }

    //T[i][j]�ĵ�i�е�j�е�Ԫ��
    //T[i][j] = T[i-1][j-1] + T[i-1][j] if i>0 && j>0
    //     or = 1 if i=0
    //     or = T[i-1][j] if j=0
    static class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {//��
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < i + 1; j++) {//��
                    if (i == 0) {
                        temp.add(1);
                        continue;
                    }
                    //�����ÿһ�б߽��ϵ�1
                    if (j == 0) temp.add(1);
                    else if (j == i) temp.add(1);
                    else temp.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
                result.add(temp);
            }
            return result;
        }
    }
}
