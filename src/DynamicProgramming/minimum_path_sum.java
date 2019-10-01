package DynamicProgramming;

//64
//����һ�������Ǹ������� m x n �������ҳ�һ�������Ͻǵ����½ǵ�·����ʹ��·���ϵ������ܺ�Ϊ��С��
//˵����ÿ��ֻ�����»��������ƶ�һ����
//ʾ��:
//����:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//���: 7
//����: ��Ϊ·�� 1��3��1��1��1 ���ܺ���С��
public class minimum_path_sum {
    public static void main(String[] args) {
        System.out.println(new minimum_path_sum.Solution().minPathSum(new int[][]{
                {1, 3, 1}, {1, 5, 1}, {4, 2, 1}
        }));
    }

    //Min[i][j]�Ǵ����Ϸ���grid[i][j]�����·��
    static class Solution {
        public int minPathSum(int[][] grid) {
            if (grid.length == 0) return 0;
            int[][] Min = new int[grid.length][grid[0].length];
            Min[0][0] = grid[0][0];
            for (int i = 1; i < grid.length; i++) {
                Min[i][0] = Min[i - 1][0] + grid[i][0];
            }
            for (int i = 1; i < grid[0].length; i++) {
                Min[0][i] = Min[0][i - 1] + grid[0][i];
            }
            for (int i = 1; i < grid.length; i++) {
                for (int j = 1; j < grid[0].length; j++) {
                    Min[i][j] = Math.min(Min[i - 1][j], Min[i][j - 1]) + grid[i][j];
                }
            }
            return Min[grid.length - 1][grid[0].length - 1];
        }
    }
}
