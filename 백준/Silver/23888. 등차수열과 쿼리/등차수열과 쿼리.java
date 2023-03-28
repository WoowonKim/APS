import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {//[23888] 등차수열과 쿼리
    static int a, d;

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("./APS/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        a = Integer.parseInt(stk.nextToken());
        d = Integer.parseInt(stk.nextToken());
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            stk = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(stk.nextToken());
            int l = Integer.parseInt(stk.nextToken());
            int r = Integer.parseInt(stk.nextToken());
            System.out.println(solve(q, l, r));
        }

    }

    private static long solve(int q, long l, long r) {
        if (q == 1) {
            return a * (r - l + 1) + d * ((r + l - 2) * (r - l + 1) / 2);
        } else {
            return l == r ? a + (l - 1) * d : gcd(a, d);
        }
    }

    private static long gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
