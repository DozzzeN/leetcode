package Array_Matrix;

//463
//����һ������ 0 �� 1 �Ķ�ά�����ͼ������ 1 ��ʾ½�� 0 ��ʾˮ��
//�����еĸ���ˮƽ�ʹ�ֱ�����������Խ��߷�������������������ˮ��ȫ��Χ��
//������ǡ����һ�����죨����˵��һ��������ʾ½�صĸ���������ɵĵ��죩��
//������û�С������������� ָˮ���ڵ����ڲ��Ҳ��͵�����Χ��ˮ�������������Ǳ߳�Ϊ 1 �������Ρ�
//����Ϊ�����Σ��ҿ�Ⱥ͸߶Ⱦ������� 100 ���������������ܳ���
//ʾ�� :
//����:
//[[0,1,0,0],
// [1,1,1,0],
// [0,1,0,0],
// [1,1,0,0]]
//���: 16
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

    //��ٷ��������Χ��0�����Ѿ����˱߽��ܳ�������
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
