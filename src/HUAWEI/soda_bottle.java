package HUAWEI;

import java.util.Scanner;

//https://www.nowcoder.com/test/question/fe298c55694f4ed39e256170ff2c205f?pid=1088888&tid=32401872
//������һ�������⣺��ĳ�̵�涨����������ˮƿ���Ի�һƿ��ˮ��С��������ʮ������ˮƿ���������Ի�����ƿ��ˮ�ȣ�
//������5ƿ���������£�����9����ƿ�ӻ�3ƿ��ˮ���ȵ�3ƿ���ģ������Ժ�4����ƿ�ӣ���3���ٻ�һƿ���ȵ���ƿ���ģ�
//��ʱ��ʣ2����ƿ�ӡ�Ȼ�������ϰ��Ƚ����һƿ��ˮ���ȵ���ƿ���ģ������Ժ���3����ƿ�ӻ�һƿ���Ļ����ϰ塣���С��������n������ˮƿ�������Ի�����ƿ��ˮ�ȣ�
//��������:
//�����ļ�������10��������ݣ�ÿ������ռһ�У�������һ��������n��1<=n<=100������ʾС�����ϵĿ���ˮƿ����n=0��ʾ�����������ĳ���Ӧ��������һ�С�
//�������:
//����ÿ��������ݣ����һ�У���ʾ�����Ժȵ���ˮƿ�������һƿҲ�Ȳ��������0��
//��������1:
//3
//10
//81
//0
//�������1:
//1
//5
//40
public class soda_bottle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            int input = scanner.nextInt();
            if (input <= 1) System.out.println(0);
            else if (input == 2) System.out.println(1);
            else System.out.println(input / 2);
        } while (scanner.hasNext());
        scanner.close();
    }
}
