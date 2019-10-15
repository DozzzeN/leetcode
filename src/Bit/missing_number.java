package Bit;

//268
//����һ������ 0, 1, 2, ..., n �� n ���������У��ҳ� 0 .. n ��û�г����������е��Ǹ�����
//ʾ�� 1:
//����: [3,0,1]
//���: 2
//ʾ�� 2:
//����: [9,6,4,2,3,5,7,0,1]
//���: 8
//˵��:
//����㷨Ӧ��������ʱ�临�Ӷȡ����ܷ��ʹ�ö��ⳣ���ռ���ʵ��?
public class missing_number {
    public static void main(String[] args) {
        System.out.println(new missing_number.Solution().missingNumber(new int[]{1, 2, 3, 4, 5, 0, 7, 8, 9}));
    }

    static class Solution {
        public int missingNumber(int[] nums) {
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                result ^= (nums[i] ^ (1 + i));
            }
            return result;
        }
    }
}
