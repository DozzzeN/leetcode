package CSNotes.����;

/**
 * �����з�
 * �����д����ظ�Ԫ�ص����飬���Խ������з�Ϊ�����֣��ֱ��ӦС�ڡ����ںʹ����з�Ԫ�ء�
 * �����зֿ�����������д����ظ�Ԫ�ص�����������������ʱ�����������
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