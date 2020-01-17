package Array_Matrix;

//11
//�� n ����ֱ�ߣ���ֱ�� i �������˵�ֱ�Ϊ (i, ai) �� (i, 0)���ҳ����е������ߣ�ʹ�������� x �Ṳͬ���ɵ�����������������ˮ��
//˵�����㲻����б�������� n ��ֵ����Ϊ 2��
//ͼ�д�ֱ�ߴ����������� [1,8,6,2,5,4,8,3,7]���ڴ�����£������ܹ�����ˮ����ʾΪ��ɫ���֣������ֵΪ 49��
//ʾ��:
//����: [1,8,6,2,5,4,8,3,7]
//���: 49
public class container_with_most_water {
    public static void main(String[] args) {
        System.out.println(new container_with_most_water.Solution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(new container_with_most_water.Solution().maxArea(new int[]{1, 1}));
    }

    static class Solution {
        //������
//        public int maxArea(int[] height) {
//            int result = 0;
//            for (int i = 0; i < height.length; i++) {
//                for (int j = height.length - 1; j > 0; j--) {
//                    result = Math.max(result, Math.abs(i - j) * Math.min(height[i], height[j]));
//                }
//            }
//            return result;
//        }
        //˫ָ�뷨������ȡ������̵��Ǹ����ӣ�ֻ��Ҫ�ƶ��̰��ָ�뼴��
        public int maxArea(int[] height) {
            int result = 0;
            for (int i = 0, j = height.length - 1; i != j; ) {
                result = Math.max(result, Math.abs(i - j) * Math.min(height[i], height[j]));
                if (height[i] > height[j]) {
                    j--;
                } else {
                    i++;
                }
            }
            return result;
        }
    }
}
