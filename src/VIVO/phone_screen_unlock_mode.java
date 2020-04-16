package VIVO;

//����һ�� 3x3 ���� Android �����ֻ�������������������� m �� n ��������ʹ������m ��������� n�������Խ�������Ļ��������Чģʽ������
//������Чģʽ��ָ��
//1��ÿ��ģʽ������������m���������n������
//2�����еļ��������ǲ�ͬ�ģ�
//3�������ģʽ��������������������ͨ���κ�����������������������ģʽ��ѡ�񣬲�����������ѡ�������ͼ����
//4��˳����أ�������Ч��������ܸ������ֻ���ͬ����
//���룺m,n
//�����������������m���������n����
//�����
//����m��n��������������Чģʽ������
//��������1:
//1,2
//�������1:
//65
//����˵��1:
//����m=1��n=2����ʾ����1���������2����������Ҫ��ļ�����1������2����������1��������Чģʽ��9�֣�
//����������Чģʽ��56�֣�����������Чģʽ������9+56=65�֣��������65��
public class phone_screen_unlock_mode {
    //û������
    public static void main(String[] args) {
        System.out.println(new phone_screen_unlock_mode.Solution().solution(2, 2));
    }

    public static class Solution {
        private static int[][] f = new int[10][10];//�����洢8���Խ���
        private static boolean[] select = new boolean[10];

        //����ĸ����ķ�Χ��[from,to]����start��ʼ����len���������
        public static int cal(int from, int to, int start, int len) {
            int count = 0;
            if (len > to) return 0;
            if (len >= from) count++;
            select[start] = true;
            System.out.println(start);
            for (int i = 1; i < 10; i++) {
                //��ǰi��δ���룬�Ҵ�start��i�Ŀ�Խ��Ҳ������
                if (!select[i] && select[f[start][i]]) {
                    count += cal(from, to, i, len + 1);
                }
            }
            select[start] = false;
            return count;
        }

        /**
         * ʵ�ַ���
         *
         * @param m int���� ����m����
         * @param n int���� ���n����
         * @return int����
         */
        public int solution(int m, int n) {
            //1 2 3
            //4 5 6
            //7 8 9
            //���ŵ�����
            f[1][3] = f[3][1] = 2;//һ�����߱���ȷ��2�Ѿ�����
            f[4][6] = f[6][4] = 5;
            f[7][9] = f[9][7] = 8;
            //���ŵ�����
            f[1][7] = f[7][1] = 4;
            f[2][8] = f[8][2] = 5;
            f[3][9] = f[9][3] = 6;
            //б��
            f[3][7] = f[7][3] = 5;
            f[1][9] = f[9][1] = 5;

            select[0] = true;

            if (n < 0 || n - m < 0) return 0;
            //1 3 7 9��������ϲ�;2 4 6 8��������ϲ�;5����һ�����
            return 4 * cal(m, n, 1, 1) + 4 * cal(m, n, 2, 1) + cal(m, n, 5, 1);
        }
    }
}
