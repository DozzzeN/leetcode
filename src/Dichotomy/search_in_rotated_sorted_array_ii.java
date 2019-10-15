package Dichotomy;

//81
//���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��
//( ���磬���� [0,0,1,2,2,5,6] ���ܱ�Ϊ [2,5,6,0,0,1,2] )��
//��дһ���������жϸ�����Ŀ��ֵ�Ƿ�����������С������ڷ��� true�����򷵻� false��
//ʾ�� 1:
//����: nums = [2,5,6,0,0,1,2], target = 0
//���: true
//ʾ�� 2:
//����: nums = [2,5,6,0,0,1,2], target = 3
//���: false
public class search_in_rotated_sorted_array_ii {
    public static void main(String[] args) {
        System.out.println(new search_in_rotated_sorted_array_ii.Solution().search(
                new int[]{2, 5, 6, 0, 0, 1, 2}, 0
        ));
    }

    static class Solution {
        public boolean search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] == target) return true;
                    //target 5 in {4,5,6,2,3} ��ʱ[left,mid]�ǵ�����
                else if (nums[mid] > nums[left]) {
                    if (nums[left] <= target && target <= nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                    //target 2 in {5,0,1,2,3} ��ʱ[mid,right]�ǵ�����
                } else if (nums[mid] < nums[left]) {
                    if (nums[mid] <= target && target < nums[left]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                    //�޷�ȷ�� nums[mid] = numd[left]
                } else {
                    left++;
                }
            }
            return false;
        }
    }
}
