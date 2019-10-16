package Array_Matrix;

//42
//���� n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ��
//������������ [0,1,0,2,1,0,1,3,2,1,2,1] ��ʾ�ĸ߶�ͼ������������£����Խ� 6 ����λ����ˮ����ɫ���ֱ�ʾ��ˮ���� ��л Marcos ���״�ͼ��
//ʾ��:
//����: [0,1,0,2,1,0,1,3,2,1,2,1]
//���: 6
public class trapping_rain_water02 {
    public static void main(String[] args) {
        System.out.println(new trapping_rain_water02.Solution().trap(new int[]{
                0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
        }));
    }

    //H[i] = min (Max(Array[j]), Max(Array[k])) - Array[i] where j<i and k<i
    //�κ�һ��bar���ݻ����������߷���ұ���߷���ȡһ����Сֵ��Ȼ���ȥ��ǰbar�ĸ߶�
    //ʹ��˫ָ�룬������Ŀ���
    static class Solution {
        public int trap(int[] height) {
            if (height.length < 2) return 0;
            int result = 0;
            int left = 0, right = height.length - 1;
            int leftMax = 0, rightMax = 0;
            while (left <= right) {
                if (leftMax <= rightMax) {
                    leftMax = Math.max(leftMax, height[left]);
                    result += Math.max(0, leftMax - height[left]);
                    left++;
                } else {
                    rightMax = Math.max(rightMax, height[right]);
                    result += Math.max(0, rightMax - height[right]);
                    right--;
                }
            }
            return result;
        }
    }
}
