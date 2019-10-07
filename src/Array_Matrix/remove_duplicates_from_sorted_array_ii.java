package Array_Matrix;

import java.util.Arrays;

//80
//����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ�����������Σ������Ƴ���������³��ȡ�
//��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
//ʾ�� 1:
//���� nums = [1,1,1,2,2,3],
//����Ӧ�����³��� length = 5, ����ԭ�����ǰ���Ԫ�ر��޸�Ϊ 1, 1, 2, 2, 3 ��
//�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
//ʾ�� 2:
//���� nums = [0,0,1,1,1,1,2,3,3],
//����Ӧ�����³��� length = 7, ����ԭ�����ǰ���Ԫ�ر��޸�Ϊ 0, 0, 1, 1, 2, 3, 3 ��
//�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
public class remove_duplicates_from_sorted_array_ii {
    public static void main(String[] args) {
        remove_duplicates_from_sorted_array_ii.Solution solution = new remove_duplicates_from_sorted_array_ii.Solution();
        int[] nums = new int[]{1, 1, 1, 1, 2, 2, 3};
        System.out.println("result��" + solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    //��δ���
    static class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) return 0;
            int occur = 1;
            int i = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] != nums[i]) {
                    occur = 1;
                } else {
                    //ʹ��occur���Ϊ2
                    if (occur == 2) {
                        continue;
                    } else {
                        occur++;
                    }
                }
                //ֻҪoccur������2������nums[i]��nums[j]�Ƿ���ȶ�Ҫ���и���jԪ�أ����ƵĴ������Ϊ2��
                i++;
                nums[i] = nums[j];
            }
            return i + 1;
        }
    }
}
