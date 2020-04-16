package Offer;

//https://www.nowcoder.com/practice/f78a359491e64a50bce2d89cff857eb6?tpId=13&tqId=11199&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//ÿ����һ��ͯ��,ţ�Ͷ���׼��һЩС����ȥ�����¶�Ժ��С����,����������ˡ�HF��Ϊţ�͵�����Ԫ��,��ȻҲ׼����һЩС��Ϸ��
//����,�и���Ϸ��������:����,��С������Χ��һ����Ȧ��Ȼ��,�����ָ��һ����m,�ñ��Ϊ0��С���ѿ�ʼ������
//ÿ�κ���m-1���Ǹ�С����Ҫ���г��׸�,Ȼ���������Ʒ�����������ѡ����,���Ҳ��ٻص�Ȧ��,��������һ��С���ѿ�ʼ,
//����0...m-1����....������ȥ....ֱ��ʣ�����һ��С����,���Բ��ñ���,�����õ�ţ������ġ�����̽���ϡ���ذ�(��������Ŷ!!^_^)��
//������������,�ĸ�С���ѻ�õ������Ʒ�أ�(ע��С���ѵı���Ǵ�0��n-1)
//���û��С���ѣ��뷵��-1
public class the_last_number_left_in_the_circle {
    public static void main(String[] args) {
        System.out.println(new the_last_number_left_in_the_circle.Solution().LastRemaining_Solution(
                10, 7
        ));
    }

    public static class Solution {
        public int LastRemaining_Solution(int n, int m) {
            if (n == 0 || m == 0) return -1;
            int[] people = new int[n];
            for (int i = 0; i < n; i++) {
                people[i] = i;
            }
            int remove = -1;
            for (int left = n; left > 1; left--) {
                remove += m;
                if (remove >= left) {
                    remove %= left;
                }
                //ģ��ɾ������������ǰ�ƣ�ͬʱ����ķ�Χ��С��left
                if (n - 1 - remove >= 0) System.arraycopy(people, remove + 1, people, remove, n - 1 - remove);
                remove--;
            }
            return people[0];
        }
    }
}
