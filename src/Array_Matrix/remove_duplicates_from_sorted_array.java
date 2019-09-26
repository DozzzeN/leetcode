package Array_Matrix;

public class remove_duplicates_from_sorted_array {
    public static void main(String[] args) {
        remove_duplicates_from_sorted_array.Solution solution = new remove_duplicates_from_sorted_array.Solution();
        int[] nums = new int[]{0,0,2,2,3,3,4};
        System.out.println("result��" + solution.removeDuplicates(nums));
    }

    //26
    //����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�
    //��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
    static class Solution {
        public int removeDuplicates(int[] nums) {
            int len = nums.length;
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; (j > i) && (j < nums.length); j++) {
                    if (i == len - 1) {//��ʱ�Ѿ��жϽ���������ĩβ��λ���ֶ���ͬ����ֹ��ѭ�����˳�
                        return len;
                    }
                    if (nums[i] == nums[j]) {
                        for (int k = i; k < nums.length - 1; k++) {
                            nums[k] = nums[k + 1];
                        }
                        len--;
                        j--;//�����������Ժ�jָ��ҲҪ����
                    }
                }
            }
            return len;
        }
    }
}


    /*public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }*/