package Dichotomy;

//33
//���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��
//( ���磬���� [0,1,2,4,5,6,7] ���ܱ�Ϊ [4,5,6,7,0,1,2] )��
//����һ��������Ŀ��ֵ����������д������Ŀ��ֵ���򷵻��������������򷵻� -1 ��
//����Լ��������в������ظ���Ԫ�ء�
//����㷨ʱ�临�Ӷȱ����� O(log n) ����
//ʾ�� 1:
//����: nums = [4,5,6,7,0,1,2], target = 0
//���: 4
//ʾ�� 2:
//����: nums = [4,5,6,7,0,1,2], target = 3
//���: -1
public class search_in_rotated_sorted_array {
    public static void main(String[] args) {
        System.out.println(new search_in_rotated_sorted_array.Solution().search(
                new int[]{4, 5, 6, 7, 0, 1, 2}, 0
        ));
    }

    //������һ��Ϊ��������һ����һ��������ģ���һ������������Ҳ���ǲ�������
    //��ʱ���򲿷��ö��ַ����ҡ����򲿷���һ��Ϊ��������һ��һ��������һ���������򣬿������򡣾�����ѭ��.
    static class Solution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] == target) return mid;
                    //target 5 in {4,5,6,2,3} ��ʱ[left,mid]�ǵ�����
                else if (nums[mid] >= nums[left]) {
                    if (nums[left] <= target && target <= nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                    //target 2 in {5,0,1,2,3} ��ʱ[mid,right]�ǵ�����
                } else {
                    if (nums[mid] <= target && target < nums[left]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
}
