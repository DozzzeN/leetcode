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
public class gray_code {
    public static void main(String[] args) {
        System.out.println(Solution.grayCode(3));
    }

    //����
    static class Solution {
        public static List<Integer> grayCode(int n) {
            List<String> result = new ArrayList<>();
            List<String> lastResult = new ArrayList<>();
            lastResult.add("0");
            lastResult.add("1");
            result.add("0");
            if (n == 0) return strToInt(result);
            if (n == 1) return strToInt(lastResult);
            for (int i = 2; i <= n; i++) {
                result = lastResult;
                lastResult = new ArrayList<>();
                int length = (int) Math.pow(2, i);
                for (int j = 0; j < length / 2; j++) {
                    lastResult.add("0" + result.get(j));
                }
                for (int j = length / 2; j < length; j++) {
                    lastResult.add("1" + result.get(length - j - 1));
                }
            }
            return strToInt(lastResult);
        }

        public static List<Integer> strToInt(List<String> stringList) {
            List<Integer> result = new ArrayList<>();
            for (String s : stringList) {
                result.add(Integer.valueOf(s, 2));
            }
            return result;
        }
    }
}
