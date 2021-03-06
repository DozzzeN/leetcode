package CSNotes.排序;

/**
 * 归并排序的思想是将数组分成两部分，分别进行排序，然后归并起来。
 */
public abstract class MergeSort<T extends Comparable<T>> extends Sort<T> {
    protected T[] aux;

    /**
     * 归并方法将数组中两个已经排序的部分归并成一个
     */
    protected void merge(T[] nums, int l, int m, int h) {
        int i = l, j = m + 1;

        //将数据复制到辅助数组
        if (h + 1 - l >= 0) System.arraycopy(nums, l, aux, l, h + 1 - l);

        for (int k = l; k <= h; k++) {
            if (i > m) {
                nums[k] = aux[j++];
            } else if (j > h) {
                nums[k] = aux[i++];
            } else if (aux[i].compareTo(aux[j]) <= 0) {
                nums[k] = aux[i++]; //先进行这一步，保证稳定性
            } else {
                nums[k] = aux[j++];
            }
        }
    }
}