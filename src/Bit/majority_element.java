package Bit;

//169
//����һ����СΪ n �����飬�ҵ����е�������������ָ�������г��ִ������� [ n/2 ] ��Ԫ�ء�
//����Լ��������Ƿǿյģ����Ҹ������������Ǵ���������
//ʾ�� 1:
//����: [3,2,3]
//���: 3
//ʾ�� 2:
//����: [2,2,1,1,1,2,2]
//���: 2
public class majority_element {
    public static void main(String[] args) {
        System.out.println(new majority_element.Solution().majorityElement(new int[]{3}));
    }

    //���������ִ�����������ÿһλ���ִ�������
    static class Solution {
        public int majorityElement(int[] nums) {
            int zeroCount, oneCount, result = 0;
            int n = nums.length;
            for (int j = 0; j < 32; j++) {
                zeroCount = 0;
                oneCount = 0;
                for (int i = 0; i < n; i++) {
                    if (oneCount > n / 2 || zeroCount > n / 2) break;
                    if ((nums[i] & (1 << j)) != 0) {
                        oneCount++;
                    } else {
                        zeroCount++;
                    }
                }
                //��¼��ǰλΪ1��
                if (oneCount > zeroCount) {
                    result |= (1 << j);
                }
            }
            return result;
        }
    }
}
