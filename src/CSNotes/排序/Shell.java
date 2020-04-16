package CSNotes.����;

/**
 * ���ڴ��ģ�����飬���������������Ϊ��ֻ�ܽ������ڵ�Ԫ�أ�ÿ��ֻ�ܽ������������� 1��
 * ϣ������ĳ��־���Ϊ�˽��������������־����ԣ���ͨ�����������ڵ�Ԫ�أ�ÿ�ο��Խ������������ٴ��� 1��
 * ϣ������ʹ�ò�������Լ��h�����н�������ͨ�����ϼ�Сh�������h=1���Ϳ���ʹ����������������ġ�
 */
public class Shell<T extends Comparable<T>> extends Sort<T> {
    //3 4 5 1 2 6 7  h=4
    //2 4 5 1 3 6 7
    //2 4 5 1 3 6 7  h=1
    //2 4 5 1 3 6 7
    //2 4 5 1 3 6 7
    //2 4 1 5 3 6 7
    //2 1 4 5 3 6 7
    //1 2 4 5 3 6 7
    //1 2 4 3 5 6 7
    //1 2 3 4 5 6 7

    public static void main(String[] args) {
        Shell<Integer> shell = new Shell<>();
        shell.sort(new Integer[]{3, 4, 5, 1, 2, 6, 7});
    }

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1; // 1, 4, 13, 40, ...
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                //���Ʋ�������
                for (int j = i; j >= h && less(nums[j], nums[j - h]); j -= h) {
                    swap(nums, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}