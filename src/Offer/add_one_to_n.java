package Offer;

//https://www.nowcoder.com/practice/7a0da8fc483247ff8800059e12d7caf1?tpId=13&tqId=11200&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
public class add_one_to_n {
    public static void main(String[] args) {
        System.out.println(new add_one_to_n.Solution().Sum_Solution(10));
    }

    //ʹ�õݹ�ⷨ����Ҫ����ָ���������������Ǳ����޷�ֱ��ʹ��if�����ָ������������
    //������&&���ж�·ԭ�򣬼��ڵ�һ���������Ϊfalse������²���ȥִ�еڶ���������䡣
    //������һ���ԣ����ݹ�ķ�������ȡ��Ȼ����Ϊ&&�ĵ�һ��������䣬�ݹ������ת��Ϊ�ڶ���������䣬
    //��ô���ݹ�ķ�������Ϊtrue������¾Ͳ���ִ�еݹ�����岿�֣��ݹ鷵�ء�
    //����ĵݹ鷵������Ϊn<=0��ȡ�Ǻ����n>0���ݹ�����岿��Ϊsum+=Sum_Solution(n-1)��
    //ת��Ϊ�����������(sum+=Sum_Solution(n-1))>0��
    public static class Solution {
        public int Sum_Solution(int n) {
            int sum = n;
            boolean temp = sum > 0 && ((sum = n + Sum_Solution(n - 1)) > 0);
            return sum;
        }
    }
}
