package CSNotes.����;

/**
 * ��������ĺ������ڽ����������ֵת��Ϊ���洢�ڶ��⿪�ٵ�����ռ��С���Ϊһ������ʱ�临�Ӷȵ����򣬼�������Ҫ����������ݱ�������ȷ����Χ��������
 * �������Ԫ����n��0��k֮�������ʱ����������ʱ���Ǧ�(n+k)�����������ǱȽ�����������ٶȿ����καȽ������㷨��
 * ������������������C�ĳ���ȡ���ڴ��������������ݵķ�Χ�����ڴ�������������ֵ����Сֵ�Ĳ����1������ʹ�ü�������������ݷ�Χ�ܴ�����飬��Ҫ����ʱ����ڴ档���磺������������������0��100֮������ֵ���õ��㷨�����������ʺϰ���ĸ˳���������������ǣ���������������ڻ��������е��㷨���������ݷ�Χ�ܴ�����顣
 * ͨ�׵���⣬������10�����䲻ͬ���ˣ�ͳ�Ƴ���8���˵������AС����A����������ڵ�9λ,������������Եõ�����ÿ���˵�λ��,Ҳ���ź����򡣵�Ȼ���������ظ�ʱ��Ҫ���⴦����֤�ȶ��ԣ��������Ϊʲô���Ҫ�������Ŀ�����飬�Լ���ÿ�����ֵ�ͳ�Ƽ�ȥ1��ԭ��
 */
public class CountingSort<T extends Comparable<T>> extends Sort<T> {
    public static void main(String[] args) {
        CountingSort<Integer> countingSort = new CountingSort<>();
        countingSort.sort(new Integer[]{2, 3, 4, 5, 1, 2, 4, 6});
    }

    @Override
    public void sort(T[] nums) {
        T maxValue = getMaxValue(nums);
        int bucketLen = Integer.parseInt(maxValue.toString()) + 1;
        int[] bucket = new int[bucketLen];

        for (T value : nums) {
            bucket[Integer.parseInt(value.toString())]++;
        }

        for (int j = 0, sortedIndex = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                nums[sortedIndex++] = (T) Integer.valueOf(j);
                bucket[j]--;
            }
        }
    }

    private T getMaxValue(T[] nums) {
        T maxValue = nums[0];
        for (T value : nums) {
            if (less(maxValue, value)) {
                maxValue = value;
            }
        }
        return maxValue;
    }
}
