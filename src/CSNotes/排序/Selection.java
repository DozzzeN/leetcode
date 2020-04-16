package CSNotes.����;

/**
 * ��������ѡ����СԪ�أ�����������ĵ�һ��Ԫ�ؽ���λ�á��ٴ�����ʣ�µ�Ԫ����ѡ�����С��Ԫ�أ�
 * ����������ĵڶ���Ԫ�ؽ���λ�á����Ͻ��������Ĳ�����ֱ����������������
 * ѡ��������Ҫ~N^2/2�αȽϺ�~N�ν�������������ʱ���������޹أ�
 * ����ص�ʹ������һ���Ѿ����������Ҳ��Ҫ��ô��ıȽϺͽ���������
 * <p>
 * ���ȶ���3(1) 3(2) 2 2 1��һ�������Ϊ1 3(2) 2 2 3(1)
 */
public class Selection<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(nums[j], nums[min])) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }
}