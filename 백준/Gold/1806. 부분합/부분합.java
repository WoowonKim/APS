import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int S = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) arr[i] = arr[i - 1] + Integer.parseInt(stk.nextToken());
        int ans = Integer.MAX_VALUE, l = 0, r = 1;
        while (r <= N) {
            int sum = arr[r] - arr[l];
            if(sum < S) r++;
            else if(sum >= S) {
                ans = Math.min(ans, r - l);
                l++;
            }
        }
        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }

}
