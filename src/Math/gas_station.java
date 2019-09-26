package Math;

//134
//��һ����·���� N ������վ�����е� i ������վ������ gas[i] ����
//����һ�������������޵ĵ��������ӵ� i ������վ������ i+1 ������վ��Ҫ�������� cost[i] ����������е�һ������վ��������ʼʱ����Ϊ�ա�
//���������ƻ�·��ʻһ�ܣ��򷵻س���ʱ����վ�ı�ţ����򷵻� -1��
//˵��:
//	�����Ŀ�н⣬�ô𰸼�ΪΨһ�𰸡�
//	���������Ϊ�ǿ����飬�ҳ�����ͬ��
//	���������е�Ԫ�ؾ�Ϊ�Ǹ�����
//ʾ�� 1:
//����:
//gas  = [1,2,3,4,5]
//cost = [3,4,5,1,2]
//���: 3
//����:
//�� 3 �ż���վ(����Ϊ 3 ��)�������ɻ�� 4 �����͡���ʱ������ = 0 + 4 = 4 ������
//���� 4 �ż���վ����ʱ������ 4 - 1 + 5 = 8 ������
//���� 0 �ż���վ����ʱ������ 8 - 2 + 1 = 7 ������
//���� 1 �ż���վ����ʱ������ 7 - 3 + 2 = 6 ������
//���� 2 �ż���վ����ʱ������ 6 - 4 + 3 = 5 ������
//���� 3 �ż���վ������Ҫ���� 5 �����ͣ������㹻�㷵�ص� 3 �ż���վ��
//��ˣ�3 ��Ϊ��ʼ������
public class gas_station {
    public static void main(String[] args) {
        System.out.println(new gas_station.Solution().canCompleteCircuit(
                new int[]{1, 2, 3, 4, 5},
                new int[]{3, 4, 5, 1, 2}
        ));
    }

    //diff[i] = gas[i] - cost[i]
    //������diff֮��С��0���޽�
    //�н�ʱ��������sum[i,j] = ��diff[k] where i <= k < j
    //�ҵ���һ��sum[i,j] > 0��i��Ϊ���
    //������0��n֮�䣬�ҵ�����0�ĵ�һ������������
    static class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int[] diff = new int[gas.length];
            for (int i = 0; i < gas.length; i++) {
                diff[i] = gas[i] - cost[i];
            }
            int sum = 0, result = 0, total = 0;
            for (int i = 0; i < diff.length; i++) {
                total += diff[i];
                sum += diff[i];
                if (sum < 0) {
                    //����һ����վ��ʼ
                    result = i + 1;
                    sum = 0;
                }
            }
            if (total < 0) {
                return -1;
            } else {
                return result;
            }
        }
    }
}
