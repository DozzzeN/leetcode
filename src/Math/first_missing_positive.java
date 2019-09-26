package Math;

//41
//����һ��δ������������飬�ҳ�����û�г��ֵ���С����������
//
//ʾ�� 1:
//����: [1,2,0]
//���: 3
//ʾ�� 2:
//����: [3,4,-1,1]
//���: 2
//ʾ�� 3:
//����: [7,8,9,11,12]
//���: 1
public class first_missing_positive {
    public static void main(String[] args) {
        System.out.println(new first_missing_positive.Solution().firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }

    static class Solution {
        public int firstMissingPositive(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] != i + 1) {
                    if (nums[i] <= 0 || nums[i] > nums.length || nums[i] == nums[nums[i] - 1]) {
                        break;
                    }
                    int temp = nums[i];
                    nums[i] = nums[temp - 1];
                    nums[temp - 1] = temp;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }
            return nums.length + 1;
        }
    }
}
