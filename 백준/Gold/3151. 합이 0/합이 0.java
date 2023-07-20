import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long ans;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        ans = 0;
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(stk.nextToken());
        Arrays.sort(arr);
        solve();
        System.out.println(ans);
    }

    private static void solve() {
        if (N < 3) {
            ans = 0;
            return;
        }
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] > 0) break;

            int left = i + 1;
            int right = N - 1;

            while (left <= right) {
                int s = 1;
                int e = 1;
                int curr = arr[i] + arr[left] + arr[right];
                if (curr == 0) {
                    if (arr[left] == arr[right]) {
                        ans += comb(right - left + 1);
                        break;
                    }
                    while (left + 1 < right && arr[left] == arr[left + 1]) {
                        s++;
                        left++;
                    }
                    while (right - 1 > left && arr[right] == arr[right - 1]) {
                        e++;
                        right--;
                    }
                    ans += (long) s * e;
                }
                if (curr > 0) right--;
                else left++;
            }
        }
    }

    static int comb(int n) {
        return n * (n - 1) / 2;
    }
}