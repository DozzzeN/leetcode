package Math;

import java.util.ArrayList;
import java.util.List;

//89
//���ױ�����һ������������ϵͳ���ڸ�ϵͳ�У�������������ֵ����һ��λ���Ĳ��졣
//����һ�����������λ���ķǸ����� n����ӡ����ױ������С����ױ������б����� 0 ��ͷ��
//ʾ�� 1:
//����: 2
//���: [0,1,3,2]
//����:
//00 - 0
//01 - 1
//11 - 3
//10 - 2
//���ڸ����� n������ױ������в���Ψһ��
//���磬[0,2,3,1] Ҳ��һ����Ч�ĸ��ױ������С�
//00 - 0
//10 - 2
//11 - 3
//01 - 1
public class gray_code02 {
    public static void main(String[] args) {
        System.out.println(Solution.grayCode(3));
    }

    //i����һλ��i���
    static class Solution {
        public static List<Integer> grayCode(int n) {
            List<Integer> result = new ArrayList<>();
            int size = 1 << n;
            for (int i = 0; i < size; i++) {
                result.add((i >> 1) ^ i);
            }
            return result;
        }
    }
}
