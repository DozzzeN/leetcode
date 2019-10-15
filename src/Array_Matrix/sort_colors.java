package Array_Matrix;

import java.util.Arrays;

//75
//����һ��������ɫ����ɫ����ɫ��һ�� n ��Ԫ�ص����飬ԭ�ض����ǽ�������ʹ����ͬ��ɫ��Ԫ�����ڣ������պ�ɫ����ɫ����ɫ˳�����С�
//�����У�����ʹ������ 0�� 1 �� 2 �ֱ��ʾ��ɫ����ɫ����ɫ��
//ע��:
//����ʹ�ô�����е����������������⡣
//ʾ��:
//����: [2,0,2,1,1,0]
//���: [0,0,1,1,2,2]
//���ף�
//	һ��ֱ�۵Ľ��������ʹ�ü������������ɨ���㷨��
//	���ȣ����������0��1 �� 2 Ԫ�صĸ�����Ȼ����0��1��2��������д��ǰ���顣
//	�������һ����ʹ�ó����ռ��һ��ɨ���㷨��
public class sort_colors {
    public static void main(String[] args) {
        int[] input = new int[]{2};
        new sort_colors.Solution().sortColors(input);
        System.out.println(Arrays.toString(input));
    }

    //����������Ҫɨ�����飬��һ��������ɫ����Ŀ���ڶ�������������
    //ע�⣺ֻ��������ɫ����ʹ��˫ָ��ֱ��¼��ɫ����ɫ�ı߽磬����ָ��ֱ����β���м����
    //��߽�����, nums[i]�ĵ�ֵ��0��һ��Ҫ����Ųһλ����ɨ��
    //���ұ߽����꣬nums[i]��֮ǰ��nums[blueIndex]��ֵ�����ֵ��û�б�ɨ����ģ����Բ���Ųһλ��ֱ��ɨ��i��
    static class Solution {
        public void sortColors(int[] nums) {
            int redIndex = 0, blueIndex = nums.length - 1;
            int i = 0;
            while (i < blueIndex + 1) {
                if (nums[i] == 0) {//red
                    swap(nums, i++, redIndex++);
                    continue;
                } else if (nums[i] == 2) {//blue
                    swap(nums, i, blueIndex--);
                    continue;
                }
                //white
                i++;
            }
        }

        public void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            //��left=rightʱΪ0������
            //nums[left] += nums[right];
            //nums[right] = nums[left] - nums[right];
            //nums[left] -= nums[right];
        }
    }
}
