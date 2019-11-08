package Math;

import java.util.ArrayList;
import java.util.List;

//264
//��дһ�������ҳ��� n ��������
//��������ֻ���������� 2, 3, 5 ����������
//ʾ��:
//����: n = 10
//���: 12
//����: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 ��ǰ 10 ��������
//˵��:
//	1 �ǳ�����
//	n ������1690��
public class ugly_number_ii {
    public static void main(String[] args) {
        System.out.println(new ugly_number_ii.Solution().nthUglyNumber(10));
    }

    //��ʱ
    //ugly[i] = min(ugly[j] * 2, ugly[j] * 3, ugly[j] * 5) 0 < j < i
    static class Solution {
        public int nthUglyNumber(int n) {
            List<Integer> ugly = new ArrayList<>();
            ugly.add(1);
            for (int i = 1; i < n; i++) {
                int temp = ugly.get(i - 1) * 2;
                for (int j = 0; j < i; j++) {
                    if (!ugly.contains(ugly.get(j) * 2)) {
                        temp = Math.min(temp,ugly.get(j) * 2);
                    }
                    if (!ugly.contains(ugly.get(j) * 3)) {
                        temp = Math.min(temp,ugly.get(j) * 3);
                    }
                    if (!ugly.contains(ugly.get(j) * 5)) {
                        temp = Math.min(temp,ugly.get(j) * 5);
                    }
                }
                ugly.add(i, temp);
            }
            return ugly.get(n - 1);
        }
    }
}
