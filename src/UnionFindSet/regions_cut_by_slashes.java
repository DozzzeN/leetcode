package UnionFindSet;

//959
//���� 1 x 1 ������ɵ� N x N ���� grid �У�ÿ�� 1 x 1 ������ /��\ ��ո񹹳ɡ���Щ�ַ��Ὣ���黮��ΪһЩ���ߵ�����
//����ע�⣬��б���ַ���ת��ģ���� \ �� "\\" ��ʾ������
//�����������Ŀ��
//ʾ�� 1��
//���룺
//[
//  " /",
//  "/ "
//]
//�����2
//���ͣ�2x2 �������£�
//ʾ�� 2��
//���룺
//[
//  " /",
//  "  "
//]
//�����1
//���ͣ�2x2 �������£�
//ʾ�� 3��
//���룺
//[
//  "\\/",
//  "/\\"
//]
//�����4
//���ͣ�������һ�£���Ϊ \ �ַ���ת��ģ����� "\\/" ��ʾ \/���� "/\\" ��ʾ /\����
//2x2 �������£�
//ʾ�� 4��
//���룺
//[
//  "/\\",
//  "\\/"
//]
//�����5
//���ͣ�������һ�£���Ϊ \ �ַ���ת��ģ����� "/\\" ��ʾ /\���� "\\/" ��ʾ \/����
//2x2 �������£�
//ʾ�� 5��
//���룺
//[
//  "//",
//  "/ "
//]
//�����3
//���ͣ�2x2 �������£�
//��ʾ��
//	1 <= grid.length == grid[0].length <= 30
//	grid[i][j] �� '/'��'\'���� ' '��
public class regions_cut_by_slashes {
    public static void main(String[] args) {
        System.out.println(new regions_cut_by_slashes.Solution().regionsBySlashes(new String[]{
                " /",
                "/ "
        }));
    }

    //  ��  0  ��      0 /    \ 0
    //  1     2    1 / 2   1 \ 2
    //  ��  3  ��     / 3      3 \
    //"/"���ֺ�0��1�� 2��3��
    //"\"���ֺ�0��2�� 1��3��
    //  ��  0   ��    ��   4  ��
    //  1      2 ���� 5     6
    //  ��  3   ��    ��   7  ��
    //     |           |
    //  ��  8   ��    ��  12  ��
    //  9     10 ����13    14
    //  ��  11  ��    ��  15  ��
    //����������Ӧ�ؽ��кϲ�����
    static class Solution {
        public int regionsBySlashes(String[] grid) {
            int n = grid.length;
            UnionFindSet unionFindSet = new UnionFindSet(4 * n * n);
            for (int r = 0; r < n; r++)
                for (int c = 0; c < n; c++) {
                    int index = 4 * (r * n + c);
                    char val = grid[r].charAt(c);
                    if (val != '\\') {
                        unionFindSet.Union(index, index + 1);
                        unionFindSet.Union(index + 2, index + 3);
                    }
                    if (val != '/') {
                        unionFindSet.Union(index, index + 2);
                        unionFindSet.Union(index + 1, index + 3);
                    }
                    if (r + 1 < n)
                        unionFindSet.Union(index + 3, (index + 4 * n));
                    if (r - 1 >= 0)
                        unionFindSet.Union(index, (index - 4 * n) + 3);
                    if (c + 1 < n)
                        unionFindSet.Union(index + 2, (index + 4) + 1);
                    if (c - 1 >= 0)
                        unionFindSet.Union(index + 1, (index - 4) + 2);
                }

            int result = 0;
            for (int i = 0; i < 4 * n * n; i++) {
                if (unionFindSet.Find(i) == i)
                    result++;
            }
            return result;
        }
    }
}
