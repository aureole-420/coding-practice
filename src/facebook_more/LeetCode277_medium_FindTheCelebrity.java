package facebook_more;

public class LeetCode277_medium_FindTheCelebrity {

    private boolean knows(int a, int b) {
        return true;
    }

    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (!knows(i, candidate)) {
                candidate = i;
            }
        }

        // 确保 1。 candidate 不认识任何人， 2。 所有人都认识candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate && (!knows(i, candidate) || knows(candidate, i))) {
                return -1;
            }
        }

        return candidate;
    }

}
