package fall_2019.jiuzhang_algorithm.chap8_stack_queue_hash_heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Lint526_medium_loadBalancer {

    public class LoadBalancer {

        private ArrayList<Integer> idList;
        private Map<Integer, Integer> server2Index;
        private Random random;

        public LoadBalancer() {
            // do intialization if necessary
            idList = new ArrayList<>();
            server2Index = new HashMap<>();
            random = new Random();
        }

        /*
         * @param server_id: add a new server to the cluster
         * @return: nothing
         */
        public void add(int server_id) {
            // write your code here
            idList.add(server_id);
            server2Index.put(server_id, idList.size() - 1);

        }

        /*
         * @param server_id: server_id remove a bad server from the cluster
         * @return: nothing
         */
        public void remove(int server_id) {
            // write your code here
            int index = server2Index.get(server_id);
            int lastServerId = idList.get(idList.size()-1);
            idList.set(index, lastServerId);
            idList.remove(idList.size()-1);
            server2Index.put(lastServerId, index);
            server2Index.remove(server_id);
        }

        /*
         * @return: pick a server in the cluster randomly with equal probability
         */
        public int pick() {
            // write your code here
            return idList.get(random.nextInt(idList.size()));
        }
    }
}
