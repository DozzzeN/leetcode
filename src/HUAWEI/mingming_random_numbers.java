package HUAWEI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//https://www.nowcoder.com/question/next?pid=1088888&qid=36846&tid=32401872
//��������ѧУ����һЩͬѧһ����һ���ʾ���飬Ϊ��ʵ��Ŀ͹��ԣ������ü����������N��1��1000֮������������N��1000����
//���������ظ������֣�ֻ����һ������������ͬ����ȥ������ͬ������Ӧ�Ų�ͬ��ѧ����ѧ�š�Ȼ���ٰ���Щ����С��������
//�����źõ�˳��ȥ��ͬѧ�����顣����Э��������ɡ�ȥ�ء��롰���򡱵Ĺ���(ͬһ��������������ܻ��ж������ݣ�ϣ���������ȷ����)��
//Input Param
//n               ����������ĸ���
//inputArray      n�����������ɵ�����3
//
//Return Value
//OutputArray    ����������������
//ע������������֤�����������ȷ�ԣ�������������֤������������ֹһ�顣
//����������ͣ�
//�������������
//��һ����3�����֣��ֱ��ǣ�2��2��1��
//�ڶ�����11�����֣��ֱ��ǣ�10��20��40��32��67��40��20��89��300��400��15��
//��������:
//������У���������������ĸ�������������Ӧ����������
//�������:
//���ض��У������Ľ��
//��������1:
//3
//2
//2
//1
//11
//10
//20
//40
//32
//67
//40
//20
//89
//300
//400
//15
//�������1:
//1
//2
//10
//15
//20
//32
//40
//67
//89
//300
//400
public class mingming_random_numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputList = new ArrayList<>();
        while (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            inputList.add(input);
        }
        scanner.close();
        int[] pro = new int[inputList.size()];
        for (int i = 0; i < inputList.size(); i++) {
            pro[i] = inputList.get(i);
        }
        List<int[]> result = solution(pro);
        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }
    }

    public static List<int[]> solution(int[] input) {
        List<int[]> resultList = new ArrayList<>();
        List<int[]> inputList = new ArrayList<>();
        int i = 0, j;
        //Ϊ�˽��������붼���ո�ʽװ����������
        while (i < input.length) {
            int[] temp = new int[input[i]];
            for (j = i + 1; j - i <= input[i]; j++) {
                temp[j - i - 1] = input[j];
            }
            i += input[i] + 1;
            inputList.add(temp);
        }

        boolean[] hashTable = new boolean[1000];
        for (int[] ints : inputList) {
            Arrays.fill(hashTable, false);
            int count = 0;
            for (i = 0; i < ints.length; i++) {
                if (!hashTable[ints[i]]) {
                    hashTable[ints[i]] = true;
                    count++;
                }
            }
            int[] result = new int[count];
            for (i = 0, j = 0; i < hashTable.length; i++) {
                if (hashTable[i]) {
                    result[j] = i;
                    j++;
                }
            }
            resultList.add(result);
        }
        return resultList;
    }
}
