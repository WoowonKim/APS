import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int ans = Integer.MAX_VALUE;
    static int[] yumi;
    static List<int[]> people;
    static int[] sel = new int[3];
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        yumi = new int[]{Integer.parseInt(str[0]), Integer.parseInt(str[1])};
        people = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            str = br.readLine().split(" ");
            people.add(new int[]{Integer.parseInt(str[0]), Integer.parseInt(str[1])});
        }
        visited = new boolean[3];
        perm(0);

        System.out.println(ans);
    }

    private static void perm(int idx) {
        if (idx == 3) {
            double temp = 0;
            Queue<int[]> order = new LinkedList<>();
            order.add(yumi);
            Arrays.stream(sel).forEach((s) -> order.add(people.get(s)));

            for (int i = 0; i < 3; i++) temp += getDist(order.poll(), order.peek());

            ans = Math.min(ans, (int) temp);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            sel[idx] = i;
            perm(idx + 1);
            visited[i] = false;
        }

    }

    static double getDist(int[] yumi, int[] person) {
        return Math.sqrt(Math.pow(yumi[0] - person[0], 2) + Math.pow(yumi[1] - person[1], 2));
    }
}
