package Offer;

import java.util.ArrayList;

//https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe?tpId=13&tqId=11194&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100��
//���������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��
//û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22��
//���ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? Good Luck!

//�������:
//������к�ΪS�������������С������ڰ��մ�С�����˳�����м䰴�տ�ʼ���ִ�С�����˳��
public class sequential_continuous_positive_numbers {
    public static void main(String[] args) {
        System.out.println(new sequential_continuous_positive_numbers.Solution().FindContinuousSequence(9));
        System.out.println(new sequential_continuous_positive_numbers.Solution().FindContinuousSequence2(9));
    }

    public static class Solution {
        //�ҵ��ƹ�ʽ��ͨ���ⷽ��
        public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            for (int i = sum; i > 0; i--) {
                ArrayList<Integer> temp = new ArrayList<>();
                if (i % 2 == 1 && (sum - ((i + 1) / 2)) % (i + 1) == 0) {
                    int a = (sum - ((i + 1) / 2)) / (i + 1) - i / 2;
                    if (a <= 0) continue;
                    for (int j = 0; j < i + 1; j++) {
                        temp.add(a + j);
                    }
                    result.add(new ArrayList<>(temp));
                } else if (i % 2 == 0 && sum % (i + 1) == 0) {
                    int a = sum / (i + 1) - i / 2;
                    if (a <= 0) continue;
                    for (int j = 0; j < i + 1; j++) {
                        temp.add(a + j);
                    }
                    result.add(new ArrayList<>(temp));
                }
            }
            return result;
        }

        /**
         * ˼·��
         * ����sum=20��1��2��3��4��5��6��7��8��9��10��11��12��13��14��15
         * 1����������ָ�룬��ָ���1��ʼ����ָ���2��ʼ
         * ѭ����ʼ
         * 2����ͣ�1+2 = 3
         * 3������ж�3С��20����ָ��++��2��Ϊ3�����3+3=6��ѭ��һֱ����ָ��=6����Ϊ21��
         * 4��else if �ж�21����20����ָ��++��1��Ϊ2���ͼ�ȥ��ָ��ֵ����Ϊ21-1=20��
         * 5��else ��������һ����������   ���ٰ���ָ��++����ͣ���ʣ����ϡ�
         * ѭ������
         */
        public ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            int left = 1, right = 2;
            int sumValue = left + right;
            while (sum > right) {
                if (sumValue < sum) {
                    right++;
                    sumValue += right;
                } else if (sumValue > sum) {
                    sumValue -= left;
                    left++;
                } else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    for (int i = left; i <= right; i++) {
                        temp.add(i);
                    }
                    result.add(temp);
                    right++;
                    sumValue += right;
                }
            }
            return result;
        }
    }
}
