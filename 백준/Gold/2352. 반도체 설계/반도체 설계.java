import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] C = new int[N];
        int ans = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        for (int i = 0; i < N; i++) {
            int pos = Arrays.binarySearch(C, 0, ans, arr[i]);
            if(pos >= 0) continue;

            int idx = Math.abs(pos)-1;
            C[idx] = arr[i];

            if(idx == ans) ans++;
        }
        System.out.println(ans);
    }
}
