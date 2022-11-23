import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;
    static long n;
    static int k, q;

    public static void main(String[] args) throws IOException {
        input();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            stk = new StringTokenizer(br.readLine());
            Long a = Long.parseLong(stk.nextToken()) - 1;
            Long b = Long.parseLong(stk.nextToken()) - 1;
            if (k == 1) {
                sb.append(Math.abs(a - b)).append("\n");
                continue;
            }
            sb.append(findSameParent(a, b, 0L)).append("\n");
        }
        System.out.println(sb);
    }

    private static Long findSameParent(Long a, Long b, Long dist) {
        while (!a.equals(b)) {
            dist++;
            if (a > b) {
                a = (a - 1) / k;
            } else {
                b = (b - 1) / k;
            }
        }
        return dist;
    }

    public static void input() throws IOException {
        stk = new StringTokenizer(br.readLine());
        n = Long.parseLong(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        q = Integer.parseInt(stk.nextToken());
    }
}

