package Offer;

//https://www.nowcoder.com/practice/7a0da8fc483247ff8800059e12d7caf1?tpId=13&tqId=11200&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
public class add_one_to_n {
    public static void main(String[] args) {
        System.out.println(new add_one_to_n.Solution().Sum_Solution(10));
    }

    public static class Solution {
        public int Sum_Solution(int n) {
            int sum = n;
            boolean temp = sum > 0 && ((sum = n + Sum_Solution(n - 1)) > 0);
            return sum;
        }
    }
}
