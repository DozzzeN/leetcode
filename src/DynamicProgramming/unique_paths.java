package DynamicProgramming;

//62
//һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ��Start�� ����
//������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ��Finish������
//���ܹ��ж�������ͬ��·����
//���磬��ͼ��һ��7 x 3 �������ж��ٿ��ܵ�·����
//˵����m �� n ��ֵ�������� 100��
//ʾ�� 1:
//����: m = 3, n = 2
//���: 3
//����:
//�����Ͻǿ�ʼ���ܹ��� 3 ��·�����Ե������½ǡ�
//1. ���� -> ���� -> ����
//2. ���� -> ���� -> ����
//3. ���� -> ���� -> ����
//ʾ�� 2:
//����: m = 7, n = 3
//���: 28
public class unique_paths {
    public static void main(String[] args) {
        System.out.println(new unique_paths.Solution().uniquePaths(7, 3));
    }

    //step[0][0] = 1
    //step[i][j] = step[i-1][j] + step[i][j-1] i!=0 || j!=0
    //����Ϊ����ʾ
    //1 1 1 1
    //1 2 3 4
    //1 3 4 5
    //ʹ�ù������� ���б���
    static class Solution {
        public int uniquePaths(int m, int n) {
            int[] step = new int[n];
            step[0] = 1;
            for (int i = 0; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    step[j] += step[j - 1];
                }
            }
            return step[n - 1];
        }
    }
}
