package Offer;

//https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=13&tqId=11183&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//HZż������Щרҵ������������Щ�Ǽ����רҵ��ͬѧ����������鿪����,���ַ�����:
//�ڹ��ϵ�һάģʽʶ����,������Ҫ��������������������,������ȫΪ������ʱ��,����ܺý����
//����,��������а�������,�Ƿ�Ӧ�ð���ĳ������,�������Աߵ��������ֲ����أ�����:{6,-3,-2,7,-15,1,2,2},
//����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)����һ�����飬��������������������еĺͣ���᲻�ᱻ������ס��(�������ĳ���������1)
public class maximum_sum_of_consecutive_subarrays {
    public static void main(String[] args) {
        System.out.println(new maximum_sum_of_consecutive_subarrays.Solution().FindGreatestSumOfSubArray(
                new int[]{6, -3, -2, 7, -15, 1, 2, 2}
        ));
    }

    public static class Solution {
        //dp[i]:��i��β�����������������
        public int FindGreatestSumOfSubArray(int[] array) {
            int[] dp = new int[array.length];
            int max = array[0];
            dp[0] = array[0];
            for (int i = 1; i < array.length; i++) {
                dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
}
