package Offer;

//https://www.nowcoder.com/practice/7a0da8fc483247ff8800059e12d7caf1?tpId=13&tqId=11200&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
public class add_one_to_n {
    public static void main(String[] args) {
        System.out.println(new add_one_to_n.Solution().Sum_Solution(10));
    }

    //使用递归解法最重要的是指定返回条件，但是本题无法直接使用if语句来指定返回条件。
    //条件与&&具有短路原则，即在第一个条件语句为false的情况下不会去执行第二个条件语句。
    //利用这一特性，将递归的返回条件取非然后作为&&的第一个条件语句，递归的主体转换为第二个条件语句，
    //那么当递归的返回条件为true的情况下就不会执行递归的主体部分，递归返回。
    //本题的递归返回条件为n<=0，取非后就是n>0；递归的主体部分为sum+=Sum_Solution(n-1)，
    //转换为条件语句后就是(sum+=Sum_Solution(n-1))>0。
    public static class Solution {
        public int Sum_Solution(int n) {
            int sum = n;
            boolean temp = sum > 0 && ((sum = n + Sum_Solution(n - 1)) > 0);
            return sum;
        }
    }
}
