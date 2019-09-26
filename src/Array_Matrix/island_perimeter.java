package Array_Matrix;

//463
//给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
//网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，
//但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
//岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。
//网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
//示例 :
//输入:
//[[0,1,0,0],
// [1,1,1,0],
// [0,1,0,0],
// [1,1,0,0]]
//输出: 16
public class island_perimeter {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println(new Solution().islandPerimeter(grid));
    }

    //穷举法，如果周围是0或者已经到了边界周长就自增
    static class Solution {
        public int islandPerimeter(int[][] grid) {
            int perimeter = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        if (i + 1 < grid.length && grid[i + 1][j] == 0 || i + 1 == grid.length) {
                            perimeter++;
                        }
                        if (j + 1 < grid[0].length && grid[i][j + 1] == 0 || j + 1 == grid[0].length) {
                            perimeter++;
                        }
                        if (i - 1 >= 0 && grid[i - 1][j] == 0 || i == 0) {
                            perimeter++;
                        }
                        if (j - 1 >= 0 && grid[i][j - 1] == 0 || j == 0) {
                            perimeter++;
                        }
                    }
                }
            }
            return perimeter;
        }
    }
}
