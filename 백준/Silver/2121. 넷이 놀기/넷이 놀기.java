import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Pair implements Comparable<Pair> {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Pair o) {
            return this.x != o.x ? this.x - o.x : this.y - o.y;
        }
    }
    static Pair[] dots;
    static int w, h;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int N = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine());
        w = Integer.parseInt(stk.nextToken());
        h = Integer.parseInt(stk.nextToken());
        dots = new Pair[N];
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            dots[i] = new Pair(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
        }
        Arrays.sort(dots);
        int ans = 0;
        for (Pair dot : dots) {
            if(canMakeRec(dot)) ans++;
        }
        System.out.println(ans);
    }

    private static boolean canMakeRec(Pair dot) {
        Pair p1 = new Pair(dot.x + w, dot.y);
        Pair p2 = new Pair(dot.x, dot.y + h);
        Pair p3 = new Pair(dot.x + w, dot.y + h);
        if (Arrays.binarySearch(dots, p1) >= 0 && Arrays.binarySearch(dots, p2) >= 0 && Arrays.binarySearch(dots, p3) >= 0)
            return true;
        return false;
    }

}
