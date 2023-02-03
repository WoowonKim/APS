import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) arr[i] = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            int remain = arr[i];
            dp[i] = Math.max(dp[i], dp[i-1]);
            for(int j = i + 1; j <= N; j++) {
                remain = arr[j] - remain;
                if(remain < 0) break;
                if(remain == 0) dp[j] = dp[i - 1] + 1;
            }
        }
        System.out.println(N - dp[N]);
    }
}