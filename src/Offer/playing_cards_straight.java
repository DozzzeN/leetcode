package Offer;

import java.util.Arrays;
import java.util.TreeSet;

//https://www.nowcoder.com/practice/762836f4d43d43ca9deb273b3de8e1f4?tpId=13&tqId=11198&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,2��С��(һ����ԭ����54��^_^)...��������г����5����,
//�����Լ�������,�����ܲ��ܳ鵽˳��,����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���������A,����3,С��,����,��Ƭ5��,��Oh My God!��
//����˳��.....LL��������,��������,������\С �����Կ����κ�����,����A����1,JΪ11,QΪ12,KΪ13��
//�����5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So Lucky!����LL����ȥ��������Ʊ����
//����,Ҫ����ʹ�������ģ������Ĺ���,Ȼ���������LL��������Σ� ����������˳�Ӿ����true����������false��Ϊ�˷������,�������Ϊ��С����0��
public class playing_cards_straight {
    public static void main(String[] args) {
        System.out.println(new playing_cards_straight.Solution().isContinuous(new int[]{
                1, 3, 0, 0, 5
        }));
        System.out.println(new playing_cards_straight.Solution().isContinuous02(new int[]{
                1, 3, 0, 0, 5
        }));
    }

    public static class Solution {
        public boolean isContinuous(int[] numbers) {
            if (numbers == null || numbers.length == 0) return false;
            //ʹ��TreeSet��������
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < numbers.length - 1; i++) {
                //�������ظ�����
                if (set.contains(numbers[i])) return false;
                if (numbers[i] != 0)
                    set.add(numbers[i]);
            }
            return set.last() - set.first() < 5;
        }

        public boolean isContinuous02(int[] nums) {
            if (nums.length < 5) return false;
            Arrays.sort(nums);
            //ͳ���������
            int cnt = 0;
            for (int num : nums)
                if (num == 0)
                    cnt++;
            //ʹ�����ȥ��ȫ��������˳��
            for (int i = cnt; i < nums.length - 1; i++) {
                if (nums[i + 1] == nums[i]) return false;
                cnt -= nums[i + 1] - nums[i] - 1;
            }
            return cnt >= 0;
        }
    }
}
