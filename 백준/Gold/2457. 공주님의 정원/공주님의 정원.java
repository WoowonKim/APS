import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Flower implements Comparable<Flower> {
        int st;
        int ed;

        Flower(StringTokenizer stk) {
            this.st = Integer.parseInt(stk.nextToken()) * 100 + Integer.parseInt(stk.nextToken());
            this.ed = Integer.parseInt(stk.nextToken()) * 100 + Integer.parseInt(stk.nextToken());
        }

        public int compareTo(Flower o) {
            if(this.st != o.st) return this.st - o.st;
            return this.ed - o.ed;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Flower> flowers = new PriorityQueue<>();
        int curr = 301;
        int end = 1201;
        int ans = 0;
        for (int i = 0; i < N; i++) flowers.add(new Flower(new StringTokenizer(br.readLine())));

        while (!flowers.isEmpty() && curr < end) {
            int temp = -1;
            while (!flowers.isEmpty() && flowers.peek().st <= curr) {
                temp = Math.max(temp, flowers.poll().ed);
            }
            if (temp == -1) break;
            curr = temp;
            ans++;
        }

        System.out.println(curr < 1201 ? 0 : ans);
    }

}
