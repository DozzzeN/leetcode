package Offer;

//https://www.nowcoder.com/practice/f78a359491e64a50bce2d89cff857eb6?tpId=13&tqId=11199&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//ÿ����һ��ͯ��,ţ�Ͷ���׼��һЩС����ȥ�����¶�Ժ��С����,����������ˡ�HF��Ϊţ�͵�����Ԫ��,��ȻҲ׼����һЩС��Ϸ��
//����,�и���Ϸ��������:����,��С������Χ��һ����Ȧ��Ȼ��,�����ָ��һ����m,�ñ��Ϊ0��С���ѿ�ʼ������
//ÿ�κ���m-1���Ǹ�С����Ҫ���г��׸�,Ȼ���������Ʒ�����������ѡ����,���Ҳ��ٻص�Ȧ��,��������һ��С���ѿ�ʼ,
//����0...m-1����....������ȥ....ֱ��ʣ�����һ��С����,���Բ��ñ���,�����õ�ţ������ġ�����̽���ϡ���ذ�(��������Ŷ!!^_^)��
//������������,�ĸ�С���ѻ�õ������Ʒ�أ�(ע��С���ѵı���Ǵ�0��n-1)
//���û��С���ѣ��뷵��-1
public class the_last_number_left_in_the_circle02 {
    public static void main(String[] args) {
        System.out.println(new the_last_number_left_in_the_circle02.Solution().LastRemaining_Solution(
                10, 7
        ));
    }

    //Լɪ�򻷣�ԲȦ����Ϊn�Ľ��ȥ�����ĳ���m���ǳ���Ϊn-1�Ľ⡣��Ϊ��ԲȦ�����������Ҫ��nȡ�ࡣ
    public static class Solution {
        public int LastRemaining_Solution(int n, int m) {
            if (n == 0) return -1;
            if (n == 1) return 0;
            return (LastRemaining_Solution(n - 1, m) + m) % n;
        }
    }
}
