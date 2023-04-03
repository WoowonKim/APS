import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//[2003] 수들의 합 2
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int[] arr = new int[N + 1];
        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] += arr[i-1] + Integer.parseInt(stk.nextToken());

        int ans = 0;

        for (int i = 0; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                if(arr[j] - arr[i] == M) ans++;
            }
        }
        System.out.println(ans);
    }

}
