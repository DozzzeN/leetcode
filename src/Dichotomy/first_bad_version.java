package Dichotomy;

//278
//���ǲ�Ʒ����Ŀǰ���ڴ���һ���Ŷӿ����µĲ�Ʒ�����ҵ��ǣ���Ĳ�Ʒ�����°汾û��ͨ��������⡣����ÿ���汾���ǻ���֮ǰ�İ汾�����ģ����Դ���İ汾֮������а汾���Ǵ�ġ�
//�������� n ���汾 [1, 2, ..., n]�������ҳ�����֮�����а汾����ĵ�һ������İ汾��
//�����ͨ������ bool isBadVersion(version) �ӿ����жϰ汾�� version �Ƿ��ڵ�Ԫ�����г���ʵ��һ�����������ҵ�һ������İ汾����Ӧ�þ������ٶԵ��� API �Ĵ�����
//ʾ��:
//���� n = 5������ version = 4 �ǵ�һ������İ汾��
//���� isBadVersion(3) -> false
//���� isBadVersion(5) -> true
//���� isBadVersion(4) -> true
//���ԣ�4 �ǵ�һ������İ汾��
public class first_bad_version {
    public static void main(String[] args) {
        System.out.println(new first_bad_version.Solution().firstBadVersion(5));
    }

    static class VersionControl {
        public int[] trueOfFalse = new int[]{0, 0, 0, 0, 0};

        public boolean isBadVersion(int version) {
            return trueOfFalse[version] == 1;//����
        }
    }

    static public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int left = 0, right = n;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (!isBadVersion(mid)) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }
}
