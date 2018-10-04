package VISA_PhoneInterview;

public class BoyerMooreVotingAlgorithm {

    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                System.out.println("new candidate: " + num + " ");
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        BoyerMooreVotingAlgorithm bmv = new BoyerMooreVotingAlgorithm();
        int[] arr = new int[]{7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 5, 5, 1, 1 ,1};
        bmv.majorityElement(arr);

    }
}
