package fall_2019.tripAdvisor;

import java.util.LinkedList;
import java.util.List;

public class spiralMatrix {

    List<List<Integer>> fill(int n) { // out put [0, 1, ...., n]
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (n < 0) {
            return res;
        }

        int curLayer = 0;
        int curNumber = 0;
        res.add(new LinkedList<>());
        res.get(curLayer).add(0);
        curNumber++;

        int verSteps = 1;
        int horSteps = 1;
        int direction = 0; // 0: up, 1:right, 2:down, 3:left

        while (true) {
            int numSteps = direction % 2 == 0 ? verSteps : horSteps;
            int start = curNumber;
            System.out.println("direction=" + direction);
            for (int num = start; num < start+numSteps && num <= n; num++) {
                System.out.println("num=" +num);
                switch (direction) {
                    case 0: { // up
                        if (curLayer == 0) {
                            res.add(0, new LinkedList<>());
                        }
                        if (curLayer != 0) curLayer--;
                        res.get(curLayer).add(0, num);
                        break;
                    }
                    case 1: {// right
                        res.get(curLayer).add(res.get(curLayer).size(), num);
                        break;
                    }
                    case 2: { // down
                        if (curLayer == res.size()-1) {
                            res.add(res.size(), new LinkedList<>());
                        }
                        curLayer++;
                        res.get(curLayer).add(res.get(curLayer).size(), num);
                        break;
                    }
                    case 3: { // left
                        res.get(curLayer).add(0, num);
                        break;
                    }
                }
                curNumber = num;
            }

            if (curNumber == n) {
                break;
            }
            curNumber++;

            if (direction %2 == 0) { // go up finishes
                verSteps++;
            } else if (direction %2 == 1) { // go right finishes
                horSteps++;
            }
            direction = (direction+1)%4;
        }

        return res;
    }

    public static void main(String[] args) {
        spiralMatrix sm = new spiralMatrix();
        List<List<Integer>> res = sm.fill(9);
        for (List<Integer> list: res) {
            for (int i : list) {
                System.out.print( i + " ");
            }
            System.out.println("");
        }
    }
}
