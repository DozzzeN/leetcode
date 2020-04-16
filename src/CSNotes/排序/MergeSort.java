package CSNotes.����;

/**
 * �鲢�����˼���ǽ�����ֳ������֣��ֱ��������Ȼ��鲢������
 */
public abstract class MergeSort<T extends Comparable<T>> extends Sort<T> {
    protected T[] aux;

    /**
     * �鲢�����������������Ѿ�����Ĳ��ֹ鲢��һ��
     */
    protected void merge(T[] nums, int l, int m, int h) {
        int i = l, j = m + 1;

        //�����ݸ��Ƶ���������
        if (h + 1 - l >= 0) System.arraycopy(nums, l, aux, l, h + 1 - l);

        for (int k = l; k <= h; k++) {
            if (i > m) {
                nums[k] = aux[j++];
            } else if (j > h) {
                nums[k] = aux[i++];
            } else if (aux[i].compareTo(aux[j]) <= 0) {
                nums[k] = aux[i++]; //�Ƚ�����һ������֤�ȶ���
            } else {
                nums[k] = aux[j++];
            }
        }
    }
}