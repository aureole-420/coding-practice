package fall_2019.microsoft;

public class leetcode42_hard_trappingRainWater {

    // 这题真实经典
    // 1. 每一个position的水位由什么决定？ min(左边最高墙 和 右边最高墙)
    // 2. 上述的两个数组可以存起来
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int N = height.length;
        int[] leftMax = new int[N];
        int[] rightMax = new int[N];

        leftMax[0] = height[0];
        for (int i = 1; i < N-1; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        rightMax[N-1] = height[N-1];
        for (int i= N-2; i > 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int sum = 0;
        for (int i = 1; i < N-1; i++) {
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return sum;
    }
}
