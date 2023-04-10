import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
[13423] Three Dots
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer stk;
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            stk = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(stk.nextToken());
            Arrays.sort(arr);
            int ans = 0;
            for (int i = 0; i < N - 2; i++) {
                for (int j = 0; j < N - 1; j++) {
                    int dist = arr[j] - arr[i];
                    for (int k = j + 1; k < N; k++) {
                        if(arr[k] - arr[j] > dist) break;
                        if(arr[k] - arr[j] == dist) {
                            ans++;
                            break;
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }

}
