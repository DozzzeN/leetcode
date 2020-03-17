package Offer;

//https://www.nowcoder.com/practice/bd7f978302044eee894445e244c7eee6?tpId=13&tqId=11184&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字
//有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
//可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
public class the_number_of_occurrences_of_1_in_the_integer {
    public static void main(String[] args) {
        System.out.println(new the_number_of_occurrences_of_1_in_the_integer.Solution().NumberOf1Between1AndN_Solution(13));
    }

    public static class Solution {
        public int NumberOf1Between1AndN_Solution(int n) {
            int result = 0;
            for (int i = 0; i <= n; i++) {
                result += count(i);
            }
            return result;
        }

        public int count(int n) {
            int result = 0;
            while (n != 0) {
                int single = n % 10;
                if (single == 1) result++;
                n /= 10;
            }
            return result;
        }
    }
}
