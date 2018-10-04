package expedia_OA;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestPathTest {

    @Test
    public void findSP() {

        int[] from = new int[]{1,2,1,3,1};
        int[] to = new int[]{2,4,3,4,4};
        int[] weight = new int[]{1,1,1,2,2};

        ShortestPath sp = new ShortestPath();
        assertEquals(2, sp.findSP(4, 5, from, to, weight));

    }
}