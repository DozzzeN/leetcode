package Math;

import java.math.BigDecimal;
import java.util.HashMap;

//149
//给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
//示例 1:
//输入: [[1,1],[2,2],[3,3]]
//输出: 3
//解释:
//^
//|
//|        o
//|     o
//|  o
//+------------->
//0  1  2  3  4
//示例 2:
//输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//输出: 4
//解释:
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

    //使用哈希表存储斜率
    static class Solution {
        public int maxPoints(int[][] points) {
            HashMap<Double, Integer> gradient = new HashMap<>();
            int maxNum = points.length == 1 ? 1 : 0;
            for (int i = 0; i < points.length; i++) {
                gradient.clear();
                int duplicate = 1;
                for (int j = 0; j < points.length; j++) {
                    //同一个节点忽略
                    if (j == i) continue;
                    //相同节点
                    if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                        duplicate++;
                    } else {
                        //注意这里计算的是斜率的倒数（为了解决精度问题）
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

        //还可以求出最大公约数，然后再用它化简被除数和除数，保留最简的两个数
        //如3/6 = 1/2，可以解决精度问题
        public int gcd(int v1, int v2) {
            if (v2 == 0){
                return v1;
            }
            return gcd(v2, v1 % v2);
        }
    }
}
