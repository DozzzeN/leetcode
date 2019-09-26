package BFS;

import java.util.LinkedList;
import java.util.Queue;

//695
//����һ��������һЩ 0 �� 1�ķǿն�ά���� grid , һ�� ���� �����ĸ����� (ˮƽ��ֱ) �� 1 (��������) ���ɵ���ϡ�
// ����Լ����ά������ĸ���Ե����ˮ��Χ�š�
//�ҵ������Ķ�ά���������ĵ��������(���û�е��죬�򷵻����Ϊ0��)
public class max_area_of_island02 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        int[][] grid2 = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}};
        System.out.println(new Solution().maxAreaOfIsland(grid2));
    }

    //�����������
    static class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int maxArea = 0;
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int nr = grid.length;
            int nc = grid[0].length;
            for (int r = 0; r < nr; ++r) {
                for (int c = 0; c < nc; ++c) {
                    if (grid[r][c] == 1) {
                        int temp = 0;
                        grid[r][c] = 0;
                        Queue<Integer> queue = new LinkedList<>();
                        //���뵱ǰ������Ԫ�ص�λ�� ��������ʾ
                        queue.add(r * nc + c);
                        while (!queue.isEmpty()) {
                            //��ͷ����
                            temp++;
                            int index = queue.remove();
                            int row = index / nc;
                            int col = index % nc;
                            if (row + 1 < nr && grid[row + 1][col] == 1) {
                                queue.add((row + 1) * nc + col);
                                grid[row + 1][col] = 0;
                            }
                            if (col + 1 < nc && grid[row][col + 1] == 1) {
                                queue.add((row) * nc + col + 1);
                                grid[row][col + 1] = 0;
                            }
                            if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                                queue.add((row - 1) * nc + col);
                                grid[row - 1][col] = 0;
                            }
                            if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                                queue.add(row * nc + col - 1);
                                grid[row][col - 1] = 0;
                            }
                        }
                        maxArea = Math.max(maxArea, temp);
                    }
                }
            }
            return maxArea;
        }
    }
}


