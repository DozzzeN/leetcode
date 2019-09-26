package Array_Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//15
//����һ������ n ������������ nums���ж� nums ���Ƿ��������Ԫ�� a��b��c ��ʹ�� a + b + c = 0 ���ҳ��������������Ҳ��ظ�����Ԫ�顣
//����, �������� nums = [-1, 0, 1, 2, -1, -4]��
//����Ҫ�����Ԫ�鼯��Ϊ��
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
public class three_sum {
    public static void main(String[] args) {
        int[] nums = new int[]{10,0,0};
        List<List<Integer>> result = new Solution().threeSum(nums);
        System.out.println(result);
    }

    //˫ָ�뷨������תΪ����������
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums.length < 3 || nums.equals("")) {
                return result;
            }
            //��Ҫ�Ƚ�������
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                int target = 0 - nums[i];
                int start = i + 1, end = nums.length - 1;
                while (start < end) {
                    int sum = nums[start] + nums[end];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[start]);
                        list.add(nums[end]);
                        list.add(nums[i]);
                        Collections.sort(list);
                        result.add(list);
                        start++;
                        end--;
                        //�ڲ�ȥ�� [-2,0,0,2,2]�Ľ����[-2,0,2]��ȥ���ظ���[-2,0,2]
                        while (start < end && nums[start] == nums[start - 1]) {
                            start++;
                        }
                        while (start < end && nums[end] == nums[end + 1]) {
                            end--;
                        }
                    } else if (sum > target) {
                        end--;
                    } else {
                        start++;
                    }
                }
                //�ⲿȥ�� ��[-1,-1,-1,0,1]
                while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
            return result;
        }
    }
}
