package Array_Matrix;

//217
//����һ���������飬�ж��Ƿ�����ظ�Ԫ�ء�
//����κ�ֵ�������г����������Σ��������� true�����������ÿ��Ԫ�ض�����ͬ���򷵻� false��
//ʾ�� 1:
//����: [1,2,3,1]
//���: true
//ʾ�� 2:
//����: [1,2,3,4]
//���: false
//ʾ�� 3:
//����: [1,1,1,3,3,4,3,2,4,2]
//���: true
public class contains_duplicate {
    public static void main(String[] args) {
        System.out.println(new contains_duplicate.Solution().containsDuplicate(new int[]{3, 3}));
    }

    static class Solution {
        public boolean containsDuplicate(int[] nums) {
            if (nums == null || nums.length == 0) return false;
            int min = nums[0], max = nums[0];
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);
            }
            int[] hashtable = new int[max - min + 1];
            for (int i = 0; i < n; i++) {
                if (hashtable[nums[i] - min] == 0) {
                    hashtable[nums[i] - min] = 1;
                } else {
                    hashtable[nums[i] - min]++;
                }
            }
            for (int i = 0; i < max - min + 1; i++) {
                if (hashtable[i] > 1) {
                    return true;
                }
            }
            return false;
        }
    }
}
