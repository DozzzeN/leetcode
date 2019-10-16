package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

//120
//����һ�������Σ��ҳ��Զ����µ���С·���͡�ÿһ��ֻ���ƶ�����һ�������ڵĽ���ϡ�
//���磬���������Σ�
//[
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//�Զ����µ���С·����Ϊ 11������2 + 3 + 5 + 1 = 11����
//˵����
//��������ֻʹ�� O(n) �Ķ���ռ䣨n Ϊ�����ε��������������������⣬��ô����㷨��ܼӷ֡�
public class triangle {
    public static void main(String[] args) {
        int[][] inputArray = new int[][]{
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        };
        List<List<Integer>> input = new ArrayList<>();
        for (int[] ints : inputArray) {
            List<Integer> list = new ArrayList<>();
            for (int anInt : ints) {
                list.add(anInt);
            }
            input.add(list);
        }
        System.out.println(new triangle.Solution().minimumTotal(input));
    }


    //ʹ�ù�������
    //MinV[i][j] = array[i][j] if i == row - 1
    //        or = min(MinV[i+1][j], MinV[i+1][j+1]) + array[i][j] if i != row - 1
    static class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle == null || triangle.size() == 0) return 0;
            int[] minV = new int[triangle.size()];
            for (int i = triangle.size() - 1; i >= 0; i--) {
                int col = triangle.get(i).size();
                for (int j = 0; j < col; j++) {
                    if (i == triangle.size() - 1) {
                        minV[j] = triangle.get(i).get(j);
                    } else {
                        minV[j] = Math.min(minV[j], minV[j + 1]) + triangle.get(i).get(j);
                    }
                }
            }
            return minV[0];
        }
    }
}
