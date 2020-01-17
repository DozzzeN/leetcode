package Array_Matrix;

//287
//����һ������ n + 1 ������������ nums�������ֶ��� 1 �� n ֮�䣨���� 1 �� n������֪���ٴ���һ���ظ���������
//����ֻ��һ���ظ����������ҳ�����ظ�������
//���ܸ���ԭ���飨����������ֻ���ģ���
//ֻ��ʹ�ö���� O(1) �Ŀռ䡣
//ʱ�临�Ӷ�С�� O(n2) ��
//e������ֻ��һ���ظ������֣��������ܲ�ֹ�ظ�����һ�Ρ�
public class find_the_duplicate_number {
    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 2, 3};
        System.out.println(new Solution().findDuplicate(nums));
    }

    static class Solution {
        public int findDuplicate(int[] nums) {
            //���ֲ��ҷ�
            int l = 1, h = nums.length - 1;
            while (l <= h) {
                int mid = l + (h - l) / 2;
                int cnt = 0;
                for (int i = 0; i < nums.length; i++) {
                    //������С��mid�ĸ���Ϊcnt
                    if (nums[i] <= mid) cnt++;
                }
                //cnt����midʱ���ظ�������������������
                if (cnt > mid) h = mid - 1;
                    //����������������
                else l = mid + 1;
            }
            return l;
        }
    }
}
