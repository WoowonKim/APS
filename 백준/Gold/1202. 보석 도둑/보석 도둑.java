import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static class Jewel implements Comparable<Jewel> {
        int weight;
        int price;

        public Jewel(StringTokenizer stk) {
            this.weight = Integer.parseInt(stk.nextToken());
            this.price = Integer.parseInt(stk.nextToken());
        }

        @Override
        public int compareTo(Jewel o) {
            return this.weight - o.weight;
        }
    }

    static int N, K;
    static long ans;
    static List<Jewel> jewels = new ArrayList<>();
    static PriorityQueue<Integer> bags = new PriorityQueue<>();

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            jewels.add(new Jewel(stk));
        }
        Collections.sort(jewels);
        for (int i = 0; i < K; i++) bags.offer(Integer.parseInt(br.readLine()));
    }

    public static void main(String[] args) throws Exception {
        init();

        PriorityQueue<Jewel> temp = new PriorityQueue<>((o1, o2) -> o2.price - o1.price);
        int index = 0;
        while (!bags.isEmpty()) {
            int bag = bags.poll();

            while (index < N && jewels.get(index).weight <= bag) {
                temp.add(jewels.get(index++));
            }
            if (!temp.isEmpty()) {
                ans += temp.poll().price;
            }
        }

        System.out.println(ans);
    }
}
