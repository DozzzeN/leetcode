package Array_Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class number_of_islands02 {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(new Solution().numIslands(grid));
        for (char[] chars : grid) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }

    //������������������ڶ�������������Ķ���ʵ�֣�
    //����ɨ��������ά�������һ�������� 1��������Ϊ����������������������
    //�����������У�����ֵ��Ϊ 0 �Ա�Ƿ��ʹ��ý�㡣���������������е�ÿ����㣬ֱ������Ϊ�ա�
    static class Solution {
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int nr = grid.length;
            int nc = grid[0].length;
            int num_islands = 0;
            for (int r = 0; r < nr; ++r) {
                for (int c = 0; c < nc; ++c) {
                    if (grid[r][c] == '1') {
                        ++num_islands;
                        grid[r][c] = '0';
                        Queue<Integer> queue = new LinkedList<>();
                        //���뵱ǰ������Ԫ�ص�λ�� ��������ʾ
                        queue.add(r * nc + c);
                        while (!queue.isEmpty()) {
                            //��ͷ����
                            int index = queue.remove();
                            int row = index / nc;
                            int col = index % nc;
                            if (row + 1 < nr && grid[row + 1][col] == '1') {
                                queue.add((row + 1) * nc + col);
                                grid[row + 1][col] = '0';
                            }
                            if (col + 1 < nc && grid[row][col + 1] == '1') {
                                queue.add((row) * nc + col + 1);
                                grid[row][col + 1] = '0';
                            }
                            if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                                queue.add((row - 1) * nc + col);
                                grid[row - 1][col] = '0';
                            }
                            if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                                queue.add(row * nc + col - 1);
                                grid[row][col - 1] = '0';
                            }
                        }
                    }
                }
            }
            return num_islands;
        }
    }
}