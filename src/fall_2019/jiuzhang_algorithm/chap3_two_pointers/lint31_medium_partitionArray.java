package fall_2019.jiuzhang_algorithm.chap3_two_pointers;

public class lint31_medium_partitionArray {

    public int partitionArray(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            while (left <= right && nums[left] < k) { // find the first element >= K
                left++;
                System.out.println("moving left index from " + (left-1) + " to " + left);
            }

            while (left <= right && nums[right] >= k) { // find the first element < k
                right--;
                System.out.println("moving right index from " + (right+1) + " to " + right);
            }

            if (left <= right) {
                System.out.println("SWAP left= " + left + " right=" + right);
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
        }

        return left;
    }

    public static void main(String[] args) {

        int[] arr = new int[] {3, 2, 3, 2, 1};
        lint31_medium_partitionArray sol = new lint31_medium_partitionArray();
        sol.partitionArray(arr, 2);
    }
}
