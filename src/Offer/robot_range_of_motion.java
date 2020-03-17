package Offer;

//https://www.nowcoder.com/practice/6e5207314b5241fb83f2329e89fdecc8?tpId=13&tqId=11219&tPage=4&rp=4&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ��
//���ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ� ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 = 18��
//���ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19�����ʸû������ܹ��ﵽ���ٸ����ӣ�
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
