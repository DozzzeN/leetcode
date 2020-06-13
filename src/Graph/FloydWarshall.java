package Graph;

import java.util.Arrays;

public class FloydWarshall {
    //Àý×Ó²Î¿¼https://blog.csdn.net/yuewenyao/article/details/81021319
    public static void main(String[] args) {
        long[][] edge = new long[][]{
                {0, 2, 6, 4},
                {Integer.MAX_VALUE, 0, 3, Integer.MAX_VALUE},
                {7, Integer.MAX_VALUE, 0, 1},
                {5, Integer.MAX_VALUE, 12, 0}
        };
        new Solution().FloydWarshall(edge, 4);
    }

    static class Solution {
        public void FloydWarshall(long[][] edge, int V) {
            for (int k = 0; k < V; k++) {
                for (int i = 0; i < V; i++) {
                    for (int j = 0; j < V; j++) {
                        edge[i][j] = Math.min(edge[i][j], edge[i][k] + edge[k][j]);
                    }
                }
            }
            for (long[] longs : edge) {
                System.out.println(Arrays.toString(longs));
            }
        }
    }
}
