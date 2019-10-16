package DynamicProgramming;

//63
//һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ��Start�� ����
//������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ��Finish������
//���ڿ������������ϰ����ô�����Ͻǵ����½ǽ����ж�������ͬ��·����
//�����е��ϰ���Ϳ�λ�÷ֱ��� 1 �� 0 ����ʾ��
//˵����m �� n ��ֵ�������� 100��
//ʾ�� 1:
//����:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//���: 2
//����:
//3x3 ��������м���һ���ϰ��
//�����Ͻǵ����½�һ���� 2 ����ͬ��·����
//1. ���� -> ���� -> ���� -> ����
//2. ���� -> ���� -> ���� -> ����
public class unique_paths_ii {
    public static void main(String[] args) {
        System.out.println(new unique_paths_ii.Solution().uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        }));
    }

    //step[0][0] = 1
    //step[i][j] = step[i-1][j] + step[i][j-1] i!=0 || j!=0
    //step[i][j] = 0 if array[i][j] = 1
    static class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
            if (obstacleGrid[0][0] == 1) return 0;
            int row = obstacleGrid[0].length;
            int col = obstacleGrid.length;
            int[] step = new int[row];
            step[0] = 1;
            for (int i = 0; i < col; i++) {
                for (int j = 0; j < row; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        step[j] = 0;
                    } else if (j > 0) {
                        step[j] += step[j - 1];
                    }
                }
            }
            return step[row - 1];
        }
    }
}
