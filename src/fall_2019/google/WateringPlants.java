package fall_2019.google;

public class WateringPlants {

    public int solution(int[] plants, int capacity) {
        int next = 0;
        int step = 0;
        int remainedWater = capacity;
        while (next < plants.length) {
            if (remainedWater >= plants[next]) {
                step++;
            } else {
                remainedWater = capacity;
                step += 2 * next + 1;
            }
            remainedWater -= plants[next];
            next++;
        }

        return step;
    }

    public static void main(String[] args) {
        int[] plants = new int[] {2, 4,5, 1, 2};
        WateringPlants wp = new WateringPlants();
        System.out.println("result + " + wp.solution(plants, 6));
    }
}
