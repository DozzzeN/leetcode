package CSNotes.����;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * �鲢���������Ϊ����������ֱ����򣬲��������������鲢ʹ��������������
 * ��������ͨ��һ���з�Ԫ�ؽ������Ϊ���������飬��������С�ڵ����з�Ԫ�أ�����������ڵ����з�Ԫ�أ�������������������Ҳ�ͽ��������������ˡ�
 * <p>
 * ����������ԭ�����򣬲���Ҫ�������飬���ǵݹ������Ҫ����ջ��
 * ����������õ��������ÿ�ζ����ý�����԰�֣������ݹ���ô����������ٵġ���������±Ƚϴ���ΪCN=2CN/2+N�����Ӷ�Ϊ O(NlogN)��
 * �������£���һ�δ���С��Ԫ���з֣��ڶ��δӵڶ�С��Ԫ���з֣������㡣�������������Ҫ�Ƚ�N^2/2��
 * Ϊ�˷�ֹ�����ʼ��������ģ��ڽ��п�������ʱ��Ҫ����������顣
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    //3 4 5 1 2 6 7
    //5 6 7 4 3 1 2 shuffle
    //5 2 7 4 3 1 6
    //5 2 1 4 3 7 6 i=5 j=4
    //3 2 1 4 5 7 6
    public static void main(String[] args) {
        QuickSort<Integer> quickSort = new QuickSort<>();
        quickSort.sort(new Integer[]{3, 4, 5, 1, 2, 6, 7});
    }

    @Override
    public void sort(T[] nums) {
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
    }

    protected void sort(T[] nums, int l, int h) {
        if (h <= l) return;
        int j = partition(nums, l, h);
        sort(nums, l, j - 1);
        sort(nums, j + 1, h);
    }

    private void shuffle(T[] nums) {
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }

    /**
     * ȡa[l]��Ϊ�з�Ԫ�أ�Ȼ���������������ɨ��ֱ���ҵ���һ�����ڵ�������Ԫ�أ�
     * �ٴ�������Ҷ�����ɨ���ҵ���һ��С������Ԫ�أ�����������Ԫ�ء����Ͻ���������̣�
     * �Ϳ��Ա�֤��ָ��i�����Ԫ�ض��������з�Ԫ�أ���ָ��j���Ҳ�Ԫ�ض���С���з�Ԫ�ء�
     * ������ָ������ʱ�����з�Ԫ��a[l]��a[j]����λ�á�
     */
    private int partition(T[] nums, int l, int h) {
        int i = l, j = h + 1;
        T v = nums[l];
        //��l+1��h������nums[l]�ıȽ�
        while (true) {
            while (less(nums[++i], v) && i != h) ;
            while (less(v, nums[--j]) && j != l) ;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }


    /**
     * ���������partition()�������᷵��һ������jʹ��a[l..j-1]С�ڵ���a[j]����a[j+1..h]���ڵ���a[j]����ʱa[j]��������ĵ�j��Ԫ�ء�
     * ����������������ҳ�����ĵ�k��Ԫ�ء�
     * ���㷨�����Լ���ģ�����ÿ���ܽ�������֣���ô�Ƚϵ��ܴ���Ϊ (N+N/2+N/4+..)��ֱ���ҵ���k��Ԫ�أ��������ȻС��2N��
     */
    public T select(T[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (h > l) {
            int j = partition(nums, l, h);
            if (j == k) {
                return nums[k];
            } else if (j > k) {
                h = j - 1;
            } else {
                l = j + 1;
            }
        }
        return nums[k];
    }
}