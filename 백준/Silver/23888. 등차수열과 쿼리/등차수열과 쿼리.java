import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

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
            List<Integer> input = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            System.out.println(solve(input));
        }

    }

    private static long solve(List<Integer> input) {
        long l = input.get(1);
        long r = input.get(2);
        if (input.get(0) == 1) {
            return a * (r - l + 1) + d * ((r + l - 2) * (r - l + 1) / 2);
        } else {
            return l == r ? a + (l - 1) * d : gcd(a, d);
        }
    }

    private static long gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
