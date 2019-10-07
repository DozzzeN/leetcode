package Array_Matrix;

//27
//����һ������ nums ��һ��ֵ val������Ҫԭ���Ƴ�������ֵ���� val ��Ԫ�أ������Ƴ���������³��ȡ�
//��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
//Ԫ�ص�˳����Ըı䡣�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
public class remove_element {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(new Solution().removeElement(nums, 2));
        for (int i : nums) {
            System.out.print(i + "\t");
        }
    }

    static class Solution {
//        public int removeElement(int[] nums, int val) {
//            int result = 0;
//            for (int i = nums.length - 1; i >= 0; i--) {
//                if (nums[i] == val) {
//                    if (i != nums.length - 1) {
//                        for (int j = i; j < nums.length - 1; j++) {
//                            nums[j] = nums[j + 1];
//                        }
//                    }
//                } else {
//                    result++;
//                }
//            }
//            return result;
//        }

        //˫ָ�룬i�����������飬cur����ά�����ַ������ұ߽�
        public int removeElement(int[] nums, int val) {
            int cur = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[cur++] = nums[i];
                }
            }
            return cur;
        }
    }
}
