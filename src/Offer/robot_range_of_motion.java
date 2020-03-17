package Offer;

//https://www.nowcoder.com/practice/6e5207314b5241fb83f2329e89fdecc8?tpId=13&tqId=11219&tPage=4&rp=4&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
//但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
//但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
public class robot_range_of_motion {
    public static void main(String[] args) {
        System.out.println(new robot_range_of_motion.Solution().movingCount(4, 4, 4));
    }

    //DFS
    public static class Solution {
        public int count = 0;

        public int movingCount(int threshold, int rows, int cols) {
            if (threshold < 0 || rows <= 0 || cols <= 0) {
                return 0;
            }
            boolean[][] visited = new boolean[rows][cols];
            moving(threshold, 0, 0, rows, cols, visited);
            return count;
        }

        public void moving(int threshold, int row, int col, int rows, int cols, boolean[][] visited) {
            if (row >= 0 && col >= 0 && row < rows && col < cols &&
                    !visited[row][col] &&
                    (row % 10 + row / 10 + col % 10 + col / 10) <= threshold) {
                visited[row][col] = true;
                count++;
                moving(threshold, row + 1, col, rows, cols, visited);
                moving(threshold, row - 1, col, rows, cols, visited);
                moving(threshold, row, col + 1, rows, cols, visited);
                moving(threshold, row, col - 1, rows, cols, visited);
            }
        }
    }
}
