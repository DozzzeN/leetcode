package Array_Matrix;

//ʹ�������е�ֵ��Ϊ�����±���б����������Ľ���϶���һ��������һ���ظ�Ԫ�أ�
//����ظ�Ԫ������ת���ɼ�⻷�����
public class find_the_duplicate_number02 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 2, 1};
        System.out.println(new Solution().findDuplicate(nums));
    }

    static class Solution {
        public int findDuplicate(int[] nums) {
            int slow = nums[0], fast = nums[nums[0]];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            fast = 0;
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
    }
}
