package UnionFindSet;

//765
//N �����������������е� 2N ����λ�ϣ���Ҫǣ���Է����֡� �������ٽ�����λ�Ĵ������Ա�ÿ�����¿��Բ�������һ�� һ�ν�����ѡ���������ˣ�������վ����������λ��
//�˺���λ�� 0 �� 2N-1 ��������ʾ�������ǰ�˳���ţ���һ���� (0, 1)���ڶ����� (2, 3)���Դ����ƣ����һ���� (2N-2, 2N-1)��
//��Щ���µĳ�ʼ��λ  row[i] �������ʼ���ڵ� i ����λ�ϵ��˾����ġ�
//ʾ�� 1:
//����: row = [0, 2, 1, 3]
//���: 1
//����: ����ֻ��Ҫ����row[1]��row[2]��λ�ü��ɡ�
//ʾ�� 2:
//����: row = [3, 2, 0, 1]
//���: 0
//����: ���轻����λ�����е����¶��Ѿ�������ǣ���ˡ�
//˵��:
//	len(row) ��ż������ֵ�� [4, 60]��Χ�ڡ�
//	���Ա�֤row ������ 0...len(row)-1 ��һ��ȫ���С�
public class couples_holding_hands {
    public static void main(String[] args) {
        System.out.println(new couples_holding_hands.Solution().minSwapsCouples(new int[]{
                5, 6, 4, 0, 2, 1, 9, 3, 8, 7, 11, 10
        }));
    }

    //�������� ��ԭ����ÿ����Ԫ�ؽ��л���
    //�����鱣��ż����������������ͼ�һ
    //���鼯�ϲ��������ÿһ�У������Ҫ���鼯��find(i)!=i�ľ���Ҫ����
    static class Solution {
        public int minSwapsCouples(int[] row) {
            int result = 0;
            if (row == null || row.length == 0) return result;
            UnionFindSet unionFindSet = new UnionFindSet(row.length);
            int[][] couple = new int[row.length / 2][2];
            for (int i = 0; i < row.length - 1; i++) {
                if (i % 2 == 0) {
                    couple[i / 2][0] = row[i] % 2 == 0 ? row[i] : row[i] - 1;
                    couple[i / 2][1] = row[i + 1] % 2 == 0 ? row[i + 1] : row[i + 1] - 1;
                }
            }
            for (int i = 0; i < row.length / 2; i++) {
                unionFindSet.Union(couple[i][0], couple[i][1]);
            }
            for (int i = 0; i < row.length; i++) {
                if (unionFindSet.Find(i) != i) {
                    result++;
                }
            }
            return result;
        }
    }
}
