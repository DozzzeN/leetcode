package Array_Matrix;

import java.util.Arrays;

//66
//����һ����������ɵķǿ���������ʾ�ķǸ��������ڸ����Ļ����ϼ�һ��
//���λ���ִ�����������λ�� ������ÿ��Ԫ��ֻ�洢�������֡�
//����Լ���������� 0 ֮�⣬��������������㿪ͷ��
//ʾ�� 1:
//����: [1,2,3]
//���: [1,2,4]
//����: ���������ʾ���� 123��
//ʾ�� 2:
//����: [4,3,2,1]
//���: [4,3,2,2]
//����: ���������ʾ���� 4321��
public class plus_one {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new plus_one.Solution().plusOne(new int[]{9, 9, 9, 9})));
    }

    static class Solution {
        public int[] plusOne(int[] digits) {
            int sum = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                sum += digits[i];
                if (sum > 9) {
                    digits[i] = sum % 10;
                    sum /= 10;
                } else {
                    digits[i] = sum;
                    break;
                }
            }
            if (digits[0] == 0) {
                int[] newArray = new int[digits.length + 1];
                newArray[0] = 1;
                //���Բ��ÿ�������ΪĬ��Ϊ0
                //System.arraycopy(digits, 0, newArray, 1, digits.length);
                return newArray;
            }
            return digits;
        }
    }
}
