package fall_2019.microsoft;

import java.util.Scanner;

public class leetcode41_hard_firstMissingNumber {

    public int firstMissingPositive(int[] nums) {
        int i = 0;
        int N = nums.length; // expected sorted array should be [1,2,3,..., N], i.e. nums[i] == i+1

        // first pass
        while (i < N) {
            if (nums[i] == i+1) {
                i++;
            } else if (0 < nums[i] && nums[i] <= N) {
                // 尝试把nums[i] 放到合适的位置上去。i.e., 第nums[i]-1这个位置。
                // 但是注意特殊情况，如果nums[i]-1已经是正确的值，
                // 比如[1,1],那就不要swap，直接把当前值置为-1表示当前值不是应该在那儿的值。
                if (nums[nums[i]-1] == nums[i]) {
                    nums[i] = -1; i++;
                } else {
                    swap(nums, i, nums[i]-1);
                }
            } else {
                nums[i] = -1;
                i++;
            }
        }

        //second pass
        for (int j = 0; j < N; j++) {
            if (nums[j] != j+1) {
                return j+1;
            }
        }
        return N+1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username");

        String userName = myObj.nextLine();  // Read user input
        System.out.println("Username is: " + userName);  // Output user input
    }
}
