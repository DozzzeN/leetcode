package Offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&tqId=11163&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
//比如n=3时，2*3的矩形块有3种覆盖方法：
public class rectangular_cover {
    public static void main(String[] args) {
        System.out.println(new rectangular_cover.Solution().RectCover(7));
    }

    //超时：将target拆成若干个1/2之和
    public static class Solution {
        private Set<List<Integer>> set = new HashSet<>();

        public int RectCover(int target) {
            if (target <= 0) return 0;
            helper(target, 0, new ArrayList<>());
            return set.size();
        }

        private void helper(int target, int current, List<Integer> solution) {
            if (current == target) {
                set.add(new ArrayList<>(solution));
            } else {
                for (int i = 1; i < 3; i++) {
                    if (current + i <= target) {
                        solution.add(i);
                        helper(target, current + i, solution);
                        solution.remove(solution.size() - 1);
                    }
                }
            }
        }
    }
}
