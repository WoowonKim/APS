import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> dpq = new TreeMap<>();
            for (int i = 0; i < N; i++) {
                stk = new StringTokenizer(br.readLine());
                String comm = stk.nextToken();
                int val = Integer.parseInt(stk.nextToken());
                if (comm.equals("I")) {
                    if (dpq.containsKey(val)) dpq.replace(val, dpq.get(val) + 1);
                    else dpq.put(val, 1);
                } else if(!dpq.isEmpty()) {
                    int key;
                    if (val == -1) key = dpq.firstKey();
                    else key = dpq.lastKey();
                    if(dpq.get(key) <= 1) dpq.remove(key);
                    else dpq.replace(key, dpq.get(key) - 1);
                }
            }
            if (dpq.isEmpty()) System.out.println("EMPTY");
            else System.out.println(dpq.lastKey() + " " + dpq.firstKey());
        }
    }

}
