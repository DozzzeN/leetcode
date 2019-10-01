package String;

import java.util.HashSet;
import java.util.Set;

//128
//����һ��δ������������飬�ҳ���������еĳ��ȡ�
//Ҫ���㷨��ʱ�临�Ӷ�Ϊ O(n)��
//ʾ��:
//����: [100, 4, 200, 1, 3, 2]
//���: 4
//����: ����������� [1, 2, 3, 4]�����ĳ���Ϊ 4��
public class longest_consecutive_sequence02 {
    public static void main(String[] args) {
        System.out.println(new longest_consecutive_sequence02.Solution().longestConsecutive(new int[]{
                2147483646, -2147483647, 0, 2, 2147483644, -2147483645, 2147483645
        }));
    }

    //��ϣ�� ʱ�临�Ӷ�Ҫ��Ϊ0(n)
    //�����ڼ�������
    static class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            Set<Integer> hashTable = new HashSet<>();
            for (int num : nums) {
                hashTable.add(num);
            }
            int result = 1;
            int longLength;
            //Ҳ�ж�̬�滮��˼��
            //D[num] = D[num-1] + 1 if num-1 in the map
            //       = 1 if num-1 not in the map
            for (int num : nums) {
                longLength = 1;
                int currentNum = num;
                while (hashTable.contains(currentNum + 1)) {
                    currentNum++;
                    longLength++;
                }
                result = Math.max(result, longLength);
            }
            return result;
        }
    }
}
