package Offer;

//https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tqId=11162&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//��Ŀ����
//һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������

public class pervert_jump {
    public static void main(String[] args) {
        System.out.println(new pervert_jump.Solution().JumpFloorII(3));
    }

    public static class Solution {
        public int JumpFloorII(int target) {
            return 1 << (target - 1);
        }
    }
}