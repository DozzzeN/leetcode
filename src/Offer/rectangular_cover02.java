package Offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&tqId=11163&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
//����n=3ʱ��2*3�ľ��ο���3�ָ��Ƿ�����
public class rectangular_cover02 {
    public static void main(String[] args) {
        System.out.println(new rectangular_cover02.Solution().RectCover(4));
    }

    //쳲���������
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
