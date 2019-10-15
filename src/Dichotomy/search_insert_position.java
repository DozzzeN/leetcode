package Dichotomy;

//35
//����һ�����������һ��Ŀ��ֵ�����������ҵ�Ŀ��ֵ�������������������Ŀ��ֵ�������������У����������ᱻ��˳������λ�á�
//����Լ������������ظ�Ԫ�ء�
//ʾ�� 1:
//����: [1,3,5,6], 5
//���: 2
//ʾ�� 2:
//����: [1,3,5,6], 2
//���: 1
//ʾ�� 3:
//����: [1,3,5,6], 7
//���: 4
//ʾ�� 4:
//����: [1,3,5,6], 0
//���: 0
public class search_insert_position {
    public static void main(String[] args) {
        System.out.println(new search_insert_position.Solution().searchInsert(
                new int[]{1, 3, 5, 6}, 0
        ));
    }

    static class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] == target) return mid;
                if (mid > 0 && nums[mid] > target && nums[mid - 1] < target) return mid;
                else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }
}
