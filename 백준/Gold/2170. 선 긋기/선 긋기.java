import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Line implements Comparable<Line> {
        int x;
        int y;

        Line(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Line o) {
            if(o.y == this.y) return o.x - this.x;
            return o.y - this.y;

        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int N = Integer.parseInt(br.readLine());
        Queue<Line> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            pq.add(new Line(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())));
        }
        long ans = 0;
        while (!pq.isEmpty()) {
            Line curr = pq.poll();
            int currY = curr.y;
            int currX = curr.x;
            while (!pq.isEmpty() && pq.peek().y >= currX ) {
                int nextX = pq.poll().x;
                if(nextX < currX) currX = nextX;
            }
            ans += currY - currX;
        }

        System.out.println(ans);
    }
}
