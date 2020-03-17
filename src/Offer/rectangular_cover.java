package Offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&tqId=11163&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
//����n=3ʱ��2*3�ľ��ο���3�ָ��Ƿ�����
public class rectangular_cover {
    public static void main(String[] args) {
        System.out.println(new rectangular_cover.Solution().RectCover(7));
    }

    //��ʱ����target������ɸ�1/2֮��
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
