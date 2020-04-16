package CSNotes.����;

import java.util.Arrays;

/**
 * Ͱ�����Ǽ�������������档�������˺�����ӳ���ϵ����Ч���Ĺؼ����������ӳ�亯����ȷ����Ϊ��ʹͰ������Ӹ�Ч��������Ҫ���������㣺
 * �ڶ���ռ���������£���������Ͱ������
 * ʹ�õ�ӳ�亯���ܹ��������N�����ݾ��ȵķ��䵽K��Ͱ��
 * ͬʱ������Ͱ��Ԫ�ص�����ѡ����ֱȽ������㷨�������ܵ�Ӱ��������Ҫ��
 * 1. ʲôʱ�����
 * ����������ݿ��Ծ��ȵķ��䵽ÿһ��Ͱ�С�
 * 2. ʲôʱ������
 * ����������ݱ����䵽��ͬһ��Ͱ�С�
 */
public class BucketSort<T extends Comparable<T>> extends Sort<T> {
    public static void main(String[] args) {
        BucketSort<Integer> bucketSort = new BucketSort<>();
        bucketSort.sort(new Integer[]{2, 3, 4, 5, 7, 123, 5, 32, 345, 2, 4});
    }

    @Override
    public void sort(T[] nums) {
        bucketSort(nums, 5);
    }

    private void bucketSort(T[] nums, int bucketSize) {
        T minValue = nums[0];
        T maxValue = nums[0];
        for (T value : nums) {
            if (less(value, minValue)) {
                minValue = value;
            } else if (more(value, maxValue)) {
                maxValue = value;
            }
        }

        int bucketCount = (int) Math.floor((Integer.parseInt(maxValue.toString()) - Integer.parseInt(minValue.toString())) / bucketSize) + 1;
        T[][] buckets = (T[][]) new Comparable[bucketCount][0];

        //����ӳ�亯�������ݷ��䵽����Ͱ��
        for (T num : nums) {
            int index = (int) Math.floor((Integer.parseInt(num.toString()) - Integer.parseInt(minValue.toString())) / bucketSize);
            buckets[index] = arrAppend(buckets[index], num);
        }

        int arrIndex = 0;
        for (T[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            //��ÿ��Ͱ������������ʹ���˲�������
            Insertion<T> insertion = new Insertion<>();
            insertion.sort(bucket);
            for (T value : bucket) {
                nums[arrIndex++] = value;
            }
        }
        System.out.println(1);
    }

    private T[] arrAppend(T[] nums, T value) {
        nums = Arrays.copyOf(nums, nums.length + 1);
        nums[nums.length - 1] = value;
        return nums;
    }
}
