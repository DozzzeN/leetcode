package CSNotes.排序;

/**
 * 三向切分
 * 对于有大量重复元素的数组，可以将数组切分为三部分，分别对应小于、等于和大于切分元素。
 * 三向切分快速排序对于有大量重复元素的随机数组可以在线性时间内完成排序。
 */
public class ThreeWayQuickSort<T extends Comparable<T>> extends QuickSort<T> {
    //3 4 5 1 2 6 7 shuffle
    //3 5 4 2 1 7 6 l=0 h=6 lt=0 i=1 gt=6
    //3 6 4 2 1 7 5 l=0 h=6 lt=0 i=1 gt=5
    //3 7 4 2 1 6 5 l=0 h=6 lt=0 i=1 gt=4
    //3 1 4 2 7 6 5                  gt=3
    //1 3 4 2 7 6 5 l=0 h=6 lt=1 i=2 gt=3
    public static void main(String[] args) {
        ThreeWayQuickSort<Integer> threeWayQuickSort = new ThreeWayQuickSort<>();
        threeWayQuickSort.sort(new Integer[]{3, 4, 5, 1, 2, 6, 7});
    }

    @Override
    protected void sort(T[] nums, int l, int h) {
        if (h <= l) return;
        int lt = l, i = l + 1, gt = h;
        T v = nums[l];
        while (i <= gt) {
            int cmp = nums[i].compareTo(v);
            if (cmp < 0) swap(nums, lt++, i++);
            else if (cmp > 0) swap(nums, i, gt--);
            else i++;
        }
        sort(nums, l, lt - 1);
        sort(nums, gt + 1, h);
    }
}