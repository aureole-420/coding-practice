package facebook_more;
import java.util.*;

public class Leetcode42_TrappingRainWater {

    public int trap(int[] height) {
        // from left to right;
        int[] water = new int[height.length];
        List<int[]> left2right = new ArrayList<>();
        int left = 0;

        for (int i = 1; i < height.length;) {
            if (i == height.length-1) {
                left2right.add(new int[]{left, i, Math.min(height[left], height[i])});
                break;
            }
            if (height[i] <= height[left]) {
                i++;
            } else {
                // found right
                left2right.add(new int[]{left, i, height[left]});
                left = i;
                i++;
            }
        }

        int sum = 0;

        for (int j = 0; j < left2right.size(); j++) {
            int[] abra = left2right.get(j);
            int l = abra[0];
            int r = abra[1];
            int h = abra[2];
            for (int i = l+1; i < r; i++) {
                if (height[i] < h) {
                    sum += h-height[i];
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        Leetcode42_TrappingRainWater tr = new Leetcode42_TrappingRainWater();
        System.out.print(tr.trap(height));

    }
}
