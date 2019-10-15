package Stack;

import java.util.Stack;

//71
//�� Unix ������һ���ļ��ľ���·��������Ҫ���������߻��仰˵������ת��Ϊ�淶·����
//�� Unix �����ļ�ϵͳ�У�һ���㣨.����ʾ��ǰĿ¼�������⣬������ ��..�� ��ʾ��Ŀ¼�л�����һ����ָ��Ŀ¼�������߶������Ǹ������·������ɲ��֡�������Ϣ����ģ�Linux / Unix�еľ���·�� vs ���·��
//��ע�⣬���صĹ淶·������ʼ����б�� / ��ͷ����������Ŀ¼��֮�����ֻ��һ��б�� /�����һ��Ŀ¼����������ڣ������� / ��β�����⣬�淶·�������Ǳ�ʾ����·��������ַ�����
//ʾ�� 1��
//���룺"/home/"
//�����"/home"
//���ͣ�ע�⣬���һ��Ŀ¼������û��б�ܡ�
//ʾ�� 2��
//���룺"/../"
//�����"/"
//���ͣ��Ӹ�Ŀ¼����һ���ǲ����еģ���Ϊ��������Ե������߼���
//ʾ�� 3��
//���룺"/home//foo/"
//�����"/home/foo"
//���ͣ��ڹ淶·���У��������б����Ҫ��һ��б���滻��
//ʾ�� 4��
//���룺"/a/./b/../../c/"
//�����"/c"
//ʾ�� 5��
//���룺"/a/../../b/../c//.//"
//�����"/c"
//ʾ�� 6��
//���룺"/a//b////c/d//././/.."
//�����"/a/b/c"
public class simplify_path {
    public static void main(String[] args) {
        System.out.println(new simplify_path.Solution().simplifyPath("/..."));
    }

    static class Solution {
        public String simplifyPath(String path) {
            Stack<String> stack = new Stack<>();
            assert (path.charAt(0) == '/');
            int i = 0;
            while (i < path.length()) {
                //ע������������˳���ܵߵ�������Խ���쳣
                while (i < path.length() && path.charAt(i) == '/') i++;
                if (i == path.length()) break;
                int start = i;
                //��λ����
                while (i < path.length() && path.charAt(i) != '/') i++;
                int end = i;
                String element = path.substring(start, end);
                if (element.equals("..")) {
                    if (!stack.empty()) stack.pop();
                } else if (!element.equals(".")) stack.push(element);
            }
            if (stack.size() == 0) return "/";
            StringBuilder result = new StringBuilder();
            for (String s : stack) {
                result.append("/").append(s);
            }
            return result.toString();
        }
    }
}
