package bilibili;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//https://www.nowcoder.com/question/next?pid=16518647&qid=362330&tid=32475797
//实现一个HTML语法检查器。HTML语法规则简化如下：标签必须闭合，可以由开始和结束两个标签闭合，如<div></div>，也可以自闭合，
//如<div />
//标签可以嵌套 如<div><a></a></div>或者 <div><a/></div>，但是标签不能交叉：<div><a></div></a>是不允许的
//标签里可以有属性 如<div id="a<1"></div>
//属性的规则是name="任意非引号字符"，多属性声明之间必须有空格，属性声明不符合规则时，整段HTML都算语法错误
//输入文本只会出现字母a-z和<>"=
//请用任意语言实现一个HTML语法检查器函数，有语法错误返回1，没有语法错误返回0
//
//输入描述:
//一行，一个HTML字符串
//输出描述:
//有语法错误返回1，没有语法错误返回0

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
            //匹配到了继续匹配嵌套的标签
            matcher(input.replaceAll(matcher.group(0), ""));
        }
        return true;
    }
}
