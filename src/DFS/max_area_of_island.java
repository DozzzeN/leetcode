package DFS;

//695
//����һ��������һЩ 0 �� 1�ķǿն�ά���� grid , һ�� ���� �����ĸ����� (ˮƽ��ֱ) �� 1 (��������) ���ɵ���ϡ�
// ����Լ����ά������ĸ���Ե����ˮ��Χ�š�
//�ҵ������Ķ�ά���������ĵ��������(���û�е��죬�򷵻����Ϊ0��)
public class max_area_of_island {
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
        public int dfs(int[][] grid, int r, int c) {
            int nr = grid.length;
            int nc = grid[0].length;

            if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == 0) {
                return 0;
            }

            int area = 1;
            grid[r][c] = 0;
            area += dfs(grid, r - 1, c);
            area += dfs(grid, r + 1, c);
            area += dfs(grid, r, c - 1);
            area += dfs(grid, r, c + 1);
            return area;
        }

        public int maxAreaOfIsland(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int nr = grid.length;
            int nc = grid[0].length;
            int maxArea = 0;
            for (int r = 0; r < nr; ++r) {
                for (int c = 0; c < nc; ++c) {
                    if (grid[r][c] == 1) {
                        maxArea = Math.max(dfs(grid, r, c), maxArea);
                    }
                }
            }
            return maxArea;
        }
    }
}


