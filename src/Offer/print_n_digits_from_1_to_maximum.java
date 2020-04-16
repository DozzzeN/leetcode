package Offer;

//��Ŀ����
//��������n����˳���ӡ����1������nλʮ����������������3�����ӡ��1��2��3һֱ������3λ����999��
//����˼·
//����n���ܻ�ǳ�����˲���ֱ����int��ʾ���֣�������char������д洢��
//ʹ�û��ݷ��õ����е�����
public class print_n_digits_from_1_to_maximum {
    public static void main(String[] args) {
        new print_n_digits_from_1_to_maximum().print1ToMaxOfNDigits(2);
    }

    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0) return;
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0);
    }

    private void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }

    private void printNumber(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0')
            index++;
        while (index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }
}
