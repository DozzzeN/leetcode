package String;

//128
//����һ��δ������������飬�ҳ���������еĳ��ȡ�
//Ҫ���㷨��ʱ�临�Ӷ�Ϊ O(n)��
//ʾ��:
//����: [100, 4, 200, 1, 3, 2]
//���: 4
//����: ����������� [1, 2, 3, 4]�����ĳ���Ϊ 4��
public class longest_consecutive_sequence {
    public static void main(String[] args) {
        System.out.println(new longest_consecutive_sequence.Solution().longestConsecutive(new int[]{
                2147483646, -2147483647, 0, 2, 2147483644, -2147483645, 2147483645
        }));
    }

    //��ϣ�� ʱ�临�Ӷ�Ҫ��Ϊ0(n)
    //�����ڼ�������
    //�������鳤�������32λint�͵ģ�������������������
    static class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int maxNum = nums[0];
            int minNum = nums[0];
            for (int num : nums) {
                maxNum = Math.max(num, maxNum);
                minNum = Math.min(num, minNum);
            }
            int length = maxNum - minNum + 1;
            boolean[] hashtable = new boolean[length + 1];
            for (int num : nums) {
                hashtable[num - minNum] = true;
            }
            int result = 0;
            int current = 1;
            for (int i = 1; i < length + 1; i++) {
                if (hashtable[i - 1] && hashtable[i]) {
                    current++;
                    result = Math.max(current, result);
                } else {
                    current = 1;
                }
            }
            return result;
        }
    }
}
