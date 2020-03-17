package Offer;

//https://www.nowcoder.com/practice/6aa9e04fc3794f68acf8778237ba065b?tpId=13&tqId=11186&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
//习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数
public class ugly_number {
    public static void main(String[] args) {
        System.out.println(new ugly_number.Solution().GetUglyNumber_Solution(10));
    }

    public static class Solution {
        public int GetUglyNumber_Solution(int index) {
            if (index == 0) return 0;
            int[] ugly = new int[index];
            ugly[0] = 1;
            int _2 = 0, _3 = 0, _5 = 0;
            for (int i = 1; i < index; i++) {
                ugly[i] = Math.min((ugly[_2] * 2), Math.min(ugly[_3] * 3, ugly[_5] * 5));
                if (ugly[i] == ugly[_2] * 2) _2++;
                if (ugly[i] == ugly[_3] * 3) _3++;
                if (ugly[i] == ugly[_5] * 5) _5++;
            }
            return ugly[index - 1];
        }
    }
}
