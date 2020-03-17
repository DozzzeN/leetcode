package Offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&tqId=11163&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
//比如n=3时，2*3的矩形块有3种覆盖方法：
public class rectangular_cover02 {
    public static void main(String[] args) {
        System.out.println(new rectangular_cover02.Solution().RectCover(4));
    }

    //斐波那契数列
    //fn = fn-1 + fn-2
    public static class Solution {
        public int RectCover(int target) {
            if (target <= 2) return target;
            int n_1 = 2;
            int n_2 = 1;
            int n = 0;
            for (int i = 3; i <= target; i++) {
                n = n_1 + n_2;
                n_2 = n_1;
                n_1 = n;
            }
            return n;
        }
    }
}
