package bilibili;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//https://www.nowcoder.com/question/next?pid=16518647&qid=362330&tid=32475797
//ʵ��һ��HTML�﷨�������HTML�﷨��������£���ǩ����պϣ������ɿ�ʼ�ͽ���������ǩ�պϣ���<div></div>��Ҳ�����Ապϣ�
//��<div />
//��ǩ����Ƕ�� ��<div><a></a></div>���� <div><a/></div>�����Ǳ�ǩ���ܽ��棺<div><a></div></a>�ǲ������
//��ǩ����������� ��<div id="a<1"></div>
//���ԵĹ�����name="����������ַ�"������������֮������пո��������������Ϲ���ʱ������HTML�����﷨����
//�����ı�ֻ�������ĸa-z��<>"=
//������������ʵ��һ��HTML�﷨��������������﷨���󷵻�1��û���﷨���󷵻�0
//
//��������:
//һ�У�һ��HTML�ַ���
//�������:
//���﷨���󷵻�1��û���﷨���󷵻�0

public class implement_an_HTML_syntax_checker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (matcher(input)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static boolean matcher(String input) {
        Pattern pattern = Pattern.compile("<([a-z]+)(\\s[a-z]+=\"[a-z<>0-9]+\")*>(<[a-z]+\\s*/>)*</\\1>|<[a-z]+\\s*/>");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.find()) {
            return false;
        } else {
            //ƥ�䵽�˼���ƥ��Ƕ�׵ı�ǩ
            matcher(input.replaceAll(matcher.group(0), ""));
        }
        return true;
    }
}
