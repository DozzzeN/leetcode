package Math;

import java.math.BigDecimal;
import java.util.HashMap;

//149
//����һ����άƽ�棬ƽ������ n ���㣬������ж��ٸ�����ͬһ��ֱ���ϡ�
//ʾ�� 1:
//����: [[1,1],[2,2],[3,3]]
//���: 3
//����:
//^
//|
//|        o
//|     o
//|  o
//+------------->
//0  1  2  3  4
//ʾ�� 2:
//����: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//���: 4
//����:
//^
//|
//|  o
//|     o        o
//|        o
//|  o        o
//+------------------->
//0  1  2  3  4  5  6
public class max_points_on_a_line {
    public static void main(String[] args) {
        System.out.println(new max_points_on_a_line.Solution().maxPoints(new int[][]{
                {1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}, {1, 4}
//                {94911152, 94911151}, {94911151, 94911150}, {0, 0}
        }));
    }

    //ʹ�ù�ϣ��洢б��
    static class Solution {
        public int maxPoints(int[][] points) {
            HashMap<Double, Integer> gradient = new HashMap<>();
            int maxNum = points.length == 1 ? 1 : 0;
            for (int i = 0; i < points.length; i++) {
                gradient.clear();
                int duplicate = 1;
                for (int j = 0; j < points.length; j++) {
                    //ͬһ���ڵ����
                    if (j == i) continue;
                    //��ͬ�ڵ�
                    if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                        duplicate++;
                    } else {
                        //ע������������б�ʵĵ�����Ϊ�˽���������⣩
                        double key = points[j][1] == points[i][1] ? Integer.MAX_VALUE :
                                div(points[j][0] - points[i][0], points[j][1] - points[i][1]);
                        gradient.put(key, gradient.getOrDefault(key, 0) + 1);
                    }
                    if (gradient.isEmpty()) maxNum = duplicate;
                    for (Integer value : gradient.values()) {
                        maxNum = Math.max(maxNum, value + duplicate);
                    }
                }
            }
            return maxNum;
        }

        public double div(int v1, int v2) {
            BigDecimal b1 = new BigDecimal(Integer.toString(v1));
            BigDecimal b2 = new BigDecimal(Integer.toString(v2));
            return b1.divide(b2, 20, BigDecimal.ROUND_HALF_UP).doubleValue();
        }

        //������������Լ����Ȼ�����������򱻳����ͳ�������������������
        //��3/6 = 1/2�����Խ����������
        public int gcd(int v1, int v2) {
            if (v2 == 0){
                return v1;
            }
            return gcd(v2, v1 % v2);
        }
    }
}
