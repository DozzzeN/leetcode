package Bit;

import java.util.Arrays;

//169
//����һ����СΪ n �����飬�ҵ����е�������������ָ�������г��ִ������� [ n/2 ] ��Ԫ�ء�
//����Լ��������Ƿǿյģ����Ҹ������������Ǵ���������
//ʾ�� 1:
//����: [3,2,3]
//���: 3
//ʾ�� 2:
//����: [2,2,1,1,1,2,2]
//���: 2
public class majority_element02 {
    public static void main(String[] args) {
        System.out.println(new majority_element02.Solution().majorityElement(new int[]{1, 2, 3, 3, 4, 4, 4}));
    }

    //����������ֱ������������ߵ����ݼ���˳��������ô�������±�Ϊ n/2 �����Ǵ�ͳ�����ϵ�������
    static class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }
}
