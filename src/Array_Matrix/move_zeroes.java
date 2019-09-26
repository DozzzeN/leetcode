package Array_Matrix;

import java.util.Arrays;

//283
//����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��
public class move_zeroes {
    public static void main(String[] args) {
        int[] input = new int[]{0, 1, 0, 3, 12};
        new move_zeroes.Solution().moveZeroes(input);
        System.out.println(Arrays.toString(input));
    }

    static class Solution {
        public void moveZeroes(int[] nums) {
            int index = 0;
            for(int num:nums){
                if(num!=0){
                    nums[index++]=num;
                }
            }
            while(index<nums.length){
                nums[index++]=0;
            }
        }
    }
}
