package Stack;

import java.util.Stack;

//42
//���� n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ��
//������������ [0,1,0,2,1,0,1,3,2,1,2,1] ��ʾ�ĸ߶�ͼ������������£����Խ� 6 ����λ����ˮ����ɫ���ֱ�ʾ��ˮ���� ��л Marcos ���״�ͼ��
//ʾ��:
//����: [0,1,0,2,1,0,1,3,2,1,2,1]
//���: 6
public class trapping_rain_water03 {
    public static void main(String[] args) {
        System.out.println(new trapping_rain_water03.Solution().trap(new int[]{
                0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
        }));
    }

    //�����ڱ�������ʱά��һ��ջ�������ǰ�����ο�С�ڻ����ջ�������ο飬���ǽ����ο��������ջ����˼�ǵ�ǰ�����ο鱻ջ�е�ǰһ�����ο�綨��
    //������Ƿ���һ�����ο鳤��ջ�������ǿ���ȷ��ջ�������ο鱻��ǰ���ο��ջ��ǰһ�����ο�綨��������ǿ��Ե���ջ��Ԫ�ز����ۼӴ𰸵� ans ��
    static class Solution {
        public int trap(int[] height) {
            if (height.length < 2) return 0;
            int result = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < height.length; i++) {
                while (!stack.empty() && height[i] > height[stack.peek()]) {
                    int top = stack.peek();
                    stack.pop();
                    if (stack.empty()) break;
                    result += (i - stack.peek() - 1) * (Math.min(height[i], height[stack.peek()]) - height[top]);
                }
                stack.push(i);
            }
            return result;
        }
    }
}
