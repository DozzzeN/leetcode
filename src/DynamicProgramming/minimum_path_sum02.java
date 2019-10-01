package DynamicProgramming;

import java.util.Arrays;

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
public class minimum_path_sum02 {
    public static void main(String[] args) {
        System.out.println(new minimum_path_sum02.Solution().minPathSum(new int[][]{
                {1, 3, 1}, {1, 5, 1}, {4, 2, 1}
        }));
    }

    //Min[i][j]�Ǵ����Ϸ���grid[i][j]�����·��
    //��������
    static class Solution {
        public int minPathSum(int[][] grid) {
            if (grid.length == 0) return 0;
            int[] Min = new int[grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                Min[0] += grid[i][0];
                for (int j = 1; j < grid[0].length; j++) {
                    Min[j] = (Min[j] == 0 ? Min[j - 1] : Math.min(Min[j - 1], Min[j])) + grid[i][j];
                }
            }
            return Min[grid[0].length - 1];
        }
    }
}
