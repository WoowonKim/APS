import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[2792] 보석 상자
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[] arr = new int[M];

        int L = 1, R = 0, mid = 0, ans = 0;

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            R = Math.max(R, arr[i]);
        }

        while (L <= R) {
            mid = (L + R) / 2;
            int sum = 0;
            for (int i = 0; i < M; i++) {
                sum += arr[i] / mid;
                if (arr[i] % mid != 0) sum++;
            }
            if (sum > N) L = mid + 1;
            else {
                R = mid - 1;
                ans = mid;
            }
        }
        System.out.println(ans);
    }

}
