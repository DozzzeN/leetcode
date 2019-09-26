package BackTracking;

import java.util.LinkedList;
import java.util.List;

//46
//����һ��û���ظ����ֵ����У����������п��ܵ�ȫ���С�
//ʾ��:
//����: [1,2,3]
//���:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
public class permutation {
    //�������
    //������1��2��3����1���
    //2��ӣ��������1���п��ܲ����λ�ã�(1,2) (2,1)��ӣ�1����
    //3��ӣ��������(1,2) (2,1)���п��ܲ����λ�ã�(3,1,2) (1,3,2) (1,2,3)��� (1,2)����
    //(3,2,1) (2,3,1) (2,1,3)��� (2,1)����
    //���ӵĸ����Ǳ������Ľ׳�
    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        for (int j = 0; j < nums.length; j++) {
            if (result.size() == 0) {
                LinkedList l = new LinkedList();
                l.add(nums[j]);
                result.add(l);
            } else {
                int count = 0;
                for (int i = 0; i < result.size(); i++) {
                    LinkedList first = (LinkedList) result.getFirst();
                    for (int k = 0; k < first.size() + 1; k++) {
                        LinkedList temp = new LinkedList();
                        temp.addAll(first);
                        temp.add(k, nums[j]);
                        LinkedList temp2 = new LinkedList();
                        temp2.addAll(temp);
                        result.addLast(temp2);
                        temp.removeFirst();
                    }
                    result.removeFirst();
                    count++;
                    if (j == 1 && count == 1) {
                        break;

                    }

                    if (count == doFactorial(j)) {
                        break;
                    }
                }
            }

        }
        return result;

    }

    public static int doFactorial(int n) {
        if (n < 0) {
            return -1;//��������ݲ��Ϸ�
        }
        if (n == 0) {
            return 1;
        } else if (n == 1) {//�ݹ����������
            return 1;
        } else {
            return n * doFactorial(n - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2};
        List<List<Integer>> result = permute(a);
        System.out.println(result);
    }
}

