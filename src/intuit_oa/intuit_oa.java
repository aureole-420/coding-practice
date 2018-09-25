package intuit_oa;

import java.io.*;

public class intuit_oa {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/yuhuitong/eclipse-workspace/coding-practice/src/intuit_oa/data.txt"));
//            String path = System.getProperty("user.dir") + "/src/intuit_oa/data.txt";
//            BufferedReader br = new BufferedReader(new FileReader(path));
            for (String line; (line = br.readLine()) != null; ) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
