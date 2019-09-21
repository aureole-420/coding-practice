package fall_2019.airbnb;

public class oa1_candy {

    //
    public int minApetite(int[] candyPiles, int numHours) {
        int lo = 1;
        int hi = Integer.MIN_VALUE;
        for (int candy : candyPiles) {
            hi = Math.max(hi, candy);
        }

        while (lo + 1 < hi) {
//            System.out.println("lo=" + lo + " hi = " + hi);
            int mid = lo + (hi-lo) / 2;
            if (canFinish(candyPiles, numHours, mid)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        if (canFinish(candyPiles, numHours, lo)) {
            return lo;
        } else {
            return hi;
        }
    }

    // eat c candy every hour.
    private boolean canFinish(int[] candyPiles, int numHours, int c) {
//        System.out.println("c = " + c);
        int hoursUsed = 0;
        int i = 0;
        int candyLeftInPiles= 0;
        while (i < candyPiles.length && hoursUsed <= numHours) {
            if (candyLeftInPiles <= 0) {
                candyLeftInPiles = candyPiles[i];
            }
            if (candyLeftInPiles > 0) {
                candyLeftInPiles -= c;
                hoursUsed++;
            }
            if (candyLeftInPiles <= 0) {
                i++;
            }
        }

        if (hoursUsed < numHours || candyLeftInPiles <= 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] candyPiles = new int[] {4, 9, 11, 17};
        oa1_candy oc = new oa1_candy();
        System.out.println(oc.minApetite(candyPiles, 8));
    }
}
